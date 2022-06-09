package com.yjxk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件任务
 */
public class EventItem implements Serializable {
    private Integer id;//主键
    private String code;//事件编码
    private String name;//事件名称
    private String operator;//操作人
    private String remark;//事件说明
    private Date createDate;//创建时间
    private String reportDept;// 报告科室
    private String reporter;//报告人
    private String reportPhone;//联系方式

    public String getReportDept() {
        return reportDept;
    }

    public void setReportDept(String reportDept) {
        this.reportDept = reportDept;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReportPhone() {
        return reportPhone;
    }

    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


}
