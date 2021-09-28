package club.ensiasit.services;

import jakarta.inject.Singleton;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.Optional;

@Singleton
public class RoadmapService {

  public Optional<String> getRoadmapRawData() {
    try {
      return Optional.of(new String(GitHub
        .connectAnonymously()
        .getRepository("ensiasit/assets")
        .getFileContent("cp-roadmap/roadmap.json")
        .read()
        .readAllBytes()));
    } catch (IOException e) {
      return Optional.empty();
    }
  }

}
