package io.github.nanodesy.mywondefullideasbot.command.handler.idea;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    builder = @Builder(disableBuilder = true))
public interface IdeaMapper {

  IdeaEntity mapToIdeaEntity(Idea idea);

  Idea mapToIdea(IdeaEntity ideaEntity);
}
