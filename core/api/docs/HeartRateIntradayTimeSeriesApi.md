# HeartRateIntradayTimeSeriesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getHeartByDateIntraday**](HeartRateIntradayTimeSeriesApi.md#getHeartByDateIntraday) | **GET** /1/user/-/activities/heart/date/{date}/1d/{detail-level}.json | Get Heart Rate Intraday Time Series |
| [**getHeartByDateRangeIntraday**](HeartRateIntradayTimeSeriesApi.md#getHeartByDateRangeIntraday) | **GET** /1/user/-/activities/heart/date/{date}/{end-date}/{detail-level}.json | Get Heart Rate Intraday Time Series |
| [**getHeartByDateRangeTimestampIntraday**](HeartRateIntradayTimeSeriesApi.md#getHeartByDateRangeTimestampIntraday) | **GET** /1/user/-/activities/heart/date/{date}/{end-date}/{detail-level}/time/{start-time}/{end-time}.json | Get Heart Rate Intraday Time Series |
| [**getHeartByDateTimestampIntraday**](HeartRateIntradayTimeSeriesApi.md#getHeartByDateTimestampIntraday) | **GET** /1/user/-/activities/heart/date/{date}/1d/{detail-level}/time/{start-time}/{end-time}.json | Get Heart Rate Intraday Time Series |


<a id="getHeartByDateIntraday"></a>
# **getHeartByDateIntraday**
> getHeartByDateIntraday(date, detailLevel)

Get Heart Rate Intraday Time Series

Returns the intraday time series for a given resource in the format requested. If your application has the appropriate access, your calls to a time series endpoint for a specific day (by using start and end dates on the same day or a period of 1d), the response will include extended intraday values with a one-minute detail level for that day. Unlike other time series calls that allow fetching data of other users, intraday data is available only for and to the authorized user.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateIntradayTimeSeriesApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | The number of data points to include either 1sec, 1min, 5min or 15min.
try {
    apiInstance.getHeartByDateIntraday(date, detailLevel)
} catch (e: ClientException) {
    println("4xx response calling HeartRateIntradayTimeSeriesApi#getHeartByDateIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateIntradayTimeSeriesApi#getHeartByDateIntraday")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format of yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **detailLevel** | **kotlin.String**| The number of data points to include either 1sec, 1min, 5min or 15min. | [default to &quot;1min&quot;] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getHeartByDateRangeIntraday"></a>
# **getHeartByDateRangeIntraday**
> getHeartByDateRangeIntraday(date, endDate, detailLevel)

Get Heart Rate Intraday Time Series

Returns the intraday time series for a given resource in the format requested. If your application has the appropriate access, your calls to a time series endpoint for a specific day (by using start and end dates on the same day or a period of 1d), the response will include extended intraday values with a one-minute detail level for that day. Unlike other time series calls that allow fetching data of other users, intraday data is available only for and to the authorized user.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateIntradayTimeSeriesApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date in the format of yyyy-MM-dd or today.
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | The number of data points to include either 1sec, 1min, 5min or 15min.
try {
    apiInstance.getHeartByDateRangeIntraday(date, endDate, detailLevel)
} catch (e: ClientException) {
    println("4xx response calling HeartRateIntradayTimeSeriesApi#getHeartByDateRangeIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateIntradayTimeSeriesApi#getHeartByDateRangeIntraday")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format of yyyy-MM-dd or today. | |
| **endDate** | **java.time.LocalDate**| The end date in the format of yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **detailLevel** | **kotlin.String**| The number of data points to include either 1sec, 1min, 5min or 15min. | [default to &quot;1min&quot;] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getHeartByDateRangeTimestampIntraday"></a>
# **getHeartByDateRangeTimestampIntraday**
> getHeartByDateRangeTimestampIntraday(date, endDate, detailLevel, startTime, endTime)

Get Heart Rate Intraday Time Series

Returns the intraday time series for a given resource in the format requested. If your application has the appropriate access, your calls to a time series endpoint for a specific day (by using start and end dates on the same day or a period of 1d), the response will include extended intraday values with a one-minute detail level for that day. Unlike other time series calls that allow fetching data of other users, intraday data is available only for and to the authorized user.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateIntradayTimeSeriesApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date in the format of yyyy-MM-dd or today.
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | The number of data points to include either 1sec, 1min, 5min or 15min.
val startTime : kotlin.String = startTime_example // kotlin.String | The start of the period in the format of HH:mm.
val endTime : kotlin.String = endTime_example // kotlin.String | The end time of the period in the format of HH:mm.
try {
    apiInstance.getHeartByDateRangeTimestampIntraday(date, endDate, detailLevel, startTime, endTime)
} catch (e: ClientException) {
    println("4xx response calling HeartRateIntradayTimeSeriesApi#getHeartByDateRangeTimestampIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateIntradayTimeSeriesApi#getHeartByDateRangeTimestampIntraday")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format of yyyy-MM-dd or today. | |
| **endDate** | **java.time.LocalDate**| The end date in the format of yyyy-MM-dd or today. | |
| **detailLevel** | **kotlin.String**| The number of data points to include either 1sec, 1min, 5min or 15min. | [default to &quot;1min&quot;] |
| **startTime** | **kotlin.String**| The start of the period in the format of HH:mm. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endTime** | **kotlin.String**| The end time of the period in the format of HH:mm. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getHeartByDateTimestampIntraday"></a>
# **getHeartByDateTimestampIntraday**
> getHeartByDateTimestampIntraday(date, detailLevel, startTime, endTime)

Get Heart Rate Intraday Time Series

Returns the intraday time series for a given resource in the format requested. If your application has the appropriate access, your calls to a time series endpoint for a specific day (by using start and end dates on the same day or a period of 1d), the response will include extended intraday values with a one-minute detail level for that day. Unlike other time series calls that allow fetching data of other users, intraday data is available only for and to the authorized user.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateIntradayTimeSeriesApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val detailLevel : kotlin.String = detailLevel_example // kotlin.String | The number of data points to include either 1sec, 1min, 5min or 15min.
val startTime : kotlin.String = startTime_example // kotlin.String | The start of the period in the format of HH:mm.
val endTime : kotlin.String = endTime_example // kotlin.String | The end time of the period in the format of HH:mm.
try {
    apiInstance.getHeartByDateTimestampIntraday(date, detailLevel, startTime, endTime)
} catch (e: ClientException) {
    println("4xx response calling HeartRateIntradayTimeSeriesApi#getHeartByDateTimestampIntraday")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateIntradayTimeSeriesApi#getHeartByDateTimestampIntraday")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format of yyyy-MM-dd or today. | |
| **detailLevel** | **kotlin.String**| The number of data points to include either 1sec, 1min, 5min or 15min. | [default to &quot;1min&quot;] |
| **startTime** | **kotlin.String**| The start of the period in the format of HH:mm. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endTime** | **kotlin.String**| The end time of the period in the format of HH:mm. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

