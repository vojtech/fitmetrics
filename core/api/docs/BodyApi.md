# BodyApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addBodyFatLog**](BodyApi.md#addBodyFatLog) | **POST** /1/user/-/body/log/fat.json | Log Body Fat |
| [**addWeightLog**](BodyApi.md#addWeightLog) | **POST** /1/user/-/body/log/weight.json | Log Weight |
| [**deleteBodyFatLog**](BodyApi.md#deleteBodyFatLog) | **DELETE** /1/user/-/body/log/fat/{body-fat-log-id}.json | Delete Body Fat Log |
| [**deleteWeightLog**](BodyApi.md#deleteWeightLog) | **DELETE** /1/user/-/body/log/weight/{body-weight-log-id}.json | Delete Weight Log |
| [**getBodyFatByDate**](BodyApi.md#getBodyFatByDate) | **GET** /1/user/-/body/log/fat/date/{date}.json | Get Body Fat Logs |
| [**getBodyFatByDatePeriod**](BodyApi.md#getBodyFatByDatePeriod) | **GET** /1/user/-/body/log/fat/date/{date}/{period}.json | Get Body Fat Logs |
| [**getBodyFatByDateRange**](BodyApi.md#getBodyFatByDateRange) | **GET** /1/user/-/body/log/fat/date/{base-date}/{end-date}.json | Get Body Fat Logs |
| [**getBodyGoals**](BodyApi.md#getBodyGoals) | **GET** /1/user/-/body/log/{goal-type}/goal.json | Get Body Goals |
| [**getWeightByDate**](BodyApi.md#getWeightByDate) | **GET** /1/user/-/body/log/weight/date/{date}.json | Get Weight Logs |
| [**getWeightByDatePeriod**](BodyApi.md#getWeightByDatePeriod) | **GET** /1/user/-/body/log/weight/date/{date}/{period}.json | Get Body Fat Logs |
| [**getWeightByDateRange**](BodyApi.md#getWeightByDateRange) | **GET** /1/user/-/body/log/weight/date/{base-date}/{end-date}.json | Get Body Fat Logs |
| [**updateBodyFatGoal**](BodyApi.md#updateBodyFatGoal) | **POST** /1/user/-/body/log/fat/goal.json | Update Body Fat Goal |
| [**updateWeightGoal**](BodyApi.md#updateWeightGoal) | **POST** /1/user/-/body/log/weight/goal.json | Update Weight Goal |


<a id="addBodyFatLog"></a>
# **addBodyFatLog**
> addBodyFatLog(fat, date, time)

Log Body Fat

Creates a log entry for body fat and returns a response in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val fat : kotlin.Int = 56 // kotlin.Int | Body fat in the format of X.XX in the unit system that corresponds to the Accept-Language header provided.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Log entry date in the format yyyy-MM-dd.
val time : kotlin.String = time_example // kotlin.String | Time of the measurement in hours and minutes in the format HH:mm:ss that is set to the last second of the day if not provided.
try {
    apiInstance.addBodyFatLog(fat, date, time)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#addBodyFatLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#addBodyFatLog")
    e.printStackTrace()
}
```

### Parameters
| **fat** | **kotlin.Int**| Body fat in the format of X.XX in the unit system that corresponds to the Accept-Language header provided. | |
| **date** | **java.time.LocalDate**| Log entry date in the format yyyy-MM-dd. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **time** | **kotlin.String**| Time of the measurement in hours and minutes in the format HH:mm:ss that is set to the last second of the day if not provided. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="addWeightLog"></a>
# **addWeightLog**
> addWeightLog(weight, date, time)

Log Weight

Creates log entry for a body weight using units in the unit systems that corresponds to the Accept-Language header provided and gets a response in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val weight : kotlin.Int = 56 // kotlin.Int | Weight in the format of X.XX.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Log entry date in the format yyyy-MM-dd.
val time : kotlin.String = time_example // kotlin.String | Time of the measurement; hours and minutes in the format of HH:mm:ss, which is set to the last second of the day if not provided.
try {
    apiInstance.addWeightLog(weight, date, time)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#addWeightLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#addWeightLog")
    e.printStackTrace()
}
```

### Parameters
| **weight** | **kotlin.Int**| Weight in the format of X.XX. | |
| **date** | **java.time.LocalDate**| Log entry date in the format yyyy-MM-dd. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **time** | **kotlin.String**| Time of the measurement; hours and minutes in the format of HH:mm:ss, which is set to the last second of the day if not provided. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteBodyFatLog"></a>
# **deleteBodyFatLog**
> deleteBodyFatLog(bodyFatLogId)

Delete Body Fat Log

Deletes a user&#39;s body fat log entry with the given ID.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val bodyFatLogId : kotlin.Int = 56 // kotlin.Int | The ID of the body fat log entry.
try {
    apiInstance.deleteBodyFatLog(bodyFatLogId)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#deleteBodyFatLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#deleteBodyFatLog")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **bodyFatLogId** | **kotlin.Int**| The ID of the body fat log entry. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteWeightLog"></a>
# **deleteWeightLog**
> deleteWeightLog(bodyWeightLogId)

Delete Weight Log

Deletes a user&#39;s body weight log entrywith the given ID.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val bodyWeightLogId : kotlin.Int = 56 // kotlin.Int | The ID of the body weight log entry.
try {
    apiInstance.deleteWeightLog(bodyWeightLogId)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#deleteWeightLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#deleteWeightLog")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **bodyWeightLogId** | **kotlin.Int**| The ID of the body weight log entry. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getBodyFatByDate"></a>
# **getBodyFatByDate**
> getBodyFatByDate(date)

Get Body Fat Logs

Retreives a list of all user&#39;s body fat log entries for a given day in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd.
try {
    apiInstance.getBodyFatByDate(date)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#getBodyFatByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#getBodyFatByDate")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getBodyFatByDatePeriod"></a>
# **getBodyFatByDatePeriod**
> getBodyFatByDatePeriod(date, period)

Get Body Fat Logs

Retreives a list of all user&#39;s body fat log entries for a given day in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd.
val period : kotlin.String = period_example // kotlin.String | The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max.
try {
    apiInstance.getBodyFatByDatePeriod(date, period)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#getBodyFatByDatePeriod")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#getBodyFatByDatePeriod")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **period** | **kotlin.String**| The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getBodyFatByDateRange"></a>
# **getBodyFatByDateRange**
> getBodyFatByDateRange(baseDate, endDate)

Get Body Fat Logs

Retreives a list of all user&#39;s body fat log entries for a given day in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val baseDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The range start date in the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the range.
try {
    apiInstance.getBodyFatByDateRange(baseDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#getBodyFatByDateRange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#getBodyFatByDateRange")
    e.printStackTrace()
}
```

### Parameters
| **baseDate** | **java.time.LocalDate**| The range start date in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endDate** | **java.time.LocalDate**| The end date of the range. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getBodyGoals"></a>
# **getBodyGoals**
> getBodyGoals(goalType)

Get Body Goals

Retreives a user&#39;s current body fat percentage or weight goal using units in the unit systems that corresponds to the Accept-Language header providedin the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val goalType : kotlin.String = goalType_example // kotlin.String | weight or fat.
try {
    apiInstance.getBodyGoals(goalType)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#getBodyGoals")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#getBodyGoals")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **goalType** | **kotlin.String**| weight or fat. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getWeightByDate"></a>
# **getWeightByDate**
> getWeightByDate(date)

Get Weight Logs

Retreives a list of all user&#39;s body weight log entries for a given day using units in the unit systems which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd.
try {
    apiInstance.getWeightByDate(date)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#getWeightByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#getWeightByDate")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getWeightByDatePeriod"></a>
# **getWeightByDatePeriod**
> getWeightByDatePeriod(date, period)

Get Body Fat Logs

Retreives a list of all user&#39;s body weight log entries for a given day in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd.
val period : kotlin.String = period_example // kotlin.String | The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max.
try {
    apiInstance.getWeightByDatePeriod(date, period)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#getWeightByDatePeriod")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#getWeightByDatePeriod")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **period** | **kotlin.String**| The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getWeightByDateRange"></a>
# **getWeightByDateRange**
> getWeightByDateRange(baseDate, endDate)

Get Body Fat Logs

Retreives a list of all user&#39;s body fat log entries for a given day in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val baseDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The range start date in the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the range.
try {
    apiInstance.getWeightByDateRange(baseDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#getWeightByDateRange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#getWeightByDateRange")
    e.printStackTrace()
}
```

### Parameters
| **baseDate** | **java.time.LocalDate**| The range start date in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endDate** | **java.time.LocalDate**| The end date of the range. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="updateBodyFatGoal"></a>
# **updateBodyFatGoal**
> updateBodyFatGoal(fat)

Update Body Fat Goal

Updates user&#39;s fat percentage goal.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val fat : kotlin.String = fat_example // kotlin.String | Target body fat percentage; in the format X.XX.
try {
    apiInstance.updateBodyFatGoal(fat)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#updateBodyFatGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#updateBodyFatGoal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **fat** | **kotlin.String**| Target body fat percentage; in the format X.XX. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="updateWeightGoal"></a>
# **updateWeightGoal**
> updateWeightGoal(startDate, startWeight, weight)

Update Weight Goal

Updates user&#39;s fat percentage goal.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyApi()
val startDate : kotlin.String = startDate_example // kotlin.String | Weight goal start date; in the format yyyy-MM-dd.
val startWeight : kotlin.String = startWeight_example // kotlin.String | Weight goal start weight; in the format X.XX, in the unit systems that corresponds to the Accept-Language header provided.
val weight : kotlin.String = weight_example // kotlin.String | Weight goal target weight; in the format X.XX, in the unit systems that corresponds to the Accept-Language header provided; required if user doesn't have an existing weight goal.
try {
    apiInstance.updateWeightGoal(startDate, startWeight, weight)
} catch (e: ClientException) {
    println("4xx response calling BodyApi#updateWeightGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyApi#updateWeightGoal")
    e.printStackTrace()
}
```

### Parameters
| **startDate** | **kotlin.String**| Weight goal start date; in the format yyyy-MM-dd. | |
| **startWeight** | **kotlin.String**| Weight goal start weight; in the format X.XX, in the unit systems that corresponds to the Accept-Language header provided. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **weight** | **kotlin.String**| Weight goal target weight; in the format X.XX, in the unit systems that corresponds to the Accept-Language header provided; required if user doesn&#39;t have an existing weight goal. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

