# HeartRateVariabilityIntradayApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getHrvIntradayByDate**](HeartRateVariabilityIntradayApi.md#getHrvIntradayByDate) | **GET** /1/user/-/hrv/date/{date}/all.json | Get HRV Intraday by Date |
| [**getHrvIntradayByInterval**](HeartRateVariabilityIntradayApi.md#getHrvIntradayByInterval) | **GET** /1/user/-/hrv/date/{startDate}/{endDate}/all.json | Get HRV Intraday by Interval |


<a id="getHrvIntradayByDate"></a>
# **getHrvIntradayByDate**
> getHrvIntradayByDate(date)

Get HRV Intraday by Date

This endpoint returns the Heart Rate Variability (HRV) intraday data for a single date. HRV data applies specifically to a user’s “main sleep,” which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateVariabilityIntradayApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getHrvIntradayByDate(date)
} catch (e: ClientException) {
    println("4xx response calling HeartRateVariabilityIntradayApi#getHrvIntradayByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateVariabilityIntradayApi#getHrvIntradayByDate")
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

<a id="getHrvIntradayByInterval"></a>
# **getHrvIntradayByInterval**
> getHrvIntradayByInterval(startDate, endDate)

Get HRV Intraday by Interval

This endpoint returns the Heart Rate Variability (HRV) intraday data for a single date. HRV data applies specifically to a user’s “main sleep,” which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateVariabilityIntradayApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getHrvIntradayByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling HeartRateVariabilityIntradayApi#getHrvIntradayByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateVariabilityIntradayApi#getHrvIntradayByInterval")
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

