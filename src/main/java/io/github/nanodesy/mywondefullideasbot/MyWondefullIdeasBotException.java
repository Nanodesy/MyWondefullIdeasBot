package io.github.nanodesy.mywondefullideasbot;

public class MyWondefullIdeasBotException extends RuntimeException{

  public MyWondefullIdeasBotException() {
    super();
  }

  public MyWondefullIdeasBotException(String message) {
    super(message);
  }

  public MyWondefullIdeasBotException(String message, Throwable cause) {
    super(message, cause);
  }

  public MyWondefullIdeasBotException(Throwable cause) {
    super(cause);
  }

  protected MyWondefullIdeasBotException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
