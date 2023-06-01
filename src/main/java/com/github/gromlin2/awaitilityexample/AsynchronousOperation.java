package com.github.gromlin2.awaitilityexample;

import static java.util.Objects.requireNonNull;

import java.time.Duration;
import java.time.Instant;

/**
 * Simple class simulating an asynchronous operation by marking it as completed after a
 * pre-specified time has passed.
 */
public final class AsynchronousOperation {

  private final Duration duration;

  private Instant started = null;
  private Instant completesAt = null;

  /**
   * Create a new operation, running for the specified duration.
   *
   * @param duration Run duration of the operation
   */
  public AsynchronousOperation(Duration duration) {
    requireNonNull(duration);
    this.duration = duration;
  }

  /** Starts the operation. */
  public void run() {
    started = Instant.now();
    completesAt = started.plus(duration);
  }

  /**
   * Indicates, whether the operation was started or not.
   *
   * @return True if started, false otherwise
   */
  public boolean isStarted() {
    return started != null;
  }

  /**
   * Indicates whether the operation has completed. Completion is indicated by the operation being
   * started (see {@link #isStarted()}) and a specified duration having passed.
   *
   * @return Whether the operation is completed
   */
  public boolean isCompleted() {
    if (!isStarted()) {
      return false;
    }

    return Instant.now().isAfter(completesAt);
  }
}
