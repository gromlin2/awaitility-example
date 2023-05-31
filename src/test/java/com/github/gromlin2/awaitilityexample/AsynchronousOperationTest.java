package com.github.gromlin2.awaitilityexample;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AsynchronousOperationTest {

  @ParameterizedTest(name = "OperationDelay: {0}ms")
  @ValueSource(longs = {50, 60, 40, 200})
  void runAsynchronousOperationWithSleep(long delay) {
    final var asyncOperation = new AsynchronousOperation(Duration.ofMillis(delay));

    assertFalse(asyncOperation.isStarted());
    assertFalse(asyncOperation.isCompleted());

    asyncOperation.run();
    assertTrue(asyncOperation.isStarted());
    assertFalse(asyncOperation.isCompleted());

    await("completion of task")
        .atMost(Duration.ofMillis(250))
        .pollInterval(Duration.ofMillis(20))
        .until(asyncOperation::isCompleted);
  }

  @ParameterizedTest(name = "OperationDelay: {0}ms")
  @ValueSource(longs = {50, 60, 40, 200})
  void runAsynchronousOperationWithAwaitility(long delay) throws InterruptedException {
    final var asyncOperation = new AsynchronousOperation(Duration.ofMillis(delay));

    assertFalse(asyncOperation.isStarted());
    assertFalse(asyncOperation.isCompleted());

    asyncOperation.run();
    assertTrue(asyncOperation.isStarted());
    assertFalse(asyncOperation.isCompleted());

    Thread.sleep(250);

    assertTrue(asyncOperation.isCompleted());
  }
}
