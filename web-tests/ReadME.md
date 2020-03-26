## Web test Details

#### Details

```text
   Website under test: http://automationpractice.com/index.php
   Tool: Selenium Webdriver
   Language: JAVA
   Reporting: Allure
   CI/CD: Local Jenkins
   Test Runner: TestNG
```
    
#### Setup: 
 
 * Create a new account on http://automationpractice.com/index.php
   * Save your credentials in environment variables. Test will pick them up.
    
        ```bash
            export DEMO_UNAME="<your-email-id-here>"
            export DEMO_PWD="<your-password-here>"
        ``` 
    
#### How to execute

 * We will use maven commands to trigger our tests. All the Tests will run on Chrome & Firefox in parallel.
 Also no need to configure driver, framework will detect your browser version and download compatible driver to run
  tests
 
    ```bash
    cd web-tests
    mvn clean test 
    ```

#### Open Reports

 * Allure reporting artefacts are generated in target/allure-results. One can open allure HTML report with following
  command
  
    ```bash
    allure serve target/allure-results  
    ```
 * Sample local run is attached as `web-browser-tests.png`

#### CI/CD

 * For CI/CD, I'm using local jenkins setup and using mvn as a trigger command to run.
 One can find the screenshot of jenkins run in this project
 
 * Sample local run is attached as `local-jenkins-result.png`


#### TestFlow
 
 * Here we have two e2e tests which are automated
    ```text
    1. Sign-inTest: This tests tries to login with provided credentials and checks if log-in was successful or not  
    ``` 
   
    ```text
    2. Checkout: This tests does complete e2e till checkout. It searches for the product in three different
    categories/ways, add them and then in the end remove one from the cart. It then proceeds for the checkout.
    ``` 
