package cn.edu.sicnu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Fund)实体类
 *
 * @author makejava
 * @since 2020-11-27 10:05:14
 */
public class Fund implements Serializable {
    private static final long serialVersionUID = 907254572405223003L;

    private String id;

    private String projectId;

    private Double requestFund;

    private Double arrivalFund;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date requestDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;

    public Fund() {
    }

    public Fund(String id, String projectId, Double requestFund, Double arrivalFund, Date requestDate, Date arrivalDate) {
        this.id = id;
        this.projectId = projectId;
        this.requestFund = requestFund;
        this.arrivalFund = arrivalFund;
        this.requestDate = requestDate;
        this.arrivalDate = arrivalDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Double getRequestFund() {
        return requestFund;
    }

    public void setRequestFund(Double requestFund) {
        this.requestFund = requestFund;
    }

    public Double getArrivalFund() {
        return arrivalFund;
    }

    public void setArrivalFund(Double arrivalFund) {
        this.arrivalFund = arrivalFund;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "id='" + id + '\'' +
                ", projectId='" + projectId + '\'' +
                ", requestFund=" + requestFund +
                ", arrivalFund=" + arrivalFund +
                ", requestDate=" + requestDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}