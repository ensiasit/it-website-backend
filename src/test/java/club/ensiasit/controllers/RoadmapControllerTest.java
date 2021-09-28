package club.ensiasit.controllers;

import club.ensiasit.apis.RoadmapApi;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class RoadmapControllerTest {

  final RoadmapApi.RoadmapClient client;

  RoadmapControllerTest(RoadmapApi.RoadmapClient client) {
    this.client = client;
  }

  @Test
  void getRoadmapRawData() {
    String roadmapRawData = client.getRoadmapRawData();

    Assertions.assertEquals("{}", roadmapRawData);
  }

}