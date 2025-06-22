package puc.activity.gym.ranking.infrastructure.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import puc.activity.gym.ranking.strategy.RankingStrategy;
import puc.activity.gym.ranking.domain.model.RankingType;

import java.util.Map;

@Component
public class RankingStrategyFactory {
    private final Map<String, RankingStrategy> strategies;

    @Autowired
    public RankingStrategyFactory(Map<String, RankingStrategy> strategies) {
        this.strategies = strategies;
    }

    public RankingStrategy getStrategy(String type) {
        RankingStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Ranking type not supported: " + type);
        }
        return strategy;
    }

    public RankingStrategy getStrategy(RankingType type) {
        return getStrategy(type.name().toLowerCase());
    }
}