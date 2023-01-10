package io.github.nanodesy.mywondefullideasbot.command.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandHandler {

  void handle(Message request, SendMessage response);
}
