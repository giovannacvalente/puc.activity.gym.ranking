package puc.activity.gym.ranking.infrastructure.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import puc.activity.gym.ranking.domain.model.WorkoutResponse;

import java.util.Arrays;
import java.util.List;

@Component
public class WorkoutClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${checkin.api.base-url}")
    private String baseUrl;

    public List<WorkoutResponse> getWorkouts() {
        String url = baseUrl + "/workout/list";
        WorkoutResponse[] response = restTemplate.getForObject(url, WorkoutResponse[].class);
        return Arrays.asList(response);
    }
}