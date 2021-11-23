package com.intern.qiagen.taxes.model;

import com.intern.qiagen.taxes.controller.TaxesController;
import com.intern.qiagen.taxes.service.TaxesService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RevenueTest {

    @Test
    void shouldBeReturnProperPitValue(){
        //given
        Revenue revenue = new Revenue(650.5);
        double expectedPit = revenue.getGrossRevenue() * 0.19;
        //when
        double pitToCount = revenue.getPIT();
        //then
        assertEquals(expectedPit, pitToCount);
    }

    @Test
    void shouldBeReturnProperNetRevenue(){
        //given
        Revenue revenue = new Revenue(2000.2);
        double expectedNetRevenue = revenue.getGrossRevenue() - revenue.getZUS() - revenue.getPIT();
        //when
        double netRevenueToCount = revenue.getNetRevenue();
        //then
        assertEquals(expectedNetRevenue, netRevenueToCount);
    }

    @Test
    void twoObjectsShouldBeTheSame(){
        //given
        Revenue revenue1 = new Revenue(1L, 430.4);
        Revenue revenue2 = new Revenue(1L, 430.4);
        //when
        //then
        assertEquals(revenue1, revenue2);
    }

}
