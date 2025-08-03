#!/usr/bin/env python3

import os
import re
import argparse
from pathlib import Path

def find_included_modules(project_root: Path) -> list[str]:
    """
    Parses the settings.gradle.kts file to find all included modules.
    """
    settings_file = project_root / "settings.gradle.kts"
    modules = []

    if not settings_file.is_file():
        print(f"Error: Could not find settings.gradle.kts in {project_root}")
        return modules

    module_pattern = re.compile(r'include\s*\(\s*":(.*?)"\s*\)')

    with open(settings_file, "r") as f:
        for line in f:
            match = module_pattern.search(line)
            if match:
                module_name = match.group(1).replace(":", os.sep)
                modules.append(module_name)

    return modules

def find_jacoco_reports(project_root: Path, modules: list[str], variants: list[str] | None) -> list[Path]:
    """
    Iterates through modules to find JaCoCo reports within the 'build/reports/jacoco' directory,
    optionally filtering by variant.
    """
    report_paths = []

    for module in modules:
        jacoco_dir = project_root / module / "build" / "reports" / "jacoco"

        if not jacoco_dir.is_dir():
            continue

        for root, _, files in os.walk(jacoco_dir):
            for file in files:
                if file.endswith(".xml"):
                    report_path =(Path(root) / file).resolve()

                    if variants:
                        if any(f"/{variant}/" in str(report_path) or f"Test{variant.capitalize()}" in str(report_path) for variant in variants):
                            report_paths.append(report_path)
                    else:
                        report_paths.append(report_path)

    return report_paths

def main():
    """Main function to orchestrate the script."""
    parser = argparse.ArgumentParser(
        description="Find JaCoCo XML reports in a multi-module Android project's jacoco directories."
    )
    parser.add_argument(
        "project_root",
        type=str,
        help="The root directory of the Android project."
    )
    parser.add_argument(
        "-v", "--variants",
        nargs='+',
        help="A list of build variants to filter by (e.g., debug release). If omitted, all reports are found."
    )

    args = parser.parse_args()
    project_root_path = Path(args.project_root).resolve()

    print(f"🔍 Searching for modules in: {project_root_path}")
    modules = find_included_modules(project_root_path)

    if not modules:
        print("No modules found. Exiting.")
        return

    print(f"✅ Found modules: {modules}")

    if args.variants:
        print(f"🔬 Filtering for variants: {args.variants}")
    else:
        print("🔬 Finding all reports (no variant filter).")

    reports = find_jacoco_reports(project_root_path, modules, args.variants)

    if reports:
        print("\n--- Found JaCoCo Reports ---")
        for report in reports:
            print(report)
        print("--------------------------\n")
    else:
        print("\n❌ No matching JaCoCo reports found.\n")

if __name__ == "__main__":
    main()
