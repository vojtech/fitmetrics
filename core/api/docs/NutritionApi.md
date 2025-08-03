# NutritionApi

All URIs are relative to *https://api.fitbit.com*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addFavoriteFood**](NutritionApi.md#addFavoriteFood) | **POST** /1/user/-/foods/log/favorite/{food-id}.json | Add Favorite Food |
| [**addFoods**](NutritionApi.md#addFoods) | **POST** /1/user/-/foods.json | Create Food |
| [**addFoodsLog**](NutritionApi.md#addFoodsLog) | **POST** /1/user/-/foods/log.json | Log Food |
| [**addMeal**](NutritionApi.md#addMeal) | **POST** /1/user/-/meals.json | Create Meal |
| [**addUpdateFoodsGoal**](NutritionApi.md#addUpdateFoodsGoal) | **POST** /1/user/-/foods/log/goal.json | Update Food Goal |
| [**addUpdateWaterGoal**](NutritionApi.md#addUpdateWaterGoal) | **POST** /1/user/-/foods/log/water/goal.json | Update Water Goal |
| [**addWaterLog**](NutritionApi.md#addWaterLog) | **POST** /1/user/-/foods/log/water.json | Log Water |
| [**deleteFavoriteFood**](NutritionApi.md#deleteFavoriteFood) | **DELETE** /1/user/-/foods/log/favorite/{food-id}.json | Delete Favorite Food |
| [**deleteFoods**](NutritionApi.md#deleteFoods) | **DELETE** /1/user/-/foods/{food-id}.json | Delete Custom Food |
| [**deleteFoodsLog**](NutritionApi.md#deleteFoodsLog) | **DELETE** /1/user/-/foods/log/{food-log-id}.json | Delete Food Log |
| [**deleteWaterLog**](NutritionApi.md#deleteWaterLog) | **DELETE** /1/user/-/foods/log/water/{water-log-id}.json | Delete Water Log |
| [**editFoodsLog**](NutritionApi.md#editFoodsLog) | **POST** /1/user/-/foods/log/{food-log-id}.json | Edit Food Log |
| [**getFavoriteFoods**](NutritionApi.md#getFavoriteFoods) | **GET** /1/user/-/foods/log/favorite.json | Get Favorite Foods |
| [**getFoodsByDate**](NutritionApi.md#getFoodsByDate) | **GET** /1/user/-/foods/log/date/{date}.json | Get Food Logs |
| [**getFoodsGoal**](NutritionApi.md#getFoodsGoal) | **GET** /1/user/-/foods/log/goal.json | Get Food Goals |
| [**getFoodsInfo**](NutritionApi.md#getFoodsInfo) | **GET** /1/foods/{food-id}.json | Get Food |
| [**getFoodsList**](NutritionApi.md#getFoodsList) | **GET** /1/foods/search.json | Search Foods |
| [**getFoodsLocales**](NutritionApi.md#getFoodsLocales) | **GET** /1/foods/locales.json | Get Food Locales |
| [**getFoodsUnits**](NutritionApi.md#getFoodsUnits) | **GET** /1/foods/units.json | Get Food Units |
| [**getFrequentFoods**](NutritionApi.md#getFrequentFoods) | **GET** /1/user/-/foods/log/frequent.json | Get Frequent Foods |
| [**getMeals**](NutritionApi.md#getMeals) | **GET** /1/user/-/meals.json | Get Meals |
| [**getRecentFoods**](NutritionApi.md#getRecentFoods) | **GET** /1/user/-/foods/log/recent.json | Get Recent Foods |
| [**getWaterByDate**](NutritionApi.md#getWaterByDate) | **GET** /1/user/-/foods/log/water/date/{date}.json | Get Water Logs |
| [**getWaterGoal**](NutritionApi.md#getWaterGoal) | **GET** /1/user/-/foods/log/water/goal.json | Get Water Goal |
| [**updateWaterLog**](NutritionApi.md#updateWaterLog) | **POST** /1/user/-/foods/log/water/{water-log-id}.json | Update Water Log |


<a id="addFavoriteFood"></a>
# **addFavoriteFood**
> addFavoriteFood(foodId)

Add Favorite Food

Updates a user&#39;s daily activity goals and returns a response using units in the unit system which corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val foodId : kotlin.String = foodId_example // kotlin.String | The ID of the food to be added to user's favorites.
try {
    apiInstance.addFavoriteFood(foodId)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#addFavoriteFood")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#addFavoriteFood")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **foodId** | **kotlin.String**| The ID of the food to be added to user&#39;s favorites. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="addFoods"></a>
# **addFoods**
> addFoods(name, defaultFoodMeasurementUnitId, defaultServingSize, calories, formType, description)

Create Food

Creates a new private food for a user and returns a response in the format requested. The created food is found via the Search Foods call.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val name : kotlin.String = name_example // kotlin.String | The food name.
val defaultFoodMeasurementUnitId : kotlin.String = defaultFoodMeasurementUnitId_example // kotlin.String | The ID of the default measurement unit. Full list of units can be retrieved via the Get Food Units endpoint.
val defaultServingSize : kotlin.String = defaultServingSize_example // kotlin.String | The size of the default serving. Nutrition values should be provided for this serving size.
val calories : kotlin.String = calories_example // kotlin.String | The calories in the default serving size.
val formType : kotlin.String = formType_example // kotlin.String | Form type; LIQUID or DRY.
val description : kotlin.String = description_example // kotlin.String | The description of the food.
try {
    apiInstance.addFoods(name, defaultFoodMeasurementUnitId, defaultServingSize, calories, formType, description)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#addFoods")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#addFoods")
    e.printStackTrace()
}
```

### Parameters
| **name** | **kotlin.String**| The food name. | |
| **defaultFoodMeasurementUnitId** | **kotlin.String**| The ID of the default measurement unit. Full list of units can be retrieved via the Get Food Units endpoint. | |
| **defaultServingSize** | **kotlin.String**| The size of the default serving. Nutrition values should be provided for this serving size. | |
| **calories** | **kotlin.String**| The calories in the default serving size. | |
| **formType** | **kotlin.String**| Form type; LIQUID or DRY. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **description** | **kotlin.String**| The description of the food. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="addFoodsLog"></a>
# **addFoodsLog**
> addFoodsLog(foodId, mealTypeId, unitId, amount, date, foodName, favorite, brandName, calories)

Log Food

Creates food log entries for users with or without foodId value.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val foodId : kotlin.String = foodId_example // kotlin.String | The ID of the food to be logged. Either foodId or foodName must be provided.
val mealTypeId : kotlin.String = mealTypeId_example // kotlin.String | Meal types. 1=Breakfast; 2=Morning Snack; 3=Lunch; 4=Afternoon Snack; 5=Dinner; 7=Anytime.
val unitId : kotlin.String = unitId_example // kotlin.String | The ID of units used. Typically retrieved via a previous call to Get Food Logs, Search Foods, or Get Food Units.
val amount : kotlin.String = amount_example // kotlin.String | The amount consumed in the format X.XX in the specified unitId.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Log entry date in the format yyyy-MM-dd.
val foodName : kotlin.String = foodName_example // kotlin.String | Food entry name. Either foodId or foodName must be provided.
val favorite : kotlin.Boolean = true // kotlin.Boolean | The `true` value will add the food to the user's favorites after creating the log entry; while the `false` value will not. Valid only with foodId value.
val brandName : kotlin.String = brandName_example // kotlin.String | Brand name of food. Valid only with foodName parameters.
val calories : kotlin.Int = 56 // kotlin.Int | Calories for this serving size. This is allowed with foodName parameter (default to zero); otherwise it is ignored.
try {
    apiInstance.addFoodsLog(foodId, mealTypeId, unitId, amount, date, foodName, favorite, brandName, calories)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#addFoodsLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#addFoodsLog")
    e.printStackTrace()
}
```

### Parameters
| **foodId** | **kotlin.String**| The ID of the food to be logged. Either foodId or foodName must be provided. | |
| **mealTypeId** | **kotlin.String**| Meal types. 1&#x3D;Breakfast; 2&#x3D;Morning Snack; 3&#x3D;Lunch; 4&#x3D;Afternoon Snack; 5&#x3D;Dinner; 7&#x3D;Anytime. | |
| **unitId** | **kotlin.String**| The ID of units used. Typically retrieved via a previous call to Get Food Logs, Search Foods, or Get Food Units. | |
| **amount** | **kotlin.String**| The amount consumed in the format X.XX in the specified unitId. | |
| **date** | **java.time.LocalDate**| Log entry date in the format yyyy-MM-dd. | |
| **foodName** | **kotlin.String**| Food entry name. Either foodId or foodName must be provided. | [optional] |
| **favorite** | **kotlin.Boolean**| The &#x60;true&#x60; value will add the food to the user&#39;s favorites after creating the log entry; while the &#x60;false&#x60; value will not. Valid only with foodId value. | [optional] |
| **brandName** | **kotlin.String**| Brand name of food. Valid only with foodName parameters. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **calories** | **kotlin.Int**| Calories for this serving size. This is allowed with foodName parameter (default to zero); otherwise it is ignored. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="addMeal"></a>
# **addMeal**
> addMeal(meal)

Create Meal

Creates a meal with the given food contained in the post body.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val meal : Meal =  // Meal | Meal to create
try {
    apiInstance.addMeal(meal)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#addMeal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#addMeal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **meal** | [**Meal**](Meal.md)| Meal to create | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a id="addUpdateFoodsGoal"></a>
# **addUpdateFoodsGoal**
> addUpdateFoodsGoal(calories, intensity, personalized)

Update Food Goal

Updates a user&#39;s daily calories consumption goal or food plan and returns a response in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val calories : kotlin.Int = 56 // kotlin.Int | Manual calorie consumption goal in either calories or intensity must be provided.
val intensity : kotlin.String = intensity_example // kotlin.String | Food plan intensity (MAINTENANCE, EASIER, MEDIUM, KINDAHARD, or HARDER). Either calories or intensity must be provided.
val personalized : kotlin.String = personalized_example // kotlin.String | Food plan type; true or false.
try {
    apiInstance.addUpdateFoodsGoal(calories, intensity, personalized)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#addUpdateFoodsGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#addUpdateFoodsGoal")
    e.printStackTrace()
}
```

### Parameters
| **calories** | **kotlin.Int**| Manual calorie consumption goal in either calories or intensity must be provided. | |
| **intensity** | **kotlin.String**| Food plan intensity (MAINTENANCE, EASIER, MEDIUM, KINDAHARD, or HARDER). Either calories or intensity must be provided. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **personalized** | **kotlin.String**| Food plan type; true or false. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="addUpdateWaterGoal"></a>
# **addUpdateWaterGoal**
> addUpdateWaterGoal(target)

Update Water Goal

Updates a user&#39;s daily calories consumption goal or food plan and returns a response in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val target : kotlin.Int = 56 // kotlin.Int | The target water goal in the format X.X is set in unit based on locale.
try {
    apiInstance.addUpdateWaterGoal(target)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#addUpdateWaterGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#addUpdateWaterGoal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **target** | **kotlin.Int**| The target water goal in the format X.X is set in unit based on locale. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="addWaterLog"></a>
# **addWaterLog**
> addWaterLog(date, amount, unit)

Log Water

Creates a log entry for water using units in the unit systems that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date of records to be returned in the format yyyy-MM-dd.
val amount : kotlin.Int = 56 // kotlin.Int | The amount consumption in the format X.XX and in the specified waterUnit or in the unit system that corresponds to the Accept-Language header provided.
val unit : kotlin.String = unit_example // kotlin.String | Water measurement unit; `ml`, `fl oz`, or `cup`.
try {
    apiInstance.addWaterLog(date, amount, unit)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#addWaterLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#addWaterLog")
    e.printStackTrace()
}
```

### Parameters
| **date** | **java.time.LocalDate**| The date of records to be returned in the format yyyy-MM-dd. | |
| **amount** | **kotlin.Int**| The amount consumption in the format X.XX and in the specified waterUnit or in the unit system that corresponds to the Accept-Language header provided. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **unit** | **kotlin.String**| Water measurement unit; &#x60;ml&#x60;, &#x60;fl oz&#x60;, or &#x60;cup&#x60;. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteFavoriteFood"></a>
# **deleteFavoriteFood**
> deleteFavoriteFood(foodId)

Delete Favorite Food

Deletes a food with the given ID to the user&#39;s list of favorite foods.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val foodId : kotlin.String = foodId_example // kotlin.String | The ID of the food to be deleted from user's favorites.
try {
    apiInstance.deleteFavoriteFood(foodId)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#deleteFavoriteFood")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#deleteFavoriteFood")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **foodId** | **kotlin.String**| The ID of the food to be deleted from user&#39;s favorites. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteFoods"></a>
# **deleteFoods**
> deleteFoods(foodId)

Delete Custom Food

Deletes custom food for a user and returns a response in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val foodId : kotlin.String = foodId_example // kotlin.String | The ID of the food to be deleted.
try {
    apiInstance.deleteFoods(foodId)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#deleteFoods")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#deleteFoods")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **foodId** | **kotlin.String**| The ID of the food to be deleted. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteFoodsLog"></a>
# **deleteFoodsLog**
> deleteFoodsLog(foodLogId)

Delete Food Log

Deletes a user&#39;s food log entry with the given ID.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val foodLogId : kotlin.String = foodLogId_example // kotlin.String | The ID of the food log entry to be deleted.
try {
    apiInstance.deleteFoodsLog(foodLogId)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#deleteFoodsLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#deleteFoodsLog")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **foodLogId** | **kotlin.String**| The ID of the food log entry to be deleted. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="deleteWaterLog"></a>
# **deleteWaterLog**
> deleteWaterLog(waterLogId)

Delete Water Log

Deletes a user&#39;s water log entry with the given ID.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val waterLogId : kotlin.String = waterLogId_example // kotlin.String | The ID of the waterUnit log entry to be deleted.
try {
    apiInstance.deleteWaterLog(waterLogId)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#deleteWaterLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#deleteWaterLog")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **waterLogId** | **kotlin.String**| The ID of the waterUnit log entry to be deleted. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="editFoodsLog"></a>
# **editFoodsLog**
> editFoodsLog(foodLogId, mealTypeId, unitId, amount, calories)

Edit Food Log

The Edit Food Log endpoint changes the quantity or calories consumed for a user&#39;s food log entry with the given Food Log ID.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val foodLogId : kotlin.String = foodLogId_example // kotlin.String | The ID of the food log entry to be edited.
val mealTypeId : kotlin.String = mealTypeId_example // kotlin.String | Meal types. 1=Breakfast; 2=Morning Snack; 3=Lunch; 4=Afternoon Snack; 5=Dinner; 7=Anytime.
val unitId : kotlin.String = unitId_example // kotlin.String | The ID of units used. Typically retrieved via a previous call to Get Food Logs, Search Foods, or Get Food Units.
val amount : kotlin.String = amount_example // kotlin.String | The amount consumed in the format X.XX in the specified unitId.
val calories : kotlin.Int = 56 // kotlin.Int | Calories for this serving size. This is allowed with foodName parameter (default to zero); otherwise it is ignored.
try {
    apiInstance.editFoodsLog(foodLogId, mealTypeId, unitId, amount, calories)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#editFoodsLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#editFoodsLog")
    e.printStackTrace()
}
```

### Parameters
| **foodLogId** | **kotlin.String**| The ID of the food log entry to be edited. | |
| **mealTypeId** | **kotlin.String**| Meal types. 1&#x3D;Breakfast; 2&#x3D;Morning Snack; 3&#x3D;Lunch; 4&#x3D;Afternoon Snack; 5&#x3D;Dinner; 7&#x3D;Anytime. | |
| **unitId** | **kotlin.String**| The ID of units used. Typically retrieved via a previous call to Get Food Logs, Search Foods, or Get Food Units. | |
| **amount** | **kotlin.String**| The amount consumed in the format X.XX in the specified unitId. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **calories** | **kotlin.Int**| Calories for this serving size. This is allowed with foodName parameter (default to zero); otherwise it is ignored. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getFavoriteFoods"></a>
# **getFavoriteFoods**
> getFavoriteFoods()

Get Favorite Foods

Returns a list of a user&#39;s favorite foods in the format requested. A favorite food in the list provides a quick way to log the food via the Log Food endpoint.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
try {
    apiInstance.getFavoriteFoods()
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getFavoriteFoods")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getFavoriteFoods")
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

<a id="getFoodsByDate"></a>
# **getFoodsByDate**
> getFoodsByDate(date)

Get Food Logs

Retreives a summary and list of a user&#39;s food log entries for a given day in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date of records to be returned. In the format yyyy-MM-dd.
try {
    apiInstance.getFoodsByDate(date)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getFoodsByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getFoodsByDate")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| The date of records to be returned. In the format yyyy-MM-dd. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getFoodsGoal"></a>
# **getFoodsGoal**
> getFoodsGoal()

Get Food Goals

Returns a user&#39;s current daily calorie consumption goal and/or foodPlan value in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
try {
    apiInstance.getFoodsGoal()
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getFoodsGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getFoodsGoal")
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

<a id="getFoodsInfo"></a>
# **getFoodsInfo**
> getFoodsInfo(foodId)

Get Food

Returns the details of a specific food in the Fitbit food databases or a private food that an authorized user has entered in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val foodId : kotlin.String = foodId_example // kotlin.String | The ID of the food.
try {
    apiInstance.getFoodsInfo(foodId)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getFoodsInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getFoodsInfo")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **foodId** | **kotlin.String**| The ID of the food. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getFoodsList"></a>
# **getFoodsList**
> getFoodsList(query)

Search Foods

Returns a list of public foods from the Fitbit food database and private food the user created in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val query : kotlin.String = query_example // kotlin.String | The URL-encoded search query.
try {
    apiInstance.getFoodsList(query)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getFoodsList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getFoodsList")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **query** | **kotlin.String**| The URL-encoded search query. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getFoodsLocales"></a>
# **getFoodsLocales**
> getFoodsLocales()

Get Food Locales

Returns the food locales that the user may choose to search, log, and create food in.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
try {
    apiInstance.getFoodsLocales()
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getFoodsLocales")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getFoodsLocales")
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

<a id="getFoodsUnits"></a>
# **getFoodsUnits**
> getFoodsUnits()

Get Food Units

Returns a list of all valid Fitbit food units in the format requested.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
try {
    apiInstance.getFoodsUnits()
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getFoodsUnits")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getFoodsUnits")
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

<a id="getFrequentFoods"></a>
# **getFrequentFoods**
> getFrequentFoods()

Get Frequent Foods

Returns a list of a user&#39;s frequent foods in the format requested. A frequent food in the list provides a quick way to log the food via the Log Food endpoint.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
try {
    apiInstance.getFrequentFoods()
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getFrequentFoods")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getFrequentFoods")
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

<a id="getMeals"></a>
# **getMeals**
> getMeals()

Get Meals

Returns a list of meals created by user in the user&#39;s food log in the format requested. User creates and manages meals on the Food Log tab on the website.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
try {
    apiInstance.getMeals()
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getMeals")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getMeals")
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

<a id="getRecentFoods"></a>
# **getRecentFoods**
> getRecentFoods()

Get Recent Foods

Returns a list of a user&#39;s frequent foods in the format requested. A frequent food in the list provides a quick way to log the food via the Log Food endpoint.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
try {
    apiInstance.getRecentFoods()
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getRecentFoods")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getRecentFoods")
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

<a id="getWaterByDate"></a>
# **getWaterByDate**
> getWaterByDate(date)

Get Water Logs

Retreives a summary and list of a user&#39;s water log entries for a given day in the requested using units in the unit system that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | The date of records to be returned. In the format yyyy-MM-dd.
try {
    apiInstance.getWaterByDate(date)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getWaterByDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getWaterByDate")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| The date of records to be returned. In the format yyyy-MM-dd. | |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="getWaterGoal"></a>
# **getWaterGoal**
> getWaterGoal()

Get Water Goal

Retreives a summary and list of a user&#39;s water goal entries for a given day in the requested using units in the unit system that corresponds to the Accept-Language header provided.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
try {
    apiInstance.getWaterGoal()
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#getWaterGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#getWaterGoal")
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

<a id="updateWaterLog"></a>
# **updateWaterLog**
> updateWaterLog(waterLogId, amount, unit)

Update Water Log

Updates a user&#39;s water log entry with the given ID.

### Example
```kotlin
// Import classes:
//import com.fediim.fitmetrics.api.infrastructure.*
//import com.fediim.fitmetrics.api.models.*

val apiInstance = NutritionApi()
val waterLogId : kotlin.String = waterLogId_example // kotlin.String | The ID of the waterUnit log entry to be deleted.
val amount : kotlin.String = amount_example // kotlin.String | Amount consumed; in the format X.X and in the specified waterUnit or in the unit system that corresponds to the Accept-Language header provided.
val unit : kotlin.String = unit_example // kotlin.String | Water measurement unit. 'ml', 'fl oz', or 'cup'.
try {
    apiInstance.updateWaterLog(waterLogId, amount, unit)
} catch (e: ClientException) {
    println("4xx response calling NutritionApi#updateWaterLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutritionApi#updateWaterLog")
    e.printStackTrace()
}
```

### Parameters
| **waterLogId** | **kotlin.String**| The ID of the waterUnit log entry to be deleted. | |
| **amount** | **kotlin.String**| Amount consumed; in the format X.X and in the specified waterUnit or in the unit system that corresponds to the Accept-Language header provided. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **unit** | **kotlin.String**| Water measurement unit. &#39;ml&#39;, &#39;fl oz&#39;, or &#39;cup&#39;. | [optional] |

### Return type

null (empty response body)

### Authorization


Configure oauth2:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

