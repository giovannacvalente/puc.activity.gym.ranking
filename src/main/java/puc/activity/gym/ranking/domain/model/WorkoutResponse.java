package puc.activity.gym.ranking.domain.model;

import java.time.Duration;

public class WorkoutResponse {
    private Long workoutId;
    private Long userId;
    private Duration duration;

    
    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}