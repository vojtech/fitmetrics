# FriendsApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getFriends**](FriendsApi.md#getFriends) | **GET** /1.1/user/-/friends.json | Get Friends |
| [**getFriendsLeaderboard**](FriendsApi.md#getFriendsLeaderboard) | **GET** /1.1/user/-/leaderboard/friends.json | Get Friends Leaderboard |


<a id="getFriends"></a>
# **getFriends**
> getFriends()

Get Friends

Returns data of a user&#39;s friends in the format requested using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = FriendsApi()
try {
    apiInstance.getFriends()
} catch (e: ClientException) {
    println("4xx response calling FriendsApi#getFriends")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FriendsApi#getFriends")
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

<a id="getFriendsLeaderboard"></a>
# **getFriendsLeaderboard**
> getFriendsLeaderboard()

Get Friends Leaderboard

Returns data of a user&#39;s friends in the format requested using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = FriendsApi()
try {
    apiInstance.getFriendsLeaderboard()
} catch (e: ClientException) {
    println("4xx response calling FriendsApi#getFriendsLeaderboard")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FriendsApi#getFriendsLeaderboard")
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

