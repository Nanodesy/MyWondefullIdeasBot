package io.github.nanodesy.mywondefullideasbot.command;

import io.github.nanodesy.mywondefullideasbot.MyWondefullIdeasBotException;

public class DispatchException extends MyWondefullIdeasBotException {

  public DispatchException() {
    super();
  }

  public DispatchException(String message) {
    super(message);
  }

  public DispatchException(String message, Throwable cause) {
    super(message, cause);
  }

  public DispatchException(Throwable cause) {
    super(cause);
  }

  protected DispatchException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
