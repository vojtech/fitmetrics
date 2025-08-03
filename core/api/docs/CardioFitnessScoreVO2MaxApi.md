# CardioFitnessScoreVO2MaxApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getVo2MaxSummaryByDate**](CardioFitnessScoreVO2MaxApi.md#getVo2MaxSummaryByDate) | **GET** /1/user/-/cardioscore/date/{date}.json | Get VO2 Max Summary by Date |
| [**getVo2MaxSummaryByInterval**](CardioFitnessScoreVO2MaxApi.md#getVo2MaxSummaryByInterval) | **GET** /1/user/-/cardioscore/date/{startDate}/{endDate}.json | Get VO2 Max Summary by Interval |


<a id="getVo2MaxSummaryByDate"></a>
# **getVo2MaxSummaryByDate**
> getVo2MaxSummaryByDate(date)

Get VO2 Max Summary by Date

This endpoint returns the Cardio Fitness Score (VO2 Max) data for a single date. VO2 Max values will be shown as a range if no run data is available or a single numeric value if the user uses a GPS for runs.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = CardioFitnessScoreVO2MaxApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getVo2MaxSummaryByDate(date)
} catch (e: ClientException) {
    println("4xx response calling CardioFitnessScoreVO2MaxApi#getVo2MaxSummaryByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardioFitnessScoreVO2MaxApi#getVo2MaxSummaryByDate")
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

<a id="getVo2MaxSummaryByInterval"></a>
# **getVo2MaxSummaryByInterval**
> getVo2MaxSummaryByInterval(startDate, endDate)

Get VO2 Max Summary by Interval

This endpoint returns the Cardio Fitness Score (VO2 Max) data for a date range. VO2 Max values will be shown as a range if no run data is available or a single numeric value if the user uses a GPS for runs.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = CardioFitnessScoreVO2MaxApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getVo2MaxSummaryByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling CardioFitnessScoreVO2MaxApi#getVo2MaxSummaryByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardioFitnessScoreVO2MaxApi#getVo2MaxSummaryByInterval")
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

