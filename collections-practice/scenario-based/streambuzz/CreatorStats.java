package scenario.streambuzz;

import java.util.List;
import java.util.ArrayList;

public class CreatorStats {

    private String creatorName;
    private double[] weeklyLikes;

    public static List<CreatorStats> engagementBoard = new ArrayList<>();

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public double[] getWeeklyLikes() {
        return weeklyLikes;
    }

    public void setWeeklyLikes(double[] weeklyLikes) {
        this.weeklyLikes = weeklyLikes;
    }
}
