package club.ensiasit.controllers;

import club.ensiasit.apis.RoadmapApi;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
class RoadmapControllerTest {

  final RoadmapApi.RoadmapClient client;

  RoadmapControllerTest(RoadmapApi.RoadmapClient client) {
    this.client = client;
  }

  @Test
  void getRoadmapRawData() {
    HttpResponse<String> httpResponse = client.getRoadmapRawData();

    assertThat(httpResponse.code()).isLessThan(400);
    assertThat(httpResponse.body()).hasSizeGreaterThanOrEqualTo(2);
  }

}