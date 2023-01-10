package io.github.nanodesy.mywondefullideasbot.command.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class StartCommandHandler implements CommandHandler {

  private static final String COMMAND_NAME = "/start";

  @Override
  public void handle(Message request, SendMessage response) {
    if (!request.hasText() || !request.getText().equals(COMMAND_NAME)) {
      return;
    }

    response.setChatId(request.getChatId().toString());
    String username = request.getFrom().getFirstName();
    String message = String.format("Greetings %s, here you can write you ideas "
        + "and you can list them using /ideas command!\nStart new idea by typing: "
        + "Idea: My first Idea!", username);
    response.setText(message);
  }
}
