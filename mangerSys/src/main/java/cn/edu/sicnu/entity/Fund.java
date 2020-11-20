package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Fund)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:31
 */
public class Fund implements Serializable {
    private static final long serialVersionUID = 909604887412868448L;

    private String id;

    private Double requestFund;

    private Double arrivalFund;

    private Date requestDate;

    private Date arrivalDate;

    public Fund() {
    }

    public Fund(String id, Double requestFund, Double arrivalFund, Date requestDate, Date arrivalDate) {
        this.id = id;
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
                ", requestFund=" + requestFund +
                ", arrivalFund=" + arrivalFund +
                ", requestDate=" + requestDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}