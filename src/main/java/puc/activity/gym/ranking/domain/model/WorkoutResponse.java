package puc.activity.gym.ranking.domain.model;

import java.time.Duration;

public class WorkoutResponse {
    private Long workoutId;
    private String userId;
    private Duration duration;

    
    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}