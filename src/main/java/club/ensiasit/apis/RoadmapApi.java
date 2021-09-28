package club.ensiasit.apis;

import club.ensiasit.constants.ApiConstants;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

public sealed interface RoadmapApi permits RoadmapApi.RoadmapClient, RoadmapApi.RoadmapController {

  String PATH = ApiConstants.API_V1_PREFIX + "/roadmap";

  @Get
  String getRoadmapRawData();

  @Client(PATH)
  non-sealed interface RoadmapClient extends RoadmapApi {
  }

  @Controller(PATH)
  final class RoadmapController implements RoadmapApi {

    @Override
    public String getRoadmapRawData() {
      return "{}";
    }

  }

}
