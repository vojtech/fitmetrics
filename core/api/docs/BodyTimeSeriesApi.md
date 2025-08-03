# BodyTimeSeriesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getBodyResourceByDatePeriod**](BodyTimeSeriesApi.md#getBodyResourceByDatePeriod) | **GET** /1/user/-/body/{resource-path}/date/{date}/{period}.json | Get Body Time Series |
| [**getBodyResourceByDateRange**](BodyTimeSeriesApi.md#getBodyResourceByDateRange) | **GET** /1/user/-/body/{resource-path}/date/{base-date}/{end-date}.json | Get Body Time Series |


<a id="getBodyResourceByDatePeriod"></a>
# **getBodyResourceByDatePeriod**
> getBodyResourceByDatePeriod(resourcePath, date, period)

Get Body Time Series

Returns time series data in the specified range for a given resource in the format requested using units in the unit system that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource path, which incudes the bmi, fat, or weight options.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The range start date in the format yyyy-MM-dd or today.
val period : kotlin.String = period_example // kotlin.String | The range for which data will be returned. Options are 1d, 7d, 30d, 1w, 1m, 3m, 6m, 1y, or max.
try {
    apiInstance.getBodyResourceByDatePeriod(resourcePath, date, period)
} catch (e: ClientException) {
    println("4xx response calling BodyTimeSeriesApi#getBodyResourceByDatePeriod")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyTimeSeriesApi#getBodyResourceByDatePeriod")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource path, which incudes the bmi, fat, or weight options. | [default to weight] [enum: bmi, fat, weight] |
| **date** | **java.time.LocalDate**| The range start date in the format yyyy-MM-dd or today. | |
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

<a id="getBodyResourceByDateRange"></a>
# **getBodyResourceByDateRange**
> getBodyResourceByDateRange(resourcePath, baseDate, endDate)

Get Body Time Series

Returns time series data in the specified range for a given resource in the format requested using units in the unit system that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = BodyTimeSeriesApi()
val resourcePath : kotlin.String = resourcePath_example // kotlin.String | The resource path, which incudes the bmi, fat, or weight options.
val baseDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The range start date in the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the range.
try {
    apiInstance.getBodyResourceByDateRange(resourcePath, baseDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling BodyTimeSeriesApi#getBodyResourceByDateRange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BodyTimeSeriesApi#getBodyResourceByDateRange")
    e.printStackTrace()
}
```

### Parameters
| **resourcePath** | **kotlin.String**| The resource path, which incudes the bmi, fat, or weight options. | [default to weight] [enum: bmi, fat, weight] |
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

