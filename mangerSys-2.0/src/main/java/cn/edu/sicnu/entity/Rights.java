package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Rights)实体类
 *
 * @author makejava
 * @since 2020-11-23 20:19:18
 */
public class Rights implements Serializable {
    private static final long serialVersionUID = -54950538603591291L;

    private String id;

    private String name;

    private Integer abscissa;

    private Integer ordinate;

    private String note;

    private String urlPath;

    public Rights() {
    }

    public Rights(String id, String name, Integer abscissa, Integer ordinate, String note, String urlPath) {
        this.id = id;
        this.name = name;
        this.abscissa = abscissa;
        this.ordinate = ordinate;
        this.note = note;
        this.urlPath = urlPath;
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

    public Integer getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(Integer abscissa) {
        this.abscissa = abscissa;
    }

    public Integer getOrdinate() {
        return ordinate;
    }

    public void setOrdinate(Integer ordinate) {
        this.ordinate = ordinate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    @Override
    public String toString() {
        return "Rights{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", abscissa=" + abscissa +
                ", ordinate=" + ordinate +
                ", note='" + note + '\'' +
                ", urlPath='" + urlPath + '\'' +
                '}';
    }
}