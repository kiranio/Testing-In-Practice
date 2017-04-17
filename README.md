## Automated web tests for Angular App using Selenium, Serenity, Gherkin, Cucumber and Maven

A simple example of some BDD-style automated acceptance criteria, running against https://demos.scotch.io/angular-formly-car-rental/demos/. 

Run the tests like this:

```
mvn clean verify
```

By default, the tests run with PhantomJS, so you will need this installed. Otherwise, if you prefer Firefox, modify the serenity.properties file or run the tests like this:
```
s
```

The reports will be generated in `target/site/serenity`.

