package io.github.nanodesy.mywondefullideasbot.command.handler.idea;

import io.github.nanodesy.mywondefullideasbot.command.handler.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class IdeaSaverCommandHandler implements CommandHandler {

  private final IdeaService ideaService;

  @Override
  public void handle(Message request, SendMessage response) {
    if (!request.hasText() || !request.getText().startsWith("Idea:")) {
      return;
    }

    response.setChatId(request.getChatId().toString());
    ideaService.create(request.getText(), request.getFrom().getUserName());
    response.setText("Got your idea!");
  }
}
