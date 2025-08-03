# TemperatureApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getTempCoreSummaryByDate**](TemperatureApi.md#getTempCoreSummaryByDate) | **GET** /1/user/-/temp/core/date/{date}.json | Get Temperature (Core) Summary by Date |
| [**getTempCoreSummaryByInterval**](TemperatureApi.md#getTempCoreSummaryByInterval) | **GET** /1/user/-/temp/core/date/{startDate}/{endDate}.json | Get Temperature (Core) Summary by Interval |
| [**getTempSkinSummaryByInterval**](TemperatureApi.md#getTempSkinSummaryByInterval) | **GET** /1/user/-/temp/skin/date/{startDate}/{endDate}.json | Get Temperature (Skin) Summary by Interval |
| [**getTempSkinSummaryDate**](TemperatureApi.md#getTempSkinSummaryDate) | **GET** /1/user/-/temp/skin/date/{date}.json | Get Temperature (Skin) Summary by Date |


<a id="getTempCoreSummaryByDate"></a>
# **getTempCoreSummaryByDate**
> getTempCoreSummaryByDate(date)

Get Temperature (Core) Summary by Date

Returns the Temperature (Core) data for a single date. Temperature (Core) data applies specifically to data logged manually by the user throughout the day.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = TemperatureApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getTempCoreSummaryByDate(date)
} catch (e: ClientException) {
    println("4xx response calling TemperatureApi#getTempCoreSummaryByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TemperatureApi#getTempCoreSummaryByDate")
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

<a id="getTempCoreSummaryByInterval"></a>
# **getTempCoreSummaryByInterval**
> getTempCoreSummaryByInterval(startDate, endDate)

Get Temperature (Core) Summary by Interval

Returns Temperature (Core) data for a date range. Temperature (Core) data applies specifically to data logged manually by the user throughout the day and the maximum date range cannot exceed 30 days.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = TemperatureApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getTempCoreSummaryByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling TemperatureApi#getTempCoreSummaryByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TemperatureApi#getTempCoreSummaryByInterval")
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

<a id="getTempSkinSummaryByInterval"></a>
# **getTempSkinSummaryByInterval**
> getTempSkinSummaryByInterval(startDate, endDate)

Get Temperature (Skin) Summary by Interval

Returns Temperature (Skin) data for a date range. It only returns a value for dates on which the Fitbit device was able to record Temperature (skin) data and the maximum date range cannot exceed 30 days.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = TemperatureApi()
val startDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getTempSkinSummaryByInterval(startDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling TemperatureApi#getTempSkinSummaryByInterval")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TemperatureApi#getTempSkinSummaryByInterval")
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

<a id="getTempSkinSummaryDate"></a>
# **getTempSkinSummaryDate**
> getTempSkinSummaryDate(date)

Get Temperature (Skin) Summary by Date

Returns the Temperature (Skin) data for a single date. Temperature (Skin) data applies specifically to a user’s “main sleep”, which is the longest single period of time asleep on a given date.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = TemperatureApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format of yyyy-MM-dd or today.
try {
    apiInstance.getTempSkinSummaryDate(date)
} catch (e: ClientException) {
    println("4xx response calling TemperatureApi#getTempSkinSummaryDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TemperatureApi#getTempSkinSummaryDate")
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

