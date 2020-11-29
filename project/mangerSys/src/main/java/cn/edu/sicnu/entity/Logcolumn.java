package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Logcolumn)实体类
 *
 * @author makejava
 * @since 2020-11-28 20:45:10
 */
public class Logcolumn implements Serializable {
    private static final long serialVersionUID = -43232244756735456L;

    private Integer id;

    private Integer logtableId;

    private String logcolumn;

    public Logcolumn() {
    }

    public Logcolumn(Integer id, Integer logtableId, String logcolumn) {
        this.id = id;
        this.logtableId = logtableId;
        this.logcolumn = logcolumn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogtableId() {
        return logtableId;
    }

    public void setLogtableId(Integer logtableId) {
        this.logtableId = logtableId;
    }

    public String getLogcolumn() {
        return logcolumn;
    }

    public void setLogcolumn(String logcolumn) {
        this.logcolumn = logcolumn;
    }

    @Override
    public String toString() {
        return "Logcolumn{" +
                "id=" + id +
                ", logtableId=" + logtableId +
                ", logcolumn='" + logcolumn + '\'' +
                '}';
    }
}