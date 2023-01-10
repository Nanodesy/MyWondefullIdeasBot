package io.github.nanodesy.mywondefullideasbot.command.handler.idea;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends JpaRepository<IdeaEntity, Long> {

  List<IdeaEntity> findByUsername(String username);

}
