## backend-test-suite

### ABOUT:

> - This service provides kafka endpoints to fetch customer address from Bisnode, as of now returns from counterparty database if not it returns Sweden static address.
> - RBAC/ABAC is implemented to authorize the request.

### CONTENTS:
> - [Clone Reposiroty](https://github.com/sureshullagaddi/backend-test)
  
---  

### Clone Repository
> ```  
> https://github.com/sureshullagaddi/backend-test
> ```

### Build and Run Application

./gradlew test -Denv=dev

### Unit Test Results

> Build task will execute tests and publish the results to [***/build/reports/tests/test/index.html***]


### Jacoco Test Results

./gradlew test -Denv=dev
> - Results can be viewed [ ***/build/reports/jacoco/jacocoHtml/index.html***]

