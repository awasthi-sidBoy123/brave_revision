Feature: Validating place Api's
@AddPlace @Regression
Scenario Outline: Verify if place is sucessfully added 

Given Add place payload with "<name>" "<language>" "<address>"
When user call "AddPlaceApi" with http "POST" request
Then Api call is sucess with status code 200
And "status" in response code is "OK"
And Verify place_id with the "<name>" added "GET" after hiting "getPlaceApi"


Examples:
|name | language | address|
|Hellos | Hindsi  | World Great Hindis|

@DeletePlace @Regression
Scenario: Verify if delete place functionality works

Given Delete place payload
When user call "deletePlaceApi" with http "POST" request
Then Api call is sucess with status code 200
And "status" in response code is "OK" 