# HeartRateTimeSeriesApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getHeartByDatePeriod**](HeartRateTimeSeriesApi.md#getHeartByDatePeriod) | **GET** /1/user/-/activities/heart/date/{date}/{period}.json | Get Heart Rate Time Series |
| [**getHeartByDateRange**](HeartRateTimeSeriesApi.md#getHeartByDateRange) | **GET** /1/user/-/activities/heart/date/{base-date}/{end-date}.json | Get Heart Rate Time Series |


<a id="getHeartByDatePeriod"></a>
# **getHeartByDatePeriod**
> getHeartByDatePeriod(date, period)

Get Heart Rate Time Series

Returns the time series data in the specified range for a given resource in the format requested using units in the unit systems that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateTimeSeriesApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the period specified in the format yyyy-MM-dd or today.
val period : kotlin.String = period_example // kotlin.String | The range of which data will be returned. Options are 1d, 7d, 30d, 1w, and 1m.
try {
    apiInstance.getHeartByDatePeriod(date, period)
} catch (e: ClientException) {
    println("4xx response calling HeartRateTimeSeriesApi#getHeartByDatePeriod")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateTimeSeriesApi#getHeartByDatePeriod")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The end date of the period specified in the format yyyy-MM-dd or today. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **period** | **kotlin.String**| The range of which data will be returned. Options are 1d, 7d, 30d, 1w, and 1m. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getHeartByDateRange"></a>
# **getHeartByDateRange**
> getHeartByDateRange(baseDate, endDate)

Get Heart Rate Time Series

Returns the time series data in the specified range for a given resource in the format requested using units in the unit systems that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = HeartRateTimeSeriesApi()
val baseDate : kotlin.String = baseDate_example // kotlin.String | The range start date in  the format yyyy-MM-dd or today.
val endDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The end date of the range.
try {
    apiInstance.getHeartByDateRange(baseDate, endDate)
} catch (e: ClientException) {
    println("4xx response calling HeartRateTimeSeriesApi#getHeartByDateRange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HeartRateTimeSeriesApi#getHeartByDateRange")
    e.printStackTrace()
}
```

### Parameters
| **baseDate** | **kotlin.String**| The range start date in  the format yyyy-MM-dd or today. | |
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

