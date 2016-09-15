
Sets up a bare minimum maven project to run cucumber.

```bash
mvn clean package
java -cp target/cucumber-tutorial-1.0.0-SNAPSHOT.jar \
    cucumber.api.cli.Main \
    . \
    --glue com.prismoskills
```

Note the use of shade plugin in the pom.xml

This is required otherwise `cucumber.api.cli.Main` is not found in the `target/cucumber-tutorial-1.0.0-SNAPSHOT.jar` file.


Also not the use of `--glue com.prismoskills`

If you specify `--help` in the above command-line, the description for `--glue` says:
```
Options:

  -g, --glue PATH          Where glue code (step definitions, hooks
                           and plugins) are loaded from.
```

Unfortunately it does not tell how to specify that path.
It is only by searching the Internet that you come to know that the path has
to be your package-name where step-definitions are contained.

But if that is true, then why specify just `com.prismoskills`? Why not just `com`?

It turns out that `com` works just as fine as `com.prismoskills`


Another bad part about this whole things is the error message works hard but not smart if you forget something.

Example: Leave the --glue option. It will print:
```
java -cp target/cucumber-tutorial-1.0.0-SNAPSHOT.jar cucumber.api.cli.Main . 
# UUU
# 
# 1 Scenarios (1 undefined)
# 3 Steps (3 undefined)
# 0m0.000s
# 
# 
# You can implement missing steps with the snippets below:
# ...
# And then all the Java methods that you can copy-paste
# ...
# 
```

But it would have been very nice to see a line printed about `--glue` too in the error message.

