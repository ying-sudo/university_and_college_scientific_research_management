package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Logtable)实体类
 *
 * @author makejava
 * @since 2020-11-28 20:45:12
 */
public class Logtable implements Serializable {
    private static final long serialVersionUID = 241380596803431891L;

    private Integer id;

    private String tableName;

    private String bussinessName;

    private Date createTime;

    public Logtable() {
    }

    public Logtable(Integer id, String tableName, String bussinessName, Date createTime) {
        this.id = id;
        this.tableName = tableName;
        this.bussinessName = bussinessName;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Logtable{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", bussinessName='" + bussinessName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}