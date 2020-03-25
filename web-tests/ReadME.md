## Api test Details

#### Details

```text
   Website under test: http://automationpractice.com/index.php
   Tool: Selenium Webdriver with TestNG 
   Language: JAVA
   Reporting: Allure
   CI/CD: Local Jenkins
```
    
#### Setup: 
 
 * Create a new account on http://automationpractice.com/index.php
   * Save your credentials in environment variables. Test will pick them up.
    
        ```bash
            export DEMO_UNAME="<your-email-id-here>"
            export DEMO_PWD="<your-password-here>"
        ``` 
    
#### How to execute

 * We will use maven commands to trigger our tests. We are also using TestNG group to run certain set of tests.
 As of now, we have only two groups in our tests
 
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
