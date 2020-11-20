package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Rights)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:31
 */
public class Rights implements Serializable {
    private static final long serialVersionUID = 429899327233676964L;

    private String id;

    private String name;

    private Integer sort;

    private Integer rightIndex;

    private Object isFather;

    private String urlAddress;

    private String note;

    public Rights() {
    }

    public Rights(String id, String name, Integer sort, Integer rightIndex, Object isFather, String urlAddress, String note) {
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.rightIndex = rightIndex;
        this.isFather = isFather;
        this.urlAddress = urlAddress;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(Integer rightIndex) {
        this.rightIndex = rightIndex;
    }

    public Object getIsFather() {
        return isFather;
    }

    public void setIsFather(Object isFather) {
        this.isFather = isFather;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Rights{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", rightIndex=" + rightIndex +
                ", isFather=" + isFather +
                ", urlAddress='" + urlAddress + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}