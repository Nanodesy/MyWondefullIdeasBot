package io.github.nanodesy.mywondefullideasbot.command.handler.idea;

import io.github.nanodesy.mywondefullideasbot.command.handler.CommandHandler;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class IdeaListCommandHandler implements CommandHandler {

  private static final String COMMAND_NAME = "/ideas";

  private final IdeaService ideaService;

  @Override
  public void handle(Message request, SendMessage response) {
    if (!request.hasText() || !request.getText().equals(COMMAND_NAME)) {
      return;
    }

    response.setChatId(request.getChatId().toString());

    String username = request.getFrom().getUserName();
    List<Idea> ideas = ideaService.getAllByUsername(username);
    response.setText(messagePreparer(ideas));
  }

  private String messagePreparer(List<Idea> ideas) {
    StringBuilder sb = new StringBuilder();
    IntStream.range(0, ideas.size()).forEach(index -> sb
        .append(String.format("%d. %s%n", index + 1, ideas.get(index).getText())));
    return sb.toString();
  }
}
