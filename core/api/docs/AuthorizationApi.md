# AuthorizationApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**introspect**](AuthorizationApi.md#introspect) | **POST** /1.1/oauth2/introspect | Retrieve the active state of an OAuth 2.0 token |
| [**oauthToken**](AuthorizationApi.md#oauthToken) | **POST** /oauth2/token | Get OAuth 2 access token |
| [**revoke**](AuthorizationApi.md#revoke) | **POST** /oauth2/revoke | Revokes consent of the access token or refresh token |


<a id="introspect"></a>
# **introspect**
> introspect(token)

Retrieve the active state of an OAuth 2.0 token

Retrieves the active state of an OAuth 2.0 token. It follows https://tools.ietf.org/html/rfc7662.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = AuthorizationApi()
val token : kotlin.String = token_example // kotlin.String | OAuth 2.0 token to retrieve the state of
try {
    apiInstance.introspect(token)
} catch (e: ClientException) {
    println("4xx response calling AuthorizationApi#introspect")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthorizationApi#introspect")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| OAuth 2.0 token to retrieve the state of | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

<a id="oauthToken"></a>
# **oauthToken**
> oauthToken(clientId, grantType, authorization, contentType, code, expiresIn, redirectUri, refreshToken, state)

Get OAuth 2 access token

Retrieves an OAuth 2 access token.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = AuthorizationApi()
val clientId : kotlin.String = clientId_example // kotlin.String | This is your Fitbit API application id from your settings on dev.fitbit.com.
val grantType : kotlin.String = grantType_example // kotlin.String | Authorization grant type. Valid values are 'authorization_code' and 'refresh_token'.
val authorization : kotlin.String = authorization_example // kotlin.String | The Authorization header must be set to 'Basic' followed by a space, then the Base64 encoded string of your application's client id and secret concatenated with a colon. For example, 'Basic Y2xpZW50X2lkOmNsaWVudCBzZWNyZXQ='. The Base64 encoded string, 'Y2xpZW50X2lkOmNsaWVudCBzZWNyZXQ=', is decoded as 'client_id:client secret'.
val contentType : kotlin.String = contentType_example // kotlin.String | Request Content-Type. Should be application/x-www-form-urlencoded
val code : kotlin.String = code_example // kotlin.String | Authorization code received in the redirect as URI parameter. Required if using the Authorization Code flow.
val expiresIn : kotlin.String = expiresIn_example // kotlin.String | Specify the desired access token lifetime. Defaults to 28800 for 8 hours. The other valid value is 3600 for 1 hour.
val redirectUri : kotlin.String = redirectUri_example // kotlin.String | Uri to which the access token will be sent if the request is successful. Required if specified in the redirect to the authorization page. Must be exact match.
val refreshToken : kotlin.String = refreshToken_example // kotlin.String | Refresh token issued by Fitbit. Required if 'grant_type' is 'refresh_token'.
val state : kotlin.String = state_example // kotlin.String | Required if specified in the redirect uri of the authorization page. Must be an exact match.
try {
    apiInstance.oauthToken(clientId, grantType, authorization, contentType, code, expiresIn, redirectUri, refreshToken, state)
} catch (e: ClientException) {
    println("4xx response calling AuthorizationApi#oauthToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthorizationApi#oauthToken")
    e.printStackTrace()
}
```

### Parameters
| **clientId** | **kotlin.String**| This is your Fitbit API application id from your settings on dev.fitbit.com. | |
| **grantType** | **kotlin.String**| Authorization grant type. Valid values are &#39;authorization_code&#39; and &#39;refresh_token&#39;. | |
| **authorization** | **kotlin.String**| The Authorization header must be set to &#39;Basic&#39; followed by a space, then the Base64 encoded string of your application&#39;s client id and secret concatenated with a colon. For example, &#39;Basic Y2xpZW50X2lkOmNsaWVudCBzZWNyZXQ&#x3D;&#39;. The Base64 encoded string, &#39;Y2xpZW50X2lkOmNsaWVudCBzZWNyZXQ&#x3D;&#39;, is decoded as &#39;client_id:client secret&#39;. | [optional] |
| **contentType** | **kotlin.String**| Request Content-Type. Should be application/x-www-form-urlencoded | [optional] |
| **code** | **kotlin.String**| Authorization code received in the redirect as URI parameter. Required if using the Authorization Code flow. | [optional] |
| **expiresIn** | **kotlin.String**| Specify the desired access token lifetime. Defaults to 28800 for 8 hours. The other valid value is 3600 for 1 hour. | [optional] |
| **redirectUri** | **kotlin.String**| Uri to which the access token will be sent if the request is successful. Required if specified in the redirect to the authorization page. Must be exact match. | [optional] |
| **refreshToken** | **kotlin.String**| Refresh token issued by Fitbit. Required if &#39;grant_type&#39; is &#39;refresh_token&#39;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **state** | **kotlin.String**| Required if specified in the redirect uri of the authorization page. Must be an exact match. | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="revoke"></a>
# **revoke**
> revoke(token)

Revokes consent of the access token or refresh token

Revokes consent of the access token or refresh token

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = AuthorizationApi()
val token : kotlin.String = token_example // kotlin.String | The access token or refresh token to be revoked
try {
    apiInstance.revoke(token)
} catch (e: ClientException) {
    println("4xx response calling AuthorizationApi#revoke")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AuthorizationApi#revoke")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| The access token or refresh token to be revoked | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

