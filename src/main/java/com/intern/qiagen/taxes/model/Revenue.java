package com.intern.qiagen.taxes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double grossRevenue;
    private Double ZUS = 1380.18;
    Double PIT;
    Double netRevenue;

    public Double getGrossRevenue() {
        return grossRevenue;
    }

    public Double getZUS() {
        return ZUS;
    }

    public Double getPIT() {
        return 0.19 * grossRevenue;
    }

    public Double getNetRevenue() {
        return grossRevenue - getZUS() - getPIT();
    }

    public Long getId() {
        return id;
    }

    public void setGrossRevenue(Double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public void setZUS(Double ZUS) {
        this.ZUS = ZUS;
    }

    public void setPIT(Double PIT) {
        this.PIT = PIT;
    }

    public void setNetRevenue(Double netRevenue) {
        this.netRevenue = netRevenue;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
