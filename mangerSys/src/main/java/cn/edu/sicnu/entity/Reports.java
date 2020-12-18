package cn.edu.sicnu.entity;

public class Reports {
    private String name;

    private String userName;

    private String collegeName;

    private Integer reportNumber;

    private Integer checkingNumber;

    private Integer checkedNumber;

    public Reports() {
    }

    public Reports(String name, String userName, String collegeName, Integer reportNumber, Integer checkingNumber, Integer checkedNumber) {
        this.name = name;
        this.userName = userName;
        this.collegeName = collegeName;
        this.reportNumber = reportNumber;
        this.checkingNumber = checkingNumber;
        this.checkedNumber = checkedNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Integer getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Integer reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Integer getCheckingNumber() {
        return checkingNumber;
    }

    public void setCheckingNumber(Integer checkingNumber) {
        this.checkingNumber = checkingNumber;
    }

    public Integer getCheckedNumber() {
        return checkedNumber;
    }

    public void setCheckedNumber(Integer checkedNumber) {
        this.checkedNumber = checkedNumber;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", reportNumber=" + reportNumber +
                ", checkingNumber=" + checkingNumber +
                ", checkedNumber=" + checkedNumber +
                '}';
    }
}
