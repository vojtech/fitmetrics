# NutritionTimeSeriesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getFoodsByDateRange**](NutritionTimeSeriesApi.md#getFoodsByDateRange) | **GET** /1/user/-/foods/log/{resource-path}/date/{base-date}/{end-date}.json | Get Food or Water Time Series |
| [**getFoodsResourceByDatePeriod**](NutritionTimeSeriesApi.md#getFoodsResourceByDatePeriod) | **GET** /1/user/-/foods/log/{resource-path}/date/{date}/{period}.json | Get Food or Water Time Series |


<a id="getFoodsByDateRange"></a>
# **getFoodsByDateRange**
> getFoodsByDateRange(resourcePath, baseDate, endDate)

Get Food or Water Time Series

Updates a user&#39;s daily activity goals and returns a response using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resouce path. See options in the Resouce Path Options section in the full documentation.
val baseDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The range start date in the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the range.
try {
    apiInstance.getFoodsByDateRange(resourcePath, baseDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling NutritionTimeSeriesApi#getFoodsByDateRange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionTimeSeriesApi#getFoodsByDateRange")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resouce path. See options in the Resouce Path Options section in the full documentation. | [default to caloriesIn] [enum: caloriesIn, water] |
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

<a id="getFoodsResourceByDatePeriod"></a>
# **getFoodsResourceByDatePeriod**
> getFoodsResourceByDatePeriod(resourcePath, date, period)

Get Food or Water Time Series

Updates a user&#39;s daily activity goals and returns a response using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resouce path. See options in the Resouce Path Options section in the full documentation.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the period specified in the format yyyy-MM-dd or today.
val period : kotlin.String = period_example // kotlin.String | The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 3m, 6m, 1y, or max.
try {
    apiInstance.getFoodsResourceByDatePeriod(resourcePath, date, period)
} catch (e: ClientException) {
    println("4xx response calling NutritionTimeSeriesApi#getFoodsResourceByDatePeriod")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionTimeSeriesApi#getFoodsResourceByDatePeriod")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resouce path. See options in the Resouce Path Options section in the full documentation. | [default to caloriesIn] [enum: caloriesIn, water] |
| **date** | **java.time.LocalDate**| The end date of the period specified in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **period** | **kotlin.String**| The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 3m, 6m, 1y, or max. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

