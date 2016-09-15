
Sets up a bare minimum maven project to run cucumber.

```bash
mvn clean package
java -cp target/cucumber-tutorial-1.0.0-SNAPSHOT.jar \
    cucumber.api.cli.Main \
    .
```

Note the use of shade plugin in the pom.xml

This is required otherwise `cucumber.api.cli.Main` is not found in the `target/cucumber-tutorial-1.0.0-SNAPSHOT.jar` file.
