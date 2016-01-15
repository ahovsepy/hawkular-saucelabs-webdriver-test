[![Build Status](https://travis-ci.org/Hawkular-QE/hawkular-ui-test.svg)](https://travis-ci.org/Hawkular-QE/hawkular-ui-test)
# hawkular-ui-test

saucelabs + selenium webdriver test framework for hawkular gui testing

to build project: 
```
mvn clean install -DskipTests
```
to run tests: 
```
// the default value for HawkularUrl is localhost:8080, sauceUsername default value is hawkularqe
mvn test -DhawkularUrl="http://IP:Port" -DauthenticationKey="SAUCELABS_AUTH_KEY" -DsauceUsername="SAUCELABS_USERNAME" 

// Run with specific TestNG suite
mvn test -DhawkularUrl="http://IP:Port" -Dtestng.suite="<suiteName.xml>" 

```
to test Red Hat Access use -Drhausername="username" -Drhapassword="password"
```
to create an Eclipse project that can be directly imported into Eclipse
mvn eclipse:eclipse
```
