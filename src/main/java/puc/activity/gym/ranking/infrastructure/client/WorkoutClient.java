package puc.activity.gym.ranking.infrastructure.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import puc.activity.gym.ranking.domain.model.WorkoutResponse;

import java.util.Arrays;
import java.util.List;

@Component
public class WorkoutClient {

    private final RestClient restClient;

    public WorkoutClient(@Qualifier("checkinRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public List<WorkoutResponse> getWorkouts() {
        WorkoutResponse[] arr = restClient.get()
                .uri("/workout/list")
                .retrieve()
                .body(WorkoutResponse[].class);
        return Arrays.asList(arr);
    }
}
