package com.intern.qiagen.taxes.repository;

import com.intern.qiagen.taxes.model.Revenue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TaxesRepoTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private TaxesRepo taxesRepo;

    @Test
    void repoShouldReturnEmptyList(){
        //given
        //when
        List<Revenue> list = taxesRepo.findAll();
        //then
        assertEquals(0, list.size());
    }

    @Test
    @Disabled
    void shouldDeleteItemByIdAndReturnEmptyList(){
        //given
        Revenue revenue = new Revenue(1L, 54000.2);
        //when
        taxesRepo.save(revenue);
        taxesRepo.deleteById(1L);
        List<Revenue> emptyList = taxesRepo.findAll();
        //then
        assertEquals(0, emptyList.size());
    }

    @Test
    void shouldReturnProperListSizeAfterAddingElement(){
        //given
        Revenue revenue = new Revenue(1L, 45000.5);
        //when

        taxesRepo.save(revenue);
        List<Revenue> addedRevenue = taxesRepo.findAll();
        //then
        assertEquals(1, addedRevenue.size());
    }
}
