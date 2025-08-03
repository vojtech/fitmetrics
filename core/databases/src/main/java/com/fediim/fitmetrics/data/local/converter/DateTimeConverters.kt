package com.fediim.fitmetrics.data.local.converter

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Type converters for Room to handle date and time types.
 */
class DateTimeConverters {
    private val dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME
    private val dateFormatter = DateTimeFormatter.ISO_DATE

    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime?): String? = value?.format(dateTimeFormatter)

    @TypeConverter
    fun toLocalDateTime(
        value: String?
    ): LocalDateTime? = value?.let { LocalDateTime.parse(it, dateTimeFormatter) }

    @TypeConverter
    fun fromLocalDate(value: LocalDate?): String? = value?.format(dateFormatter)

    @TypeConverter
    fun toLocalDate(value: String?): LocalDate? = value?.let { LocalDate.parse(it, dateFormatter) }
}
