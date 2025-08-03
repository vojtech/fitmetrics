# HeartRateVariabilityApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getHrvSummaryDate**](HeartRateVariabilityApi.md#getHrvSummaryDate) | **GET** /1/user/-/hrv/date/{date}.json | Get HRV Summary by Date |
| [**getHrvSummaryInterval**](HeartRateVariabilityApi.md#getHrvSummaryInterval) | **GET** /1/user/-/hrv/date/{startDate}/{endDate}.json | Get HRV Summary by Interval |


<a id="getHrvSummaryDate"></a>
# **getHrvSummaryDate**
> getHrvSummaryDate(date)

Get HRV Summary by Date

This endpoint returns the Heart Rate Variability (HRV) data for a single date. HRV data applies specifically to a user’s “main sleep,” which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateVariabilityApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getHrvSummaryDate(date)
} catch (e: ClientException) {
    println("4xx response calling HeartRateVariabilityApi#getHrvSummaryDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateVariabilityApi#getHrvSummaryDate")
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

<a id="getHrvSummaryInterval"></a>
# **getHrvSummaryInterval**
> getHrvSummaryInterval(startDate, endDate)

Get HRV Summary by Interval

This endpoint returns the Heart Rate Variability (HRV) data for a date range. HRV data applies specifically to a user’s “main sleep,” which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateVariabilityApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getHrvSummaryInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling HeartRateVariabilityApi#getHrvSummaryInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateVariabilityApi#getHrvSummaryInterval")
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

