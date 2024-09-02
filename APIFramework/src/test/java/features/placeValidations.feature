Feature: Validating Place API's

Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<address>" "<language>"
	When user calls "AddPlaceAPI" with "POST" Http request
	Then the API call gopt success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	Examples:
		| name | adddress | language |
		| aaaa | addddddd | langgggg |
		| bbbb | cdcjhjhk | guaaaaaa |