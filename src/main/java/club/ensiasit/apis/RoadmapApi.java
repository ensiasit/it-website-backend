package club.ensiasit.apis;

import club.ensiasit.constants.ApiConstants;
import club.ensiasit.services.RoadmapService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

public sealed interface RoadmapApi permits RoadmapApi.RoadmapClient, RoadmapApi.RoadmapController {

  String PATH = ApiConstants.API_V1_PREFIX + "/roadmap";

  @Get
  HttpResponse<String> getRoadmapRawData();

  @Client(PATH)
  non-sealed interface RoadmapClient extends RoadmapApi {
  }

  @Controller(PATH)
  final class RoadmapController implements RoadmapApi {

    private final RoadmapService roadmapService;

    public RoadmapController(RoadmapService roadmapService) {
      this.roadmapService = roadmapService;
    }

    @Override
    public HttpResponse<String> getRoadmapRawData() {
      return roadmapService
        .getRoadmapRawData()
        .map(HttpResponse::ok)
        .orElse(HttpResponse.serverError("Could not fetch roadmap raw data"));
    }

  }

}
