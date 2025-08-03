# SubscriptionsApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addSubscriptions**](SubscriptionsApi.md#addSubscriptions) | **POST** /1/user/-/{collection-path}/apiSubscriptions/{subscription-id}.json | Add a Subscription |
| [**deleteSubscriptions**](SubscriptionsApi.md#deleteSubscriptions) | **DELETE** /1/user/-/{collection-path}/apiSubscriptions/{subscription-id}.json | Delete a Subscription |
| [**getSubscriptionsList**](SubscriptionsApi.md#getSubscriptionsList) | **GET** /1/user/-/{collection-path}/apiSubscriptions.json | Get a List of Subscriptions |


<a id="addSubscriptions"></a>
# **addSubscriptions**
> addSubscriptions(collectionPath, subscriptionId)

Add a Subscription

Adds a subscription in your application so that users can get notifications and return a response in the format requested. The subscription-id value provides a way to associate an update with a particular user stream in your application.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SubscriptionsApi()
val collectionPath : kotlin.String = collectionPath_example // kotlin.String | This is the resource of the collection to receive notifications from (foods, activities, sleep, or body). If not present, subscription will be created for all collections. If you have both all and specific collection subscriptions, you will get duplicate notifications on that collections' updates. Each subscriber can have only one subscription for a specific user's collection.
val subscriptionId : kotlin.String = subscriptionId_example // kotlin.String | This is the unique ID of the subscription created by the API client application. Each ID must be unique across the entire set of subscribers and collections. The Fitbit servers will pass this ID back along with any notifications about the user indicated by the user parameter in the URL path.
try {
    apiInstance.addSubscriptions(collectionPath, subscriptionId)
} catch (e: ClientException) {
    println("4xx response calling SubscriptionsApi#addSubscriptions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SubscriptionsApi#addSubscriptions")
    e.printStackTrace()
}
```

### Parameters
| **collectionPath** | **kotlin.String**| This is the resource of the collection to receive notifications from (foods, activities, sleep, or body). If not present, subscription will be created for all collections. If you have both all and specific collection subscriptions, you will get duplicate notifications on that collections&#39; updates. Each subscriber can have only one subscription for a specific user&#39;s collection. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **subscriptionId** | **kotlin.String**| This is the unique ID of the subscription created by the API client application. Each ID must be unique across the entire set of subscribers and collections. The Fitbit servers will pass this ID back along with any notifications about the user indicated by the user parameter in the URL path. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteSubscriptions"></a>
# **deleteSubscriptions**
> deleteSubscriptions(collectionPath, subscriptionId)

Delete a Subscription

Deletes a subscription for a user..

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SubscriptionsApi()
val collectionPath : kotlin.String = collectionPath_example // kotlin.String | This is the resource of the collection to receive notifications from (foods, activities, sleep, or body). If not present, subscription will be created for all collections. If you have both all and specific collection subscriptions, you will get duplicate notifications on that collections' updates. Each subscriber can have only one subscription for a specific user's collection.
val subscriptionId : kotlin.String = subscriptionId_example // kotlin.String | This is the resource of the collection to receive notifications from (foods, activities, sleep, or body). If not present, subscription will be created for all collections. If you have both all and specific collection subscriptions, you will get duplicate notifications on that collections' updates. Each subscriber can have only one subscription for a specific user's collection.
try {
    apiInstance.deleteSubscriptions(collectionPath, subscriptionId)
} catch (e: ClientException) {
    println("4xx response calling SubscriptionsApi#deleteSubscriptions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SubscriptionsApi#deleteSubscriptions")
    e.printStackTrace()
}
```

### Parameters
| **collectionPath** | **kotlin.String**| This is the resource of the collection to receive notifications from (foods, activities, sleep, or body). If not present, subscription will be created for all collections. If you have both all and specific collection subscriptions, you will get duplicate notifications on that collections&#39; updates. Each subscriber can have only one subscription for a specific user&#39;s collection. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **subscriptionId** | **kotlin.String**| This is the resource of the collection to receive notifications from (foods, activities, sleep, or body). If not present, subscription will be created for all collections. If you have both all and specific collection subscriptions, you will get duplicate notifications on that collections&#39; updates. Each subscriber can have only one subscription for a specific user&#39;s collection. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getSubscriptionsList"></a>
# **getSubscriptionsList**
> getSubscriptionsList(collectionPath)

Get a List of Subscriptions

Retreives a list of a user&#39;s subscriptions for your application in the format requested. You can either fetch subscriptions for a specific collection or the entire list of subscriptions for the user. For best practice, make sure that your application maintains this list on your side and use this endpoint only to periodically ensure data consistency.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = SubscriptionsApi()
val collectionPath : kotlin.String = collectionPath_example // kotlin.String | This is the resource of the collection to receive notifications from (foods, activities, sleep, or body). If not present, subscription will be created for all collections. If you have both all and specific collection subscriptions, you will get duplicate notifications on that collections' updates. Each subscriber can have only one subscription for a specific user's collection.
try {
    apiInstance.getSubscriptionsList(collectionPath)
} catch (e: ClientException) {
    println("4xx response calling SubscriptionsApi#getSubscriptionsList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SubscriptionsApi#getSubscriptionsList")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **collectionPath** | **kotlin.String**| This is the resource of the collection to receive notifications from (foods, activities, sleep, or body). If not present, subscription will be created for all collections. If you have both all and specific collection subscriptions, you will get duplicate notifications on that collections&#39; updates. Each subscriber can have only one subscription for a specific user&#39;s collection. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

