# UserApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getBadges**](UserApi.md#getBadges) | **GET** /1/user/-/badges.json | Get Badges |
| [**getProfile**](UserApi.md#getProfile) | **GET** /1/user/-/profile.json | Get Profile |


<a id="getBadges"></a>
# **getBadges**
> getBadges()

Get Badges

Retrieves the user&#39;s badges in the format requested. Response includes all badges for the user as seen on the Fitbit website badge locker (both activity and weight related.) The endpoint returns weight and distance badges based on the user&#39;s unit profile preference as on the website.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = UserApi()
try {
    apiInstance.getBadges()
} catch (e: ClientException) {
    println("4xx response calling UserApi#getBadges")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getBadges")
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

<a id="getProfile"></a>
# **getProfile**
> getProfile()

Get Profile

Returns a user&#39;s profile. The authenticated owner receives all values. However, the authenticated user&#39;s access to other users&#39; data is subject to those users&#39; privacy settings. Numerical values are returned in the unit system specified in the Accept-Language header.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = UserApi()
try {
    apiInstance.getProfile()
} catch (e: ClientException) {
    println("4xx response calling UserApi#getProfile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getProfile")
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

