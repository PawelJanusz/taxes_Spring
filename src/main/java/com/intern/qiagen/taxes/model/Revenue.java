package com.intern.qiagen.taxes.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double grossRevenue;
    private final Double ZUS = 1380.18;

    public Revenue(Long id, Double grossRevenue) {
        this.id = id;
        this.grossRevenue = grossRevenue;
    }

    public Revenue(Double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public Revenue() {
    }

    public void cleanUp(){

    }

    public Double getGrossRevenue() {
        return grossRevenue;
    }

    public Double getZUS() {
        return ZUS;
    }

    public Double getPIT() {
        return 0.19 * getGrossRevenue();
    }

    public Double getNetRevenue() {
        return getGrossRevenue() - getZUS() - getPIT();
    }

    public Long getId() {
        return id;
    }

    public void setGrossRevenue(Double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenue revenue = (Revenue) o;
        return Objects.equals(id, revenue.id) &&
                Objects.equals(grossRevenue, revenue.grossRevenue) && Objects.equals(ZUS, revenue.ZUS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grossRevenue, ZUS);
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "id=" + id +
                ", grossRevenue=" + grossRevenue +
                ", ZUS=" + ZUS +
                '}';
    }
}
