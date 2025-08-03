# IrregularRhythmNotificationsApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getIrnAlertsList**](IrregularRhythmNotificationsApi.md#getIrnAlertsList) | **GET** /1/user/-/irn/alerts/list.json | Get IRN Alerts List |
| [**getIrnProfile**](IrregularRhythmNotificationsApi.md#getIrnProfile) | **GET** /1/user/-/irn/profile.json | Get IRN Profile |


<a id="getIrnAlertsList"></a>
# **getIrnAlertsList**
> getIrnAlertsList(sort, offset, limit, beforeDate, afterDate)

Get IRN Alerts List

This endpoint returns a paginated list of Irregular Rhythm Notifications (IRN) alerts, as well as all of the alert tachograms. This endpoint will only return alerts that the user has read in the Fitbit app already, as that is meant as the primary entrypoint for viewing notifications.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = IrregularRhythmNotificationsApi()
val sort : kotlin.String = sort_example // kotlin.String | The sort order of entries by date. Use asc (ascending) when using afterDate. Use desc (descending) when using beforeDate.
val offset : kotlin.Int = 56 // kotlin.Int | The offset number of entries.
val limit : kotlin.Int = 56 // kotlin.Int | The maximum number of entries returned (maximum;10).
val beforeDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-ddTHH:mm:ss. Only yyyy-MM-dd is required. Either beforeDate or afterDate should be specified.
val afterDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-ddTHH:mm:ss. Only yyyy-MM-dd is required. Either beforeDate or afterDate should be specified.
try {
    apiInstance.getIrnAlertsList(sort, offset, limit, beforeDate, afterDate)
} catch (e: ClientException) {
    println("4xx response calling IrregularRhythmNotificationsApi#getIrnAlertsList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IrregularRhythmNotificationsApi#getIrnAlertsList")
    e.printStackTrace()
}
```

### Parameters
| **sort** | **kotlin.String**| The sort order of entries by date. Use asc (ascending) when using afterDate. Use desc (descending) when using beforeDate. | |
| **offset** | **kotlin.Int**| The offset number of entries. | [default to 0] |
| **limit** | **kotlin.Int**| The maximum number of entries returned (maximum;10). | |
| **beforeDate** | **java.time.LocalDate**| The date in the format yyyy-MM-ddTHH:mm:ss. Only yyyy-MM-dd is required. Either beforeDate or afterDate should be specified. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **afterDate** | **java.time.LocalDate**| The date in the format yyyy-MM-ddTHH:mm:ss. Only yyyy-MM-dd is required. Either beforeDate or afterDate should be specified. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getIrnProfile"></a>
# **getIrnProfile**
> getIrnProfile()

Get IRN Profile

This endpoint returns the user state for Irregular Rhythm Notifications (IRN). The user state contains most information about the user’s current engagement with the feature, including onboarding progress and algorithm processing state.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = IrregularRhythmNotificationsApi()
try {
    apiInstance.getIrnProfile()
} catch (e: ClientException) {
    println("4xx response calling IrregularRhythmNotificationsApi#getIrnProfile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IrregularRhythmNotificationsApi#getIrnProfile")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

