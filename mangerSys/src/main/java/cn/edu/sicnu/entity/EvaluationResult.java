package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (EvaluationResult)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:25
 */
public class EvaluationResult implements Serializable {
    private static final long serialVersionUID = 248487518009723332L;

    private String id;

    private Integer score;

    private String datename;

    private String sort;

    public EvaluationResult() {
    }

    public EvaluationResult(String id, Integer score, String datename, String sort) {
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

    public String getDatename() {
        return datename;
    }

    public void setDatename(String datename) {
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