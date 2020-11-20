package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (ProjectAchievemUser)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:35
 */
public class ProjectAchievemUser implements Serializable {
    private static final long serialVersionUID = 224318938150816358L;

    private String id;

    private String userId;

    private Integer contribution;

    private Integer category;

    public ProjectAchievemUser() {
    }

    public ProjectAchievemUser(String id, String userId, Integer contribution, Integer category) {
        this.id = id;
        this.userId = userId;
        this.contribution = contribution;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getContribution() {
        return contribution;
    }

    public void setContribution(Integer contribution) {
        this.contribution = contribution;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProjectAchievemUser{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", contribution=" + contribution +
                ", category=" + category +
                '}';
    }
}