# ActivityIntradayTimeSeriesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getActivitiesResourceByDateIntraday**](ActivityIntradayTimeSeriesApi.md#getActivitiesResourceByDateIntraday) | **GET** /1/user/-/activities/{resource-path}/date/{date}/1d/{detail-level}.json | Get Intraday Time Series |
| [**getActivitiesResourceByDateRangeIntraday**](ActivityIntradayTimeSeriesApi.md#getActivitiesResourceByDateRangeIntraday) | **GET** /1/user/-/activities/{resource-path}/date/{base-date}/{end-date}/{detail-level}.json | Get Activity Intraday Time Series |
| [**getActivitiesResourceByDateRangeTimeSeriesIntraday**](ActivityIntradayTimeSeriesApi.md#getActivitiesResourceByDateRangeTimeSeriesIntraday) | **GET** /1/user/-/activities/{resource-path}/date/{date}/{end-date}/{detail-level}/time/{start-time}/{end-time}.json | Get Activity Intraday Time Series |
| [**getActivitiesResourceByDateTimeSeriesIntraday**](ActivityIntradayTimeSeriesApi.md#getActivitiesResourceByDateTimeSeriesIntraday) | **GET** /1/user/-/activities/{resource-path}/date/{date}/1d/{detail-level}/time/{start-time}/{end-time}.json | Get Intraday Time Series |


<a id="getActivitiesResourceByDateIntraday"></a>
# **getActivitiesResourceByDateIntraday**
> getActivitiesResourceByDateIntraday(resourcePath, date, detailLevel)

Get Intraday Time Series

Returns the Intraday Time Series for a given resource in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityIntradayTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource-path; see options in the Resource Path Options section in the full documentation.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today.
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | Number of data points to include. Either 1min or 15min. Optional.
try {
    apiInstance.getActivitiesResourceByDateIntraday(resourcePath, date, detailLevel)
} catch (e: ClientException) {
    println("4xx response calling ActivityIntradayTimeSeriesApi#getActivitiesResourceByDateIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityIntradayTimeSeriesApi#getActivitiesResourceByDateIntraday")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource-path; see options in the Resource Path Options section in the full documentation. | [default to steps] [enum: calories, steps, distance, floors, elevation] |
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **detailLevel** | **kotlin.String**| Number of data points to include. Either 1min or 15min. Optional. | [default to &quot;1min&quot;] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesResourceByDateRangeIntraday"></a>
# **getActivitiesResourceByDateRangeIntraday**
> getActivitiesResourceByDateRangeIntraday(resourcePath, baseDate, endDate, detailLevel)

Get Activity Intraday Time Series

Returns the Activity Intraday Time Series for a given resource in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityIntradayTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource-path; see options in the Resource Path Options section in the full documentation.
val baseDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today.
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | Number of data points to include. Either 1min or 15min. Optional.
try {
    apiInstance.getActivitiesResourceByDateRangeIntraday(resourcePath, baseDate, endDate, detailLevel)
} catch (e: ClientException) {
    println("4xx response calling ActivityIntradayTimeSeriesApi#getActivitiesResourceByDateRangeIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityIntradayTimeSeriesApi#getActivitiesResourceByDateRangeIntraday")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource-path; see options in the Resource Path Options section in the full documentation. | [default to steps] [enum: calories, steps, distance, floors, elevation] |
| **baseDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today. | |
| **endDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **detailLevel** | **kotlin.String**| Number of data points to include. Either 1min or 15min. Optional. | [default to &quot;1min&quot;] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesResourceByDateRangeTimeSeriesIntraday"></a>
# **getActivitiesResourceByDateRangeTimeSeriesIntraday**
> getActivitiesResourceByDateRangeTimeSeriesIntraday(resourcePath, date, endDate, detailLevel, startTime, endTime)

Get Activity Intraday Time Series

Returns the Intraday Time Series for a given resource in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityIntradayTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource-path; see options in the Resource Path Options section in the full documentation.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today.
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | Number of data points to include. Either 1min or 15min.
val startTime : kotlin.String = startTime_example // kotlin.String | The start of the period in the format HH:mm.
val endTime : kotlin.String = endTime_example // kotlin.String | The end of the period in the format HH:mm.
try {
    apiInstance.getActivitiesResourceByDateRangeTimeSeriesIntraday(resourcePath, date, endDate, detailLevel, startTime, endTime)
} catch (e: ClientException) {
    println("4xx response calling ActivityIntradayTimeSeriesApi#getActivitiesResourceByDateRangeTimeSeriesIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityIntradayTimeSeriesApi#getActivitiesResourceByDateRangeTimeSeriesIntraday")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource-path; see options in the Resource Path Options section in the full documentation. | [default to steps] [enum: calories, steps, distance, floors, elevation] |
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today. | |
| **endDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today. | |
| **detailLevel** | **kotlin.String**| Number of data points to include. Either 1min or 15min. | [default to &quot;1min&quot;] |
| **startTime** | **kotlin.String**| The start of the period in the format HH:mm. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endTime** | **kotlin.String**| The end of the period in the format HH:mm. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesResourceByDateTimeSeriesIntraday"></a>
# **getActivitiesResourceByDateTimeSeriesIntraday**
> getActivitiesResourceByDateTimeSeriesIntraday(resourcePath, date, detailLevel, startTime, endTime)

Get Intraday Time Series

Returns the Intraday Time Series for a given resource in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityIntradayTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource-path; see options in the Resource Path Options section in the full documentation.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today.
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | Number of data points to include. Either 1min or 15min.
val startTime : kotlin.String = startTime_example // kotlin.String | The start of the period in the format HH:mm.
val endTime : kotlin.String = endTime_example // kotlin.String | The end of the period in the format HH:mm.
try {
    apiInstance.getActivitiesResourceByDateTimeSeriesIntraday(resourcePath, date, detailLevel, startTime, endTime)
} catch (e: ClientException) {
    println("4xx response calling ActivityIntradayTimeSeriesApi#getActivitiesResourceByDateTimeSeriesIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityIntradayTimeSeriesApi#getActivitiesResourceByDateTimeSeriesIntraday")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource-path; see options in the Resource Path Options section in the full documentation. | [default to steps] [enum: calories, steps, distance, floors, elevation] |
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today. | |
| **detailLevel** | **kotlin.String**| Number of data points to include. Either 1min or 15min. | [default to &quot;1min&quot;] |
| **startTime** | **kotlin.String**| The start of the period in the format HH:mm. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endTime** | **kotlin.String**| The end of the period in the format HH:mm. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

