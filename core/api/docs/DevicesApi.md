# DevicesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addAlarms**](DevicesApi.md#addAlarms) | **POST** /1/user/-/devices/tracker/{tracker-id}/alarms.json | Add Alarm |
| [**deleteAlarms**](DevicesApi.md#deleteAlarms) | **DELETE** /1/user/-/devices/tracker/{tracker-id}/alarms/{alarm-id}.json | Delete Alarm |
| [**getAlarms**](DevicesApi.md#getAlarms) | **GET** /1/user/-/devices/tracker/{tracker-id}/alarms.json | Get Alarms |
| [**getDevices**](DevicesApi.md#getDevices) | **GET** /1/user/-/devices.json | Get Devices |
| [**updateAlarms**](DevicesApi.md#updateAlarms) | **POST** /1/user/-/devices/tracker/{tracker-id}/alarms/{alarm-id}.json | Update Alarm |


<a id="addAlarms"></a>
# **addAlarms**
> addAlarms(trackerId, time, enabled, recurring, weekDays)

Add Alarm

Adds the alarm settings to a given ID for a given device.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = DevicesApi()
val trackerId : kotlin.Int = 56 // kotlin.Int | The ID of the tracker for which data is returned. The tracker-id value is found via the Get Devices endpoint.
val time : kotlin.String = time_example // kotlin.String | Time of day that the alarm vibrates with a UTC timezone offset, e.g. 07:15-08:00.
val enabled : kotlin.Boolean = true // kotlin.Boolean | true or false. If false, alarm does not vibrate until enabled is set to true.
val recurring : kotlin.String = recurring_example // kotlin.String | true or false. If false, the alarm is a single event.
val weekDays : kotlin.String = weekDays_example // kotlin.String | Comma separated list of days of the week on which the alarm vibrates, e.g. MONDAY, TUESDAY.
try {
    apiInstance.addAlarms(trackerId, time, enabled, recurring, weekDays)
} catch (e: ClientException) {
    println("4xx response calling DevicesApi#addAlarms")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DevicesApi#addAlarms")
    e.printStackTrace()
}
```

### Parameters
| **trackerId** | **kotlin.Int**| The ID of the tracker for which data is returned. The tracker-id value is found via the Get Devices endpoint. | |
| **time** | **kotlin.String**| Time of day that the alarm vibrates with a UTC timezone offset, e.g. 07:15-08:00. | |
| **enabled** | **kotlin.Boolean**| true or false. If false, alarm does not vibrate until enabled is set to true. | |
| **recurring** | **kotlin.String**| true or false. If false, the alarm is a single event. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **weekDays** | **kotlin.String**| Comma separated list of days of the week on which the alarm vibrates, e.g. MONDAY, TUESDAY. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteAlarms"></a>
# **deleteAlarms**
> deleteAlarms(trackerId, alarmId)

Delete Alarm

Deletes the user&#39;s device alarm entry with the given ID for a given device.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = DevicesApi()
val trackerId : kotlin.Int = 56 // kotlin.Int | The ID of the tracker whose alarms is managed. The tracker-id value is found via the Get Devices endpoint.
val alarmId : kotlin.Int = 56 // kotlin.Int | The ID of the alarm to be updated. The alarm-id value is found via the Get Alarms endpoint.
try {
    apiInstance.deleteAlarms(trackerId, alarmId)
} catch (e: ClientException) {
    println("4xx response calling DevicesApi#deleteAlarms")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DevicesApi#deleteAlarms")
    e.printStackTrace()
}
```

### Parameters
| **trackerId** | **kotlin.Int**| The ID of the tracker whose alarms is managed. The tracker-id value is found via the Get Devices endpoint. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **alarmId** | **kotlin.Int**| The ID of the alarm to be updated. The alarm-id value is found via the Get Alarms endpoint. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getAlarms"></a>
# **getAlarms**
> getAlarms(trackerId)

Get Alarms

Returns alarms for a device

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = DevicesApi()
val trackerId : kotlin.Int = 56 // kotlin.Int | The ID of the tracker for which data is returned. The tracker-id value is found via the Get Devices endpoint.
try {
    apiInstance.getAlarms(trackerId)
} catch (e: ClientException) {
    println("4xx response calling DevicesApi#getAlarms")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DevicesApi#getAlarms")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **trackerId** | **kotlin.Int**| The ID of the tracker for which data is returned. The tracker-id value is found via the Get Devices endpoint. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getDevices"></a>
# **getDevices**
> getDevices()

Get Devices

Returns a list of the Fitbit devices connected to a user&#39;s account.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = DevicesApi()
try {
    apiInstance.getDevices()
} catch (e: ClientException) {
    println("4xx response calling DevicesApi#getDevices")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DevicesApi#getDevices")
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

<a id="updateAlarms"></a>
# **updateAlarms**
> updateAlarms(trackerId, alarmId, time, enabled, recurring, weekDays, snoozeLength, snoozeCount)

Update Alarm

Updates the alarm entry with a given ID for a given device. It also gets a response in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = DevicesApi()
val trackerId : kotlin.Int = 56 // kotlin.Int | The ID of the tracker for which data is returned. The tracker-id value is found via the Get Devices endpoint.
val alarmId : kotlin.Int = 56 // kotlin.Int | The ID of the alarm to be updated. The alarm-id value is found in the response of the Get Activity endpoint.
val time : kotlin.String = time_example // kotlin.String | Time of day that the alarm vibrates with a UTC timezone offset, e.g. 07:15-08:00.
val enabled : kotlin.Boolean = true // kotlin.Boolean | true or false. If false, the alarm does not vibrate until enabled is set to true.
val recurring : kotlin.String = recurring_example // kotlin.String | true or false. If false, the alarm is a single event.
val weekDays : kotlin.String = weekDays_example // kotlin.String | Comma seperated list of days of the week on which the alarm vibrates, e.g. MONDAY, TUESDAY.
val snoozeLength : kotlin.Int = 56 // kotlin.Int | Minutes between alarms.
val snoozeCount : kotlin.Int = 56 // kotlin.Int | Maximum snooze count.
try {
    apiInstance.updateAlarms(trackerId, alarmId, time, enabled, recurring, weekDays, snoozeLength, snoozeCount)
} catch (e: ClientException) {
    println("4xx response calling DevicesApi#updateAlarms")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DevicesApi#updateAlarms")
    e.printStackTrace()
}
```

### Parameters
| **trackerId** | **kotlin.Int**| The ID of the tracker for which data is returned. The tracker-id value is found via the Get Devices endpoint. | |
| **alarmId** | **kotlin.Int**| The ID of the alarm to be updated. The alarm-id value is found in the response of the Get Activity endpoint. | |
| **time** | **kotlin.String**| Time of day that the alarm vibrates with a UTC timezone offset, e.g. 07:15-08:00. | |
| **enabled** | **kotlin.Boolean**| true or false. If false, the alarm does not vibrate until enabled is set to true. | |
| **recurring** | **kotlin.String**| true or false. If false, the alarm is a single event. | |
| **weekDays** | **kotlin.String**| Comma seperated list of days of the week on which the alarm vibrates, e.g. MONDAY, TUESDAY. | |
| **snoozeLength** | **kotlin.Int**| Minutes between alarms. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **snoozeCount** | **kotlin.Int**| Maximum snooze count. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

