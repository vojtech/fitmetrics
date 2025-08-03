# BreathingRateIntradayApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getBreathingRateIntradayByDate**](BreathingRateIntradayApi.md#getBreathingRateIntradayByDate) | **GET** /1/user/-/br/date/{date}/all.json | Get Breathing Rate Intraday by Date |
| [**getBreathingRateIntradayByInterval**](BreathingRateIntradayApi.md#getBreathingRateIntradayByInterval) | **GET** /1/user/-/br/date/{startDate}/{endDate}/all.json | Get Breathing Rate Intraday by Interval |


<a id="getBreathingRateIntradayByDate"></a>
# **getBreathingRateIntradayByDate**
> getBreathingRateIntradayByDate(date)

Get Breathing Rate Intraday by Date

This endpoint returns intraday breathing rate data for a single date. It measures the average breathing rate throughout the day and categories your breathing rate by sleep stage. Sleep stages vary between light sleep, deep sleep, REM sleep, and full sleep.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BreathingRateIntradayApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getBreathingRateIntradayByDate(date)
} catch (e: ClientException) {
    println("4xx response calling BreathingRateIntradayApi#getBreathingRateIntradayByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BreathingRateIntradayApi#getBreathingRateIntradayByDate")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| The date in the format of yyyy-MM-dd or today. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getBreathingRateIntradayByInterval"></a>
# **getBreathingRateIntradayByInterval**
> getBreathingRateIntradayByInterval(startDate, endDate)

Get Breathing Rate Intraday by Interval

This endpoint returns intraday breathing rate data for a date range. It measures the average breathing rate throughout the day and categories your breathing rate by sleep stage. Sleep stages vary between light sleep, deep sleep, REM sleep, and full sleep.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BreathingRateIntradayApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getBreathingRateIntradayByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling BreathingRateIntradayApi#getBreathingRateIntradayByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BreathingRateIntradayApi#getBreathingRateIntradayByInterval")
    e.printStackTrace()
}
```

### Parameters
| **startDate** | **java.time.LocalDate**| The date in the format of yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endDate** | **java.time.LocalDate**| The date in the format of yyyy-MM-dd or today. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

