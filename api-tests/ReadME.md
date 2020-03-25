## Api test Details

#### Details

```text
   REST API's under test: https://uebermaps.com/
   Tool: RestAssured with TestNG 
   Language: JAVA
   Reporting: Allure
```
    
#### Setup: 
 
 * Create a new account on https://uebermaps.com/.
   * Add environment variable for your credentials. Test will pick them up.
   ```bash
    export MAPS_UNAME="<your-email-id-here>"
    export MAPS_PWD="<your-password-here>"
   ```
   
#### Endpoints:
 * Here we are only dealing with endpoints of Map (https://uebermaps.com/api/v2#resource_Maps) & Comments (https://uebermaps.com/api/v2#resource_Comments)
 * Map is entity which a user can create and Save & share your favorite places with friends, family, community or the
  whole world. Comments are added by people on the certain maps.
 * Here we only working with certain endpoints 
    
#### How to execute

 * We will use maven commands to trigger our tests. We are also using TestNG group to run certain set of tests.
 As of now, we have only two groups in our tests
 
    ```bash
    cd api-tests
    mvn clean test -Dgroups=validToken,invalidToken 
    ```

#### Open Reports

 * Allure reporting artefacts are generated in target/allure-results. One can open allure HTML report with following
  command
  
    ```bash
    allure serve target/allure-results  
    ```
