# awaitility-example
An example, how to use awaitility.
This repository contains the code for an article published on [Medium](https://medium.com/@davidgroemling/why-is-testing-with-thread-sleep-a-bad-idea-and-what-can-you-do-instead-3aad1d26a787).
The code showcases how using awaitility can lead to significant speed and stability gains when testing asynchronous code.

If you find this helpful, consider subscribing to get more :)

## How to run?
There are two test cases in [AsynchronousOperationTest](https://github.com/gromlin2/awaitility-example/blob/main/src/test/java/com/github/gromlin2/awaitilityexample/AsynchronousOperationTest.java).
You can simply run them using gradle and check out the test-report:
```bash
./gradlew build test
open build/reports/tests/test/classes/com.github.gromlin2.awaitilityexample.AsynchronousOperationTest.html
```

Alternatively, you can load the project into and IDE and run the test from there.

## What to expect?
The two test-cases are testing the same code. However, one is using `Thread.sleep`, the other one is using `awaitility`.
The test using `awaitility` runs significantly faster and is less brittle.git