# SleepApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addSleep**](SleepApi.md#addSleep) | **POST** /1.2/user/-/sleep.json | Log Sleep |
| [**deleteSleep**](SleepApi.md#deleteSleep) | **DELETE** /1.2/user/-/sleep/{log-id}.json | Delete Sleep Log |
| [**getSleepByDate**](SleepApi.md#getSleepByDate) | **GET** /1.2/user/-/sleep/date/{date}.json | Get Sleep Log |
| [**getSleepByDateRange**](SleepApi.md#getSleepByDateRange) | **GET** /1.2/user/-/sleep/date/{base-date}/{end-date}.json | Get Sleep Logs by Date Range |
| [**getSleepGoal**](SleepApi.md#getSleepGoal) | **GET** /1.2/user/-/sleep/goal.json | Get Sleep Goal |
| [**getSleepList**](SleepApi.md#getSleepList) | **GET** /1.2/user/-/sleep/list.json | Get Sleep Logs List |
| [**updateSleepGoal**](SleepApi.md#updateSleepGoal) | **POST** /1.2/user/-/sleep/goal.json | Update Sleep Goal |


<a id="addSleep"></a>
# **addSleep**
> addSleep(startTime, duration, date)

Log Sleep

Creates a log entry for a sleep event and returns a response in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SleepApi()
val startTime : kotlin.String = startTime_example // kotlin.String | Start time includes hours and minutes in the format HH:mm.
val duration : kotlin.Int = 56 // kotlin.Int | Duration in milliseconds.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Log entry in the format yyyy-MM-dd.
try {
    apiInstance.addSleep(startTime, duration, date)
} catch (e: ClientException) {
    println("4xx response calling SleepApi#addSleep")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SleepApi#addSleep")
    e.printStackTrace()
}
```

### Parameters
| **startTime** | **kotlin.String**| Start time includes hours and minutes in the format HH:mm. | |
| **duration** | **kotlin.Int**| Duration in milliseconds. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| Log entry in the format yyyy-MM-dd. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteSleep"></a>
# **deleteSleep**
> deleteSleep(logId)

Delete Sleep Log

Deletes a user&#39;s sleep log entry with the given ID.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SleepApi()
val logId : kotlin.String = logId_example // kotlin.String | The ID of the sleep log to be deleted.
try {
    apiInstance.deleteSleep(logId)
} catch (e: ClientException) {
    println("4xx response calling SleepApi#deleteSleep")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SleepApi#deleteSleep")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **logId** | **kotlin.String**| The ID of the sleep log to be deleted. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getSleepByDate"></a>
# **getSleepByDate**
> getSleepByDate(date)

Get Sleep Log

The Get Sleep Logs by Date endpoint returns a summary and list of a user&#39;s sleep log entries (including naps) as well as detailed sleep entry data for a given day.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SleepApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date of records to be returned. In the format yyyy-MM-dd.
try {
    apiInstance.getSleepByDate(date)
} catch (e: ClientException) {
    println("4xx response calling SleepApi#getSleepByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SleepApi#getSleepByDate")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| The date of records to be returned. In the format yyyy-MM-dd. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getSleepByDateRange"></a>
# **getSleepByDateRange**
> getSleepByDateRange(baseDate, endDate)

Get Sleep Logs by Date Range

The Get Sleep Logs by Date Range endpoint returns a list of a user&#39;s sleep log entries (including naps) as well as detailed sleep entry data for a given date range (inclusive of start and end dates).

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SleepApi()
val baseDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date of records to be returned. In the format yyyy-MM-dd.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date of records to be returned. In the format yyyy-MM-dd.
try {
    apiInstance.getSleepByDateRange(baseDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling SleepApi#getSleepByDateRange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SleepApi#getSleepByDateRange")
    e.printStackTrace()
}
```

### Parameters
| **baseDate** | **java.time.LocalDate**| The date of records to be returned. In the format yyyy-MM-dd. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endDate** | **java.time.LocalDate**| The date of records to be returned. In the format yyyy-MM-dd. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getSleepGoal"></a>
# **getSleepGoal**
> getSleepGoal()

Get Sleep Goal

Returns the user&#39;s sleep goal.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SleepApi()
try {
    apiInstance.getSleepGoal()
} catch (e: ClientException) {
    println("4xx response calling SleepApi#getSleepGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SleepApi#getSleepGoal")
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

<a id="getSleepList"></a>
# **getSleepList**
> getSleepList(sort, offset, limit, beforeDate, afterDate)

Get Sleep Logs List

The Get Sleep Logs List endpoint returns a list of a user&#39;s sleep logs (including naps) before or after a given day with offset, limit, and sort order.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SleepApi()
val sort : kotlin.String = sort_example // kotlin.String | The sort order of entries by date asc (ascending) or desc (descending).
val offset : kotlin.Int = 56 // kotlin.Int | The offset number of entries.
val limit : kotlin.Int = 56 // kotlin.Int | The maximum number of entries returned (maximum;100).
val beforeDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-ddTHH:mm:ss. Only yyyy-MM-dd is required. Either beforeDate or afterDate should be specified.
val afterDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-ddTHH:mm:ss.
try {
    apiInstance.getSleepList(sort, offset, limit, beforeDate, afterDate)
} catch (e: ClientException) {
    println("4xx response calling SleepApi#getSleepList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SleepApi#getSleepList")
    e.printStackTrace()
}
```

### Parameters
| **sort** | **kotlin.String**| The sort order of entries by date asc (ascending) or desc (descending). | |
| **offset** | **kotlin.Int**| The offset number of entries. | [default to 0] |
| **limit** | **kotlin.Int**| The maximum number of entries returned (maximum;100). | |
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

<a id="updateSleepGoal"></a>
# **updateSleepGoal**
> updateSleepGoal(minDuration)

Update Sleep Goal

Create or update the user&#39;s sleep goal and get a response in the JSON format.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SleepApi()
val minDuration : kotlin.String = minDuration_example // kotlin.String | Duration of sleep goal.
try {
    apiInstance.updateSleepGoal(minDuration)
} catch (e: ClientException) {
    println("4xx response calling SleepApi#updateSleepGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SleepApi#updateSleepGoal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **minDuration** | **kotlin.String**| Duration of sleep goal. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

