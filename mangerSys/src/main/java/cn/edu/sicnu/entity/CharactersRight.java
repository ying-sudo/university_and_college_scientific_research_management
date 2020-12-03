package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (CharactersRight)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:24
 */
public class CharactersRight implements Serializable {
    private static final long serialVersionUID = -49859880867536103L;

    private String characterId;

    private String rightId;

    private String note;

    public CharactersRight() {
    }

    public CharactersRight(String characterId, String rightId, String note) {
        this.characterId = characterId;
        this.rightId = rightId;
        this.note = note;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "CharactersRight{" +
                "characterId='" + characterId + '\'' +
                ", rightId='" + rightId + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}