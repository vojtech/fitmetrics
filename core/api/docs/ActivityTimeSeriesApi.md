# ActivityTimeSeriesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getActivitiesResourceByDatePeriod**](ActivityTimeSeriesApi.md#getActivitiesResourceByDatePeriod) | **GET** /1/user/-/activities/{resource-path}/date/{date}/{period}.json | Get Activity Time Series |
| [**getActivitiesResourceByDateRange**](ActivityTimeSeriesApi.md#getActivitiesResourceByDateRange) | **GET** /1/user/-/activities/{resource-path}/date/{base-date}/{end-date}.json | Get Activity Resource by Date Range |
| [**getActivitiesTrackerResourceByDatePeriod**](ActivityTimeSeriesApi.md#getActivitiesTrackerResourceByDatePeriod) | **GET** /1/user/-/activities/tracker/{resource-path}/date/{date}/{period}.json | Get Activity Time Series |
| [**getActivitiesTrackerResourceByDateRange**](ActivityTimeSeriesApi.md#getActivitiesTrackerResourceByDateRange) | **GET** /1/user/-/activities/tracker/{resource-path}/date/{base-date}/{end-date}.json | Get Activity Tracker Resource by Date Range Time Series |


<a id="getActivitiesResourceByDatePeriod"></a>
# **getActivitiesResourceByDatePeriod**
> getActivitiesResourceByDatePeriod(resourcePath, date, period)

Get Activity Time Series

Returns time series data in the specified range for a given resource in the format requested using units in the unit system that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource-path; see options in the Resource Path Options section in the full documentation.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the period specified in the format yyyy-MM-dd or today.
val period : kotlin.String = period_example // kotlin.String | The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max.
try {
    apiInstance.getActivitiesResourceByDatePeriod(resourcePath, date, period)
} catch (e: ClientException) {
    println("4xx response calling ActivityTimeSeriesApi#getActivitiesResourceByDatePeriod")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityTimeSeriesApi#getActivitiesResourceByDatePeriod")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource-path; see options in the Resource Path Options section in the full documentation. | [default to steps] [enum: calories, caloriesBMR, steps, distance, floors, elevation, minutesSedentary, minutesLightlyActive, minutesFairlyActive, minutesVeryActive, activityCalories] |
| **date** | **java.time.LocalDate**| The end date of the period specified in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **period** | **kotlin.String**| The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesResourceByDateRange"></a>
# **getActivitiesResourceByDateRange**
> getActivitiesResourceByDateRange(resourcePath, baseDate, endDate)

Get Activity Resource by Date Range

Returns activities time series data in the specified range for a given resource.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource-path; see options in the Resource Path Options section in the full documentation.
val baseDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The range start date in the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the range.
try {
    apiInstance.getActivitiesResourceByDateRange(resourcePath, baseDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling ActivityTimeSeriesApi#getActivitiesResourceByDateRange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityTimeSeriesApi#getActivitiesResourceByDateRange")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource-path; see options in the Resource Path Options section in the full documentation. | [default to steps] [enum: calories, caloriesBMR, steps, distance, floors, elevation, minutesSedentary, minutesLightlyActive, minutesFairlyActive, minutesVeryActive, activityCalories] |
| **baseDate** | **java.time.LocalDate**| The range start date in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endDate** | **java.time.LocalDate**| The end date of the range. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesTrackerResourceByDatePeriod"></a>
# **getActivitiesTrackerResourceByDatePeriod**
> getActivitiesTrackerResourceByDatePeriod(resourcePath, date, period)

Get Activity Time Series

Returns time series data in the specified range for a given resource in the format requested using units in the unit system that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource-path; see options in the Resource Path Options section in the full documentation.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the period specified in the format yyyy-MM-dd or today.
val period : kotlin.String = period_example // kotlin.String | The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max.
try {
    apiInstance.getActivitiesTrackerResourceByDatePeriod(resourcePath, date, period)
} catch (e: ClientException) {
    println("4xx response calling ActivityTimeSeriesApi#getActivitiesTrackerResourceByDatePeriod")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityTimeSeriesApi#getActivitiesTrackerResourceByDatePeriod")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource-path; see options in the Resource Path Options section in the full documentation. | [default to steps] [enum: calories, caloriesBMR, steps, distance, floors, elevation, minutesSedentary, minutesLightlyActive, minutesFairlyActive, minutesVeryActive, activityCalories] |
| **date** | **java.time.LocalDate**| The end date of the period specified in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **period** | **kotlin.String**| The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesTrackerResourceByDateRange"></a>
# **getActivitiesTrackerResourceByDateRange**
> getActivitiesTrackerResourceByDateRange(resourcePath, baseDate, endDate)

Get Activity Tracker Resource by Date Range Time Series

Returns time series data in the specified range for a given resource.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource-path; see options in the Resource Path Options section in the full documentation.
val baseDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The range start date in the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the range.
try {
    apiInstance.getActivitiesTrackerResourceByDateRange(resourcePath, baseDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling ActivityTimeSeriesApi#getActivitiesTrackerResourceByDateRange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityTimeSeriesApi#getActivitiesTrackerResourceByDateRange")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource-path; see options in the Resource Path Options section in the full documentation. | [default to steps] [enum: calories, caloriesBMR, steps, distance, floors, elevation, minutesSedentary, minutesLightlyActive, minutesFairlyActive, minutesVeryActive, activityCalories] |
| **baseDate** | **java.time.LocalDate**| The range start date in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endDate** | **java.time.LocalDate**| The end date of the range. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

