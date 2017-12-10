package com.study.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *客户信息
 * @author 马欢欢
 * @date 2017/12/8
 */
public class Customer {
    private Integer c_id;
    private String c_name;
    private String c_source;
    private String c_phone;
    private Set<Salesperson> salespersonSet = new HashSet<Salesperson>();

    public Set<Salesperson> getSalespersonSet() {
        return salespersonSet;
    }

    public void setSalespersonSet(Set<Salesperson> salespersonSet) {
        this.salespersonSet = salespersonSet;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_source() {
        return c_source;
    }

    public void setC_source(String c_source) {
        this.c_source = c_source;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }
}
