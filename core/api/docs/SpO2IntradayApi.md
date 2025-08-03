# SpO2IntradayApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getSpO2IntradayByDate**](SpO2IntradayApi.md#getSpO2IntradayByDate) | **GET** /1/user/-/spo2/date/{date}/all.json | Get SpO2 Intraday by Date |
| [**getSpO2IntradayByInterval**](SpO2IntradayApi.md#getSpO2IntradayByInterval) | **GET** /1/user/-/spo2/date/{startDate}/{endDate}/all.json | Get SpO2 Intraday by Interval |


<a id="getSpO2IntradayByDate"></a>
# **getSpO2IntradayByDate**
> getSpO2IntradayByDate(date)

Get SpO2 Intraday by Date

This endpoint returns the SpO2 intraday data for a single date. SpO2 applies specifically to a user’s “main sleep”, which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SpO2IntradayApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getSpO2IntradayByDate(date)
} catch (e: ClientException) {
    println("4xx response calling SpO2IntradayApi#getSpO2IntradayByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SpO2IntradayApi#getSpO2IntradayByDate")
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

<a id="getSpO2IntradayByInterval"></a>
# **getSpO2IntradayByInterval**
> getSpO2IntradayByInterval(startDate, endDate)

Get SpO2 Intraday by Interval

This endpoint returns the SpO2 intraday data for a specified date range. SpO2 applies specifically to a user’s “main sleep”, which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SpO2IntradayApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getSpO2IntradayByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling SpO2IntradayApi#getSpO2IntradayByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SpO2IntradayApi#getSpO2IntradayByInterval")
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

