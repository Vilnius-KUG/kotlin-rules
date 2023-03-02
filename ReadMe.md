# Static Code Analysis Rules For Kotlin

An example of custom rules' implementation for the two most popular static code analysis tools for Kotlin: **Detekt** and **KtLint**. 

It demonstrates minimal required configuration for a custom rules' project, and comes with everything you need to build the rules and run them against the sample code. Including the **Detekt** and **KtLint** executables.

## Detekt

To build custom rules for **Detekt** execute the following commands:
1. `cd detekt-rules`
2. `./gradlew clean build`

Then run **Detekt** with custom rules enabled against the sample code:

`java -jar ../detekt.jar -i ../Sample.kt --plugins ../detekt-rules/build/libs/detekt-custom-1.0.jar --config ../detekt.yml`

**NOTICE** you need Java being referenced in your *path* variable.

# KtLint

To build custom rules for **KtLint** execute the following commands:
1. `cd ktlint-rules`
2. `./gradlew clean build`

Then run **KtLint** with custom rules enabled against the sample code:

`./../ktlint ../Sample.kt -R ../ktlint-rules/build/libs/ktlint-custom-1.0.jar`