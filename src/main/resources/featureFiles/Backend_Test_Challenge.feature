Feature: Verify All User Operations

  Scenario: Search for the user
    Given search for the username "Samantha" with url "/users" for "username" queryParam
    When I verify response with status code 200
    Then I verify in response "Samantha" with jpath "username"

  Scenario: Use the details fetched to make a search for the posts written by the user
    Given search for the username "Samantha" with url "/users" for "username" queryParam
    When I verify response with status code 200
    Then I verify in response "Samantha" with jpath "username"
    Then I verify in response "3" with jpath "id"
    And search for the username "3" with url "/posts" for "userId" queryParam
    When I verify response with status code 200

  Scenario: For each post, fetch the comments and validate if the emails in the comment section are in the proper format
    Given search for the username "Samantha" with url "/users" for "username" queryParam
    When I verify response with status code 200
    Then I verify in response "Samantha" with jpath "username"
    Then I verify in response "3" with jpath "id"
    And search for the username "3" with url "/posts" for "userId" queryParam
    When I verify response with status code 200
    Then I verify in response "30" with jpath "id"
    Given search for the username "" with url "/comments" for "postId" queryParams
    When I verify response with status code 200
    Then I verify in response "Cassidy@maribel.io" with jpath "email"
    Then I verify the email format with regular exp "^(.+)@(.+)$"

  Scenario: Search for the post by postId
    Given I perform get with url "/posts" for /22 pathParams with jsonfile path noBodyNeeded
    When I verify response with status code 200

  Scenario: Verify the post method for posts
    Given I perform post with url "/posts" for 22 pathParams with jsonfile path src/main/resources/requestJSON/sampleRequest.json
    When I verify response with status code 201

  Scenario: Verify the put method for posts
    Given I perform put with url "/posts" for /22 pathParams with jsonfile path src/main/resources/requestJSON/sampleRequest.json
    When I verify response with status code 200

  Scenario: Verify the patch method for posts
    Given I perform patch with url "/posts" for /22 pathParams with jsonfile path src/main/resources/requestJSON/samplePatchRequest.json
    When I verify response with status code 200

  Scenario: Verify the delete method for posts
    Given I perform delete with url "/posts" for /22 pathParams with jsonfile path noBodyNeeded
    When I verify response with status code 200