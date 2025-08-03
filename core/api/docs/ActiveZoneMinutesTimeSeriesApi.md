# ActiveZoneMinutesTimeSeriesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getAZMTimeSeriesByDate**](ActiveZoneMinutesTimeSeriesApi.md#getAZMTimeSeriesByDate) | **GET** /1/user/-/activities/active-zone-minutes/date/{date}/{period}.json | Get AZM Time Series by Date |
| [**getAZMTimeSeriesByInterval**](ActiveZoneMinutesTimeSeriesApi.md#getAZMTimeSeriesByInterval) | **GET** /1/user/-/activities/active-zone-minutes/date/{start-date}/{end-date}.json | Get AZM Time Series by Interval |


<a id="getAZMTimeSeriesByDate"></a>
# **getAZMTimeSeriesByDate**
> getAZMTimeSeriesByDate(date, period)

Get AZM Time Series by Date

Returns the daily summary values over a period of time by specifying a date and time period.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActiveZoneMinutesTimeSeriesApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
val period : kotlin.String = period_example // kotlin.String | The range for which data will be returned. **Supported:** 1d | 7d | 30d | 1w | 1m | 3m | 6m | 1y
try {
    apiInstance.getAZMTimeSeriesByDate(date, period)
} catch (e: ClientException) {
    println("4xx response calling ActiveZoneMinutesTimeSeriesApi#getAZMTimeSeriesByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActiveZoneMinutesTimeSeriesApi#getAZMTimeSeriesByDate")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **period** | **kotlin.String**| The range for which data will be returned. **Supported:** 1d | 7d | 30d | 1w | 1m | 3m | 6m | 1y | [enum: 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getAZMTimeSeriesByInterval"></a>
# **getAZMTimeSeriesByInterval**
> getAZMTimeSeriesByInterval(startDate, endDate)

Get AZM Time Series by Interval

Returns the daily summary values over an interval by specifying a date range.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActiveZoneMinutesTimeSeriesApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
try {
    apiInstance.getAZMTimeSeriesByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling ActiveZoneMinutesTimeSeriesApi#getAZMTimeSeriesByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActiveZoneMinutesTimeSeriesApi#getAZMTimeSeriesByInterval")
    e.printStackTrace()
}
```

### Parameters
| **startDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

