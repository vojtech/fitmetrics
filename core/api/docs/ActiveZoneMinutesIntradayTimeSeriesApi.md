# ActiveZoneMinutesIntradayTimeSeriesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getAZMByDateIntraday**](ActiveZoneMinutesIntradayTimeSeriesApi.md#getAZMByDateIntraday) | **GET** /1/user/-/activities/active-zone-minutes/date/{date}/1d/{detail-level}.json | Get AZM Intraday by Date |
| [**getAZMByDateTimeSeriesIntraday**](ActiveZoneMinutesIntradayTimeSeriesApi.md#getAZMByDateTimeSeriesIntraday) | **GET** /1/user/-/activities/active-zone-minutes/date/{date}/1d/{detail-level}/time/{start-time}/{end-time}.json | Get AZM Intraday by Date |
| [**getAZMByIntervalIntraday**](ActiveZoneMinutesIntradayTimeSeriesApi.md#getAZMByIntervalIntraday) | **GET** /1/user/-/activities/active-zone-minutes/date/{start-date}/{end-date}/{detail-level}.json | Get AZM Intraday by Interval |
| [**getAZMByIntervalTimeSeriesIntraday**](ActiveZoneMinutesIntradayTimeSeriesApi.md#getAZMByIntervalTimeSeriesIntraday) | **GET** /1/user/-/activities/active-zone-minutes/date/{start-date}/{end-date}/time/{start-time}/{end-time}.json | Get AZM Intraday by Interval |


<a id="getAZMByDateIntraday"></a>
# **getAZMByDateIntraday**
> getAZMByDateIntraday(date, detailLevel)

Get AZM Intraday by Date

Returns the active zone minutes intraday data for a 24 hour period by specifying a date and/or time range.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActiveZoneMinutesIntradayTimeSeriesApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | The detail for which data will be returned. **Supported:** 1min | 5min | 15min
try {
    apiInstance.getAZMByDateIntraday(date, detailLevel)
} catch (e: ClientException) {
    println("4xx response calling ActiveZoneMinutesIntradayTimeSeriesApi#getAZMByDateIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActiveZoneMinutesIntradayTimeSeriesApi#getAZMByDateIntraday")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **detailLevel** | **kotlin.String**| The detail for which data will be returned. **Supported:** 1min | 5min | 15min | [enum: 1min, 5min, 15min] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getAZMByDateTimeSeriesIntraday"></a>
# **getAZMByDateTimeSeriesIntraday**
> getAZMByDateTimeSeriesIntraday(date, detailLevel, startTime, endTime)

Get AZM Intraday by Date

Returns the active zone minutes intraday data for a 24 hour period by specifying a date and/or time range.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActiveZoneMinutesIntradayTimeSeriesApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | The detail for which data will be returned. **Supported:** 1min | 5min | 15min
val startTime : kotlin.String = startTime_example // kotlin.String | The start of the period in the format HH:mm.
val endTime : kotlin.String = endTime_example // kotlin.String | The end of the period in the format HH:mm.
try {
    apiInstance.getAZMByDateTimeSeriesIntraday(date, detailLevel, startTime, endTime)
} catch (e: ClientException) {
    println("4xx response calling ActiveZoneMinutesIntradayTimeSeriesApi#getAZMByDateTimeSeriesIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActiveZoneMinutesIntradayTimeSeriesApi#getAZMByDateTimeSeriesIntraday")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |
| **detailLevel** | **kotlin.String**| The detail for which data will be returned. **Supported:** 1min | 5min | 15min | [enum: 1min, 5min, 15min] |
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

<a id="getAZMByIntervalIntraday"></a>
# **getAZMByIntervalIntraday**
> getAZMByIntervalIntraday(startDate, endDate, detailLevel)

Get AZM Intraday by Interval

Returns the active zone minutes intraday data for a 24 hour period by specifying a date range and/or time range.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActiveZoneMinutesIntradayTimeSeriesApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | The detail for which data will be returned. **Support:** 1min | 5min | 15min
try {
    apiInstance.getAZMByIntervalIntraday(startDate, endDate, detailLevel)
} catch (e: ClientException) {
    println("4xx response calling ActiveZoneMinutesIntradayTimeSeriesApi#getAZMByIntervalIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActiveZoneMinutesIntradayTimeSeriesApi#getAZMByIntervalIntraday")
    e.printStackTrace()
}
```

### Parameters
| **startDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |
| **endDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **detailLevel** | **kotlin.String**| The detail for which data will be returned. **Support:** 1min | 5min | 15min | [enum: 1min, 5min, 15min] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getAZMByIntervalTimeSeriesIntraday"></a>
# **getAZMByIntervalTimeSeriesIntraday**
> getAZMByIntervalTimeSeriesIntraday(startDate, endDate, detailLevel, startTime, endTime)

Get AZM Intraday by Interval

Returns the active zone minutes intraday data for a 24 hour period by specifying a date range and/or time range.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActiveZoneMinutesIntradayTimeSeriesApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd or today
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | The detail for which data will be returned. **Support:** 1min | 5min | 15min
val startTime : kotlin.String = startTime_example // kotlin.String | The start of the period in the format HH:mm.
val endTime : kotlin.String = endTime_example // kotlin.String | The end of the period in the format HH:mm.
try {
    apiInstance.getAZMByIntervalTimeSeriesIntraday(startDate, endDate, detailLevel, startTime, endTime)
} catch (e: ClientException) {
    println("4xx response calling ActiveZoneMinutesIntradayTimeSeriesApi#getAZMByIntervalTimeSeriesIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActiveZoneMinutesIntradayTimeSeriesApi#getAZMByIntervalTimeSeriesIntraday")
    e.printStackTrace()
}
```

### Parameters
| **startDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |
| **endDate** | **java.time.LocalDate**| The date in the format yyyy-MM-dd or today | |
| **detailLevel** | **kotlin.String**| The detail for which data will be returned. **Support:** 1min | 5min | 15min | [enum: 1min, 5min, 15min] |
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

