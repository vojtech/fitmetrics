# SpO2Api

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getSpO2SummaryByDate**](SpO2Api.md#getSpO2SummaryByDate) | **GET** /1/user/-/spo2/date/{date}.json | Get SpO2 Summary by Date |
| [**getSpO2SummaryByInterval**](SpO2Api.md#getSpO2SummaryByInterval) | **GET** /1/user/-/spo2/date/{startDate}/{endDate}.json | Get SpO2 Summary by Interval |


<a id="getSpO2SummaryByDate"></a>
# **getSpO2SummaryByDate**
> getSpO2SummaryByDate(date)

Get SpO2 Summary by Date

This endpoint returns the SpO2 summary data for a single date. SpO2 applies specifically to a user’s “main sleep”, which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SpO2Api()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getSpO2SummaryByDate(date)
} catch (e: ClientException) {
    println("4xx response calling SpO2Api#getSpO2SummaryByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SpO2Api#getSpO2SummaryByDate")
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

<a id="getSpO2SummaryByInterval"></a>
# **getSpO2SummaryByInterval**
> getSpO2SummaryByInterval(startDate, endDate)

Get SpO2 Summary by Interval

This endpoint returns the SpO2 summary data for a date range. SpO2 applies specifically to a user’s “main sleep”, which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SpO2Api()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getSpO2SummaryByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling SpO2Api#getSpO2SummaryByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SpO2Api#getSpO2SummaryByInterval")
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

