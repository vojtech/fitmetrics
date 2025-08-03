# ElectrocardiogramApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getEcgLogList**](ElectrocardiogramApi.md#getEcgLogList) | **GET** /1/user/-/ecg/list.json | Get ECG Log List |


<a id="getEcgLogList"></a>
# **getEcgLogList**
> getEcgLogList(sort, offset, limit, beforeDate, afterDate)

Get ECG Log List

This endpoint is used for querying the user&#39;s on-device ECG readings.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ElectrocardiogramApi()
val sort : kotlin.String = sort_example // kotlin.String | The sort order of entries by date asc (ascending) or desc (descending).
val offset : kotlin.Int = 56 // kotlin.Int | The offset number of entries.
val limit : kotlin.Int = 56 // kotlin.Int | The maximum number of entries returned (maximum;10).
val beforeDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-ddTHH:mm:ss. Only yyyy-MM-dd is required. Either beforeDate or afterDate should be specified.
val afterDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-ddTHH:mm:ss.
try {
    apiInstance.getEcgLogList(sort, offset, limit, beforeDate, afterDate)
} catch (e: ClientException) {
    println("4xx response calling ElectrocardiogramApi#getEcgLogList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ElectrocardiogramApi#getEcgLogList")
    e.printStackTrace()
}
```

### Parameters
| **sort** | **kotlin.String**| The sort order of entries by date asc (ascending) or desc (descending). | |
| **offset** | **kotlin.Int**| The offset number of entries. | [default to 0] |
| **limit** | **kotlin.Int**| The maximum number of entries returned (maximum;10). | |
| **beforeDate** | **java.time.LocalDate**| The date in the format yyyy-MM-ddTHH:mm:ss. Only yyyy-MM-dd is required. Either beforeDate or afterDate should be specified. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **afterDate** | **java.time.LocalDate**| The date in the format yyyy-MM-ddTHH:mm:ss. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

