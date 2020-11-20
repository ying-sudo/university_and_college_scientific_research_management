package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (EvaluationResult)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:30
 */
public class EvaluationResult implements Serializable {
    private static final long serialVersionUID = 100913768329192425L;

    private String id;

    private Integer score;

    private Date datename;

    private String sort;

    public EvaluationResult() {
    }

    public EvaluationResult(String id, Integer score, Date datename, String sort) {
        this.id = id;
        this.score = score;
        this.datename = datename;
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDatename() {
        return datename;
    }

    public void setDatename(Date datename) {
        this.datename = datename;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "EvaluationResult{" +
                "id='" + id + '\'' +
                ", score=" + score +
                ", datename=" + datename +
                ", sort='" + sort + '\'' +
                '}';
    }
}