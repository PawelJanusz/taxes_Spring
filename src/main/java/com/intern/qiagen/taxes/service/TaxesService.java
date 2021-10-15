package com.intern.qiagen.taxes.service;

import com.intern.qiagen.taxes.model.Revenue;
import com.intern.qiagen.taxes.repository.TaxesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxesService {

    private final TaxesRepo taxesRepo;

    @Autowired
    public TaxesService(TaxesRepo taxesRepo) {
        this.taxesRepo = taxesRepo;
    }

    public List<Revenue> getItems(){
        if (taxesRepo.findAll().size() <= 5) {
            return taxesRepo.findAll().stream()
                    .limit(5)
                    .collect(Collectors.toList());
        }
        else
            return taxesRepo.findAll()
                    .subList(taxesRepo.findAll().size() - 5, taxesRepo.findAll().size());
    }

    public List<Revenue> getAllItems(){
        return taxesRepo.findAll();
    }

    public Revenue addItem(Revenue revenue){
        return taxesRepo.save(revenue);
    }
}
