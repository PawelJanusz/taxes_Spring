package com.intern.qiagen.taxes.repository;

import com.intern.qiagen.taxes.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxesRepo extends JpaRepository<Revenue, Long> {

    @Override
    Optional<Revenue> findById(Long id);

    @Override
    void deleteById(Long id);
}
