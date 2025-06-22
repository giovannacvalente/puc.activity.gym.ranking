package puc.activity.gym.ranking.strategy;

import puc.activity.gym.ranking.domain.model.WorkoutResponse;

import java.util.List;
import java.util.Map;

public interface RankingStrategy {
    Map<String, Long> generateRanking(List<WorkoutResponse> workouts);
}