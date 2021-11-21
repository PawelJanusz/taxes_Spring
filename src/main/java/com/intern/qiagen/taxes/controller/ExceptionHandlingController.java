package com.intern.qiagen.taxes.controller;

import com.intern.qiagen.taxes.model.Revenue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/handling")
public class ExceptionHandlingController {

        @PostMapping()
        public Revenue addItem(@RequestBody Revenue revenue){
            if (revenue.getGrossRevenue() < 10000){
                throw new IllegalArgumentException("Gross revenue should be greater than 10 tys.");
            }
            return revenue;
        }
}
