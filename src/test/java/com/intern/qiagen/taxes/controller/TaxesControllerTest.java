package com.intern.qiagen.taxes.controller;

import com.intern.qiagen.taxes.model.Revenue;
import com.intern.qiagen.taxes.service.TaxesService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxesControllerTest {

    @Test
    void methodShouldBeThrowsException(){
        //given
        Revenue revenue = new Revenue(450.4);
        TaxesService service = new TaxesService();
        TaxesController controller = new TaxesController(service);
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> controller.addRevenueItem(revenue));
    }

}
