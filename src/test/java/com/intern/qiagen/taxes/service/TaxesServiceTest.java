package com.intern.qiagen.taxes.service;

import com.intern.qiagen.taxes.model.Revenue;
import com.intern.qiagen.taxes.repository.TaxesRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TaxesServiceTest {

    @TestConfiguration
    static class TaxesServiceImplTestContextConfiguration{
        @Bean
        public TaxesService taxesService(){
            return new TaxesService();
        }
    }

    @Autowired
    private TaxesService taxesService;

    @MockBean
    private TaxesRepo taxesRepo;

    @Test
    void shouldAddRevenue(){
        //given
        Revenue revenue = new Revenue(1L, 87000.5);
        //when
        taxesService.addItem(revenue);
        //then
        Mockito.verify(taxesRepo).save(any(Revenue.class));
    }


    @Test
    void shouldFindById(){
        //given
        Revenue revenue = new Revenue(1L, 65000.8);
        when(taxesRepo.findById(1L)).thenReturn(Optional.of(revenue));
        //when
        Optional<Revenue> returnedRevenue = taxesRepo.findById(1L);
        //then
        assertEquals(Optional.of(revenue), returnedRevenue);
    }


}
