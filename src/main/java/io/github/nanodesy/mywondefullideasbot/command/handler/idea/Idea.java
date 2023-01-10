package io.github.nanodesy.mywondefullideasbot.command.handler.idea;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Idea {

  private Long id;
  private String text;
  private String username;
}
