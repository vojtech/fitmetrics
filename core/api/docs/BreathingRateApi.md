# BreathingRateApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getBreathingRateSummaryByDate**](BreathingRateApi.md#getBreathingRateSummaryByDate) | **GET** /1/user/-/br/date/{date}.json | Get Breathing Rate Summary by Date |
| [**getBreathingRateSummaryByInterval**](BreathingRateApi.md#getBreathingRateSummaryByInterval) | **GET** /1/user/-/br/date/{startDate}/{endDate}.json | Get Breathing Rate Summary by Interval |


<a id="getBreathingRateSummaryByDate"></a>
# **getBreathingRateSummaryByDate**
> getBreathingRateSummaryByDate(date)

Get Breathing Rate Summary by Date

This endpoint returns average breathing rate data for a single date. Breathing Rate data applies specifically to a user’s “main sleep,” which is the longest single period of time during which they were asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BreathingRateApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getBreathingRateSummaryByDate(date)
} catch (e: ClientException) {
    println("4xx response calling BreathingRateApi#getBreathingRateSummaryByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BreathingRateApi#getBreathingRateSummaryByDate")
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

<a id="getBreathingRateSummaryByInterval"></a>
# **getBreathingRateSummaryByInterval**
> getBreathingRateSummaryByInterval(startDate, endDate)

Get Breathing Rate Summary by Interval

This endpoint returns average breathing rate data for a date range. Breathing Rate data applies specifically to a user’s “main sleep,” which is the longest single period of time during which they were asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BreathingRateApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getBreathingRateSummaryByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling BreathingRateApi#getBreathingRateSummaryByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BreathingRateApi#getBreathingRateSummaryByInterval")
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

