package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (TeamMember)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:34
 */
public class TeamMember implements Serializable {
    private static final long serialVersionUID = 471377657101607559L;

    private String teamId;

    private String userId;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String post;

    public TeamMember() {
    }

    public TeamMember(String teamId, String userId, String post) {
        this.teamId = teamId;
        this.userId = userId;
        this.post = post;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "teamId='" + teamId + '\'' +
                ", userId='" + userId + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}