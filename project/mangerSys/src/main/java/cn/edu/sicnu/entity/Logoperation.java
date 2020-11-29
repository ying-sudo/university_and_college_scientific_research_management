package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Logoperation)实体类
 *
 * @author makejava
 * @since 2020-11-28 20:45:11
 */
public class Logoperation implements Serializable {
    private static final long serialVersionUID = -73954786688528966L;

    private Integer logtableId;

    private Integer logcolumnId;

    private String optionType;

    private String userId;

    public Logoperation() {
    }

    public Logoperation(Integer logtableId, Integer logcolumnId, String optionType, String userId) {
        this.logtableId = logtableId;
        this.logcolumnId = logcolumnId;
        this.optionType = optionType;
        this.userId = userId;
    }

    public Integer getLogtableId() {
        return logtableId;
    }

    public void setLogtableId(Integer logtableId) {
        this.logtableId = logtableId;
    }

    public Integer getLogcolumnId() {
        return logcolumnId;
    }

    public void setLogcolumnId(Integer logcolumnId) {
        this.logcolumnId = logcolumnId;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Logoperation{" +
                "logtableId=" + logtableId +
                ", logcolumnId=" + logcolumnId +
                ", optionType='" + optionType + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}