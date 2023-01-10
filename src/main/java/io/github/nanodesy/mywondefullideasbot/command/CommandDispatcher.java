package io.github.nanodesy.mywondefullideasbot.command;

import io.github.nanodesy.mywondefullideasbot.command.handler.CommandHandler;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Service
public class CommandDispatcher extends TelegramLongPollingBot {

  private final List<CommandHandler> commandHandlers;
  private final String botName;
  private final String botToken;

  public CommandDispatcher(
      List<CommandHandler> commandHandlers,
      @Value("${bot.name}") String botName,
      @Value("${bot.token}") String botToken,
      TelegramBotsApi telegramBotsApi) throws TelegramApiException {
    this.commandHandlers = commandHandlers;
    this.botName = botName;
    this.botToken = botToken;
    telegramBotsApi.registerBot(this);
  }

  @Override
  public String getBotUsername() {
    return botName;
  }

  @Override
  public String getBotToken() {
    return botToken;
  }

  @Override
  public void onUpdateReceived(Update update) {
    Message request = update.getMessage();
    SendMessage response = new SendMessage();

    commandHandlers.forEach(commandHandler -> commandHandler.handle(request, response));
    log.info("Received message from @{}", request.getFrom().getUserName());

    try {
      execute(response);
    } catch (TelegramApiException e) {
      throw new DispatchException("Cannot dispatch message", e);
    }
  }
}
