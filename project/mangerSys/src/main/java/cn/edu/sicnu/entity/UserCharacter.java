package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (UserCharacter)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:42
 */
public class UserCharacter implements Serializable {
    private static final long serialVersionUID = 721274005462920123L;

    private String characterId;

    private String userId;

    private String note;

    public UserCharacter() {
    }

    public UserCharacter(String characterId, String userId, String note) {
        this.characterId = characterId;
        this.userId = userId;
        this.note = note;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "UserCharacter{" +
                "characterId='" + characterId + '\'' +
                ", userId='" + userId + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}