package io.github.nanodesy.mywondefullideasbot.command.handler.idea;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdeaService {

  private final IdeaRepository ideaRepository;
  private final IdeaMapper ideaMapper;

  public Idea create(String text, String username) {
    IdeaEntity ideaEntity = IdeaEntity
        .builder()
        .text(text)
        .username(username)
        .build();
    return ideaMapper.mapToIdea(ideaRepository.save(ideaEntity));
  }

  public List<Idea> getAllByUsername(String username) {
    return ideaRepository.findByUsername(username).stream()
        .map(ideaMapper::mapToIdea)
        .collect(Collectors.toList());
  }
}
