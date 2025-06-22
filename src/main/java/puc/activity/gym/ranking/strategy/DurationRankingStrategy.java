package puc.activity.gym.ranking.strategy;

import org.springframework.stereotype.Component;
import puc.activity.gym.ranking.domain.model.WorkoutResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("duration")
public class DurationRankingStrategy implements RankingStrategy {
    @Override
    public Map<Long, Long> generateRanking(List<WorkoutResponse> workouts) {
        return workouts.stream()
                .filter(w -> w.getDuration() != null)
                .collect(Collectors.groupingBy(
                        WorkoutResponse::getUserId,
                        Collectors.summingLong(w -> w.getDuration().toMinutes())
                ));
    }
}