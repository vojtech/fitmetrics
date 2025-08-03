# ActivityApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addActivitiesLog**](ActivityApi.md#addActivitiesLog) | **POST** /1/user/-/activities.json | Log Activity |
| [**addFavoriteActivities**](ActivityApi.md#addFavoriteActivities) | **POST** /1/user/-/activities/favorite/{activity-id}.json | Add Favorite Activity |
| [**addUpdateActivitiesGoals**](ActivityApi.md#addUpdateActivitiesGoals) | **POST** /1/user/-/activities/goals/{period}.json | Update Activity Goals |
| [**deleteActivitiesLog**](ActivityApi.md#deleteActivitiesLog) | **DELETE** /1/user/-/activities/{activity-log-id}.json | Delete Activity Log |
| [**deleteFavoriteActivities**](ActivityApi.md#deleteFavoriteActivities) | **DELETE** /1/user/-/activities/favorite/{activity-id}.json | Delete Favorite Activity |
| [**getActivitiesByDate**](ActivityApi.md#getActivitiesByDate) | **GET** /1/user/-/activities/date/{date}.json | Get Activity Summary by Date  |
| [**getActivitiesGoals**](ActivityApi.md#getActivitiesGoals) | **GET** /1/user/-/activities/goals/{period}.json | Get Activity Goals |
| [**getActivitiesLog**](ActivityApi.md#getActivitiesLog) | **GET** /1/user/-/activities.json | Get Lifetime Stats |
| [**getActivitiesLogList**](ActivityApi.md#getActivitiesLogList) | **GET** /1/user/-/activities/list.json | Get Activity Log List |
| [**getActivitiesTCX**](ActivityApi.md#getActivitiesTCX) | **GET** /1/user/-/activities/{log-id}.tcx | Get Activity TCX |
| [**getActivitiesTypeDetail**](ActivityApi.md#getActivitiesTypeDetail) | **GET** /1/activities/{activity-id}.json | Get Activity Type |
| [**getActivitiesTypes**](ActivityApi.md#getActivitiesTypes) | **GET** /1/activities.json | Browse Activity Types |
| [**getFavoriteActivities**](ActivityApi.md#getFavoriteActivities) | **GET** /1/user/-/activities/favorite.json | Get Favorite Activities |
| [**getFrequentActivities**](ActivityApi.md#getFrequentActivities) | **GET** /1/user/-/activities/frequent.json | Get Frequent Activities |
| [**getRecentActivities**](ActivityApi.md#getRecentActivities) | **GET** /1/user/-/activities/recent.json | Get Recent Activity Types |


<a id="addActivitiesLog"></a>
# **addActivitiesLog**
> addActivitiesLog(activityId, manualCalories, startTime, durationMillis, date, distance, activityName, distanceUnit)

Log Activity

The Log Activity endpoint creates log entry for an activity or user&#39;s private custom activity using units in the unit system which corresponds to the Accept-Language header provided (or using optional custom distanceUnit) and get a response in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val activityId : kotlin.Int = 56 // kotlin.Int | The ID of the activity, directory activity or intensity level activity.
val manualCalories : kotlin.Int = 56 // kotlin.Int | Calories burned that are manaully specified. Required with activityName must be provided.
val startTime : kotlin.String = startTime_example // kotlin.String | Activity start time. Hours and minutes in the format HH:mm:ss.
val durationMillis : kotlin.Int = 56 // kotlin.Int | Duration in milliseconds.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Log entry date in the format yyyy-MM-dd.
val distance : kotlin.Int = 56 // kotlin.Int | Distance is required for logging directory activity in the format X.XX and in the selected distanceUnit.
val activityName : kotlin.String = activityName_example // kotlin.String | Custom activity name. Either activityId or activityName must be provided.
val distanceUnit : kotlin.Int = 56 // kotlin.Int | Distance measurement unit. Steps units are available only for Walking (activityId=90013) and Running (activityId=90009) directory activities and their intensity levels.
try {
    apiInstance.addActivitiesLog(activityId, manualCalories, startTime, durationMillis, date, distance, activityName, distanceUnit)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#addActivitiesLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#addActivitiesLog")
    e.printStackTrace()
}
```

### Parameters
| **activityId** | **kotlin.Int**| The ID of the activity, directory activity or intensity level activity. | |
| **manualCalories** | **kotlin.Int**| Calories burned that are manaully specified. Required with activityName must be provided. | |
| **startTime** | **kotlin.String**| Activity start time. Hours and minutes in the format HH:mm:ss. | |
| **durationMillis** | **kotlin.Int**| Duration in milliseconds. | |
| **date** | **java.time.LocalDate**| Log entry date in the format yyyy-MM-dd. | |
| **distance** | **kotlin.Int**| Distance is required for logging directory activity in the format X.XX and in the selected distanceUnit. | |
| **activityName** | **kotlin.String**| Custom activity name. Either activityId or activityName must be provided. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **distanceUnit** | **kotlin.Int**| Distance measurement unit. Steps units are available only for Walking (activityId&#x3D;90013) and Running (activityId&#x3D;90009) directory activities and their intensity levels. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="addFavoriteActivities"></a>
# **addFavoriteActivities**
> addFavoriteActivities(activityId)

Add Favorite Activity

Adds the activity with the given ID to user&#39;s list of favorite activities.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val activityId : kotlin.String = activityId_example // kotlin.String | The encoded ID of the activity.
try {
    apiInstance.addFavoriteActivities(activityId)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#addFavoriteActivities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#addFavoriteActivities")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **activityId** | **kotlin.String**| The encoded ID of the activity. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="addUpdateActivitiesGoals"></a>
# **addUpdateActivitiesGoals**
> addUpdateActivitiesGoals(period, type, `value`)

Update Activity Goals

Updates a user&#39;s daily or weekly activity goals and returns a response using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val period : kotlin.String = period_example // kotlin.String | daily or weekly.
val type : kotlin.String = type_example // kotlin.String | goal type
val `value` : kotlin.String = `value`_example // kotlin.String | goal value
try {
    apiInstance.addUpdateActivitiesGoals(period, type, `value`)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#addUpdateActivitiesGoals")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#addUpdateActivitiesGoals")
    e.printStackTrace()
}
```

### Parameters
| **period** | **kotlin.String**| daily or weekly. | |
| **type** | **kotlin.String**| goal type | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **&#x60;value&#x60;** | **kotlin.String**| goal value | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteActivitiesLog"></a>
# **deleteActivitiesLog**
> deleteActivitiesLog(activityLogId)

Delete Activity Log

Deletes a user&#39;s activity log entry with the given ID.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val activityLogId : kotlin.Int = 56 // kotlin.Int | The id of the activity log entry.
try {
    apiInstance.deleteActivitiesLog(activityLogId)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#deleteActivitiesLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#deleteActivitiesLog")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **activityLogId** | **kotlin.Int**| The id of the activity log entry. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteFavoriteActivities"></a>
# **deleteFavoriteActivities**
> deleteFavoriteActivities(activityId)

Delete Favorite Activity

Removes the activity with the given ID from a user&#39;s list of favorite activities.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val activityId : kotlin.String = activityId_example // kotlin.String | The ID of the activity to be removed.
try {
    apiInstance.deleteFavoriteActivities(activityId)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#deleteFavoriteActivities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#deleteFavoriteActivities")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **activityId** | **kotlin.String**| The ID of the activity to be removed. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesByDate"></a>
# **getActivitiesByDate**
> getActivitiesByDate(date)

Get Activity Summary by Date 

Retrieves a summary and list of a user&#39;s activities and activity log entries for a given day.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-dd
try {
    apiInstance.getActivitiesByDate(date)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getActivitiesByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getActivitiesByDate")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| The date in the format yyyy-MM-dd | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesGoals"></a>
# **getActivitiesGoals**
> getActivitiesGoals(period)

Get Activity Goals

Retreives a user&#39;s current daily or weekly activity goals using measurement units as defined in the unit system, which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val period : kotlin.String = period_example // kotlin.String | daily or weekly.
try {
    apiInstance.getActivitiesGoals(period)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getActivitiesGoals")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getActivitiesGoals")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **period** | **kotlin.String**| daily or weekly. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesLog"></a>
# **getActivitiesLog**
> getActivitiesLog()

Get Lifetime Stats

Updates a user&#39;s daily activity goals and returns a response using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
try {
    apiInstance.getActivitiesLog()
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getActivitiesLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getActivitiesLog")
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

<a id="getActivitiesLogList"></a>
# **getActivitiesLogList**
> getActivitiesLogList(sort, offset, limit, beforeDate, afterDate)

Get Activity Log List

Retreives a list of user&#39;s activity log entries before or after a given day with offset and limit using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val sort : kotlin.String = sort_example // kotlin.String | The sort order of entries by date asc (ascending) or desc (descending).
val offset : kotlin.Int = 56 // kotlin.Int | The offset number of entries.
val limit : kotlin.Int = 56 // kotlin.Int | The maximum number of entries returned (maximum;100).
val beforeDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-ddTHH:mm:ss. Only yyyy-MM-dd is required. Either beforeDate or afterDate should be specified.
val afterDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date in the format yyyy-MM-ddTHH:mm:ss.
try {
    apiInstance.getActivitiesLogList(sort, offset, limit, beforeDate, afterDate)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getActivitiesLogList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getActivitiesLogList")
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

<a id="getActivitiesTCX"></a>
# **getActivitiesTCX**
> getActivitiesTCX(logId, includePartialTCX)

Get Activity TCX

Retreives the details of a user&#39;s location and heart rate data during a logged exercise activity.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val logId : kotlin.String = logId_example // kotlin.String | The activity's log ID.
val includePartialTCX : kotlin.Boolean = true // kotlin.Boolean | Include TCX points regardless of GPS data being present
try {
    apiInstance.getActivitiesTCX(logId, includePartialTCX)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getActivitiesTCX")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getActivitiesTCX")
    e.printStackTrace()
}
```

### Parameters
| **logId** | **kotlin.String**| The activity&#39;s log ID. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **includePartialTCX** | **kotlin.Boolean**| Include TCX points regardless of GPS data being present | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesTypeDetail"></a>
# **getActivitiesTypeDetail**
> getActivitiesTypeDetail(activityId)

Get Activity Type

Returns the detail of a specific activity in the Fitbit activities database in the format requested. If activity has levels, it also returns a list of activity level details.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
val activityId : kotlin.String = activityId_example // kotlin.String | The activity ID.
try {
    apiInstance.getActivitiesTypeDetail(activityId)
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getActivitiesTypeDetail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getActivitiesTypeDetail")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **activityId** | **kotlin.String**| The activity ID. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getActivitiesTypes"></a>
# **getActivitiesTypes**
> getActivitiesTypes()

Browse Activity Types

Retreives a tree of all valid Fitbit public activities from the activities catelog as well as private custom activities the user created in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
try {
    apiInstance.getActivitiesTypes()
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getActivitiesTypes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getActivitiesTypes")
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

<a id="getFavoriteActivities"></a>
# **getFavoriteActivities**
> getFavoriteActivities()

Get Favorite Activities

Returns a list of a user&#39;s favorite activities.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
try {
    apiInstance.getFavoriteActivities()
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getFavoriteActivities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getFavoriteActivities")
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

<a id="getFrequentActivities"></a>
# **getFrequentActivities**
> getFrequentActivities()

Get Frequent Activities

Retreives a list of a user&#39;s frequent activities in the format requested using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
try {
    apiInstance.getFrequentActivities()
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getFrequentActivities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getFrequentActivities")
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

<a id="getRecentActivities"></a>
# **getRecentActivities**
> getRecentActivities()

Get Recent Activity Types

Retreives a list of a user&#39;s recent activities types logged with some details of the last activity log of that type using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = ActivityApi()
try {
    apiInstance.getRecentActivities()
} catch (e: ClientException) {
    println("4xx response calling ActivityApi#getRecentActivities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityApi#getRecentActivities")
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

