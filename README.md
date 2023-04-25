# value-class-serialization
A sample project to reproduce a bug regarding value class serialization.

## Running the tests

```shell
$ ./gradlew test

> Task :test FAILED

me.fth.vcs.FooListWrapperSerializationTest > should deserialize a JSON array of objects to a value class wrapper FAILED
    java.lang.IllegalAccessError at FooListWrapperSerializationTest.kt:10

me.fth.vcs.FooListWrapperSerializationTest > should serialize a JSON array of objects from a value class wrapper FAILED
    java.lang.IllegalAccessError at FooListWrapperSerializationTest.kt:10

me.fth.vcs.StringListWrapperSerializationTest > should serialize a JSON array of strings from a value class wrapper FAILED
    java.lang.IllegalAccessError at StringListWrapperSerializationTest.kt:10

me.fth.vcs.StringListWrapperSerializationTest > should deserialize a JSON array of strings to a value class wrapper FAILED
    java.lang.IllegalAccessError at StringListWrapperSerializationTest.kt:10

14 tests completed, 4 failed

FAILURE: Build failed with an exception.
```

## Observations

It appears the error occurs when the value class encapsulate a collection of a know type instead of a generic one.

```kotlin
@JvmInline
@Serializable
value class StringListWrapper(val items: List<String>)
```
Using this value class for serialization will fail as opposed to the next one:

```kotlin
@JvmInline
@Serializable
value class ListWrapper<T>(val items: List<T>)
```

The error does not show up when the encapsulated value is not a collection which means both of these value classes would work as expected:

```kotlin
@JvmInline
@Serializable
value class StringWrapper(val item: String)

@JvmInline
@Serializable
value class Wrapper<T>(val item: T)
```
