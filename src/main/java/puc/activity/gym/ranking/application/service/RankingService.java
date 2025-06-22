package puc.activity.gym.ranking.application.service;

import org.springframework.stereotype.Service;
import puc.activity.gym.ranking.domain.model.WorkoutResponse;
import puc.activity.gym.ranking.infrastructure.client.WorkoutClient;
import puc.activity.gym.ranking.infrastructure.factory.RankingStrategyFactory;
import puc.activity.gym.ranking.strategy.RankingStrategy;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class RankingService {
    private final WorkoutClient workoutClient;
    private final RankingStrategyFactory strategyFactory;

    public RankingService(WorkoutClient workoutClient, RankingStrategyFactory strategyFactory) {
        this.workoutClient = workoutClient;
        this.strategyFactory = strategyFactory;
    }

    public Map<String, Long> getRanking(String type) {
        List<WorkoutResponse> workouts = workoutClient.getWorkouts();
        RankingStrategy strategy = strategyFactory.getStrategy(type);
        Map<String, Long> rawRanking = strategy.generateRanking(workouts);

        
        return rawRanking.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(LinkedHashMap::new,
                        (m, e) -> m.put(e.getKey(), e.getValue()),
                        LinkedHashMap::putAll);
    }
}