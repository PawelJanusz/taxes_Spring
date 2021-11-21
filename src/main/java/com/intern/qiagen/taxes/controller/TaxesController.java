package com.intern.qiagen.taxes.controller;

import com.intern.qiagen.taxes.service.TaxesService;
import com.intern.qiagen.taxes.model.Revenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/taxes")
@RestController
public class TaxesController {

    private final TaxesService taxesService;

    @Autowired
    public TaxesController(TaxesService taxesService) {
        this.taxesService = taxesService;
    }

    @GetMapping("/get5Items")
    public List<Revenue> get5LastItems(){
           return taxesService.getItems();
    }

    @GetMapping("/getAllItems")
    public List<Revenue> getAllItems(){
           return taxesService.getAllItems();
    }

    @PostMapping("/addItems")
    public Revenue addRevenueItem(@RequestBody Revenue revenue){
        if (revenue.getNetRevenue() < 10000){
            throw new IllegalArgumentException("Gross revenue should be greater than 10 tys.");
        }
           return taxesService.addItem(revenue);
    }
}
