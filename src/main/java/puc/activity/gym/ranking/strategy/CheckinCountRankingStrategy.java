package puc.activity.gym.ranking.strategy;

import org.springframework.stereotype.Component;
import puc.activity.gym.ranking.domain.model.WorkoutResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("checkins")
public class CheckinCountRankingStrategy implements RankingStrategy {
    @Override
    public Map<String, Long> generateRanking(List<WorkoutResponse> workouts) {
        return workouts.stream()
                .collect(Collectors.groupingBy(
                        WorkoutResponse::getUsername,
                        Collectors.counting()
                ));
    }
}