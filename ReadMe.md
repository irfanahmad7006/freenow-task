restassured-automation-freenow-task
=================
Automated API test for REST API using Java, RestAssured, Maven with Cucumber etc.

This test automation project is created for an open API. The tests are implemented user rest-assured.
I have used the BDD approach for this project.

Framework Architecture
--------------
	Project-Name		
		|
		|_src/main/java/com/typicode/jsonplaceholder	
		|	|_qaUtils
		|	|   |_ConfigFileReader.java
		|	|   |_Utils.java
		|	|_runner
		|	|   
		|	|_stepDefinitions
		|	|   |_UserDefinedStepsDefinition.java
		|
		|_src/main/resources
		|	|_featureFiles
		|	|   |_Backend_Test_Challenge.feature
		|	|
		|	|_requestJSON	
		|	|	|_samplePatchRequest.json 
        |   |	|_sampleRequest.json
		|	|
		|	|_config.properties
		|	|_extent.properties
		|	|_log4j2.properties
		|
		|_target/reports
			|_cucumber.html
			|_Spark.html


* **src/main/resources/featureFiles** - all the cucumber features files (files .feature ext) goes here.
* **src/main/java/com/typicode/jsonplacehoder/stepsDefinitions** - you can define step defintion under this package for your feature steps.
* **src/main/resources/config.properties** - When you want to manage configuration for your API for example: like change in Base URI, Base path or authorization key or token. These could be managed from config.properties file.
* **src/main/resources/extent.properties** - When you want to manage extent report configuration.
* **src/main/resources/log4j2.properties** - When you want to manage logging configuration.

Writing a test
--------------
* The cucumber features goes in the `featuresFiles` library and should have the ".feature" extension.
* You can start out by looking at `featuresFiles/Backen_Test_Challenge.feature`. You can extend this feature or make your own features using some of the predefined steps that come with cucumber.
* You can use the existing step for new scenarios.

Execution from CMD
-----------------
* git clone https://github.com/irfanahmad7006/swagger-petstore.git
* cd freenow-task
* Run `mvn clean test` in cmd prompt for execution.

Execution from IDE
-----------------  
* You can start execution from `featuresFiles/Backend_Test_Challenge.feature` directly for single feature execution.
* You can start execution from `src/test/java/runner/RunnerTest.java` for all feature files execution in one go.
* You can run `mvn test` Or `mvn clean test` in cmd for execution from the terminal.

Reporting
----------------- 
* You can view the test execution report from `testReport/cucumber.html`
* You can view detailed test execution report from `testReport/Spark.html`
* You can also view the cucumber cloud report (only available for 24 hours) from the console, after every execution. This can be managed from cucumber options.


Set-Up prerequisites.
-----------------
* Java version - jdk 1.8.0_281,
* Maven version - apache maven 3.8.1,
* maven-surefire-plugin - 3.0.0-M1 (If not provided by IDE on compile time)
* Git
* IntelliJ/Eclipse Cucumber plugins

Maven Dependencies.
-----------------
* cucumber-java
* cucumber-testNG
* testNG
* rest-assured
* extentreports
* extentreports-cucumber6-adapter
* logj42
* json-simple