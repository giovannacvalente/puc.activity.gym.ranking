package puc.activity.gym.ranking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import puc.activity.gym.ranking.application.service.RankingService;
import puc.activity.gym.ranking.domain.model.RankingType;

import java.util.Map;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping
    public Map<Long, Long> getRanking(@RequestParam RankingType type) {
        return rankingService.getRanking(type.name().toLowerCase());
    }
}