package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (AchievementMagazine)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:26
 */
public class AchievementMagazine implements Serializable {
    private static final long serialVersionUID = -18119150795434729L;

    private String achievementId;

    private String magazineId;

    public AchievementMagazine() {
    }

    public AchievementMagazine(String achievementId, String magazineId) {
        this.achievementId = achievementId;
        this.magazineId = magazineId;
    }

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public String getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(String magazineId) {
        this.magazineId = magazineId;
    }


    @Override
    public String toString() {
        return "AchievementMagazine{" +
                "achievementId='" + achievementId + '\'' +
                ", magazineId='" + magazineId + '\'' +
                '}';
    }
}