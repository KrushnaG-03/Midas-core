package com.midas.core.repository;

import com.midas.core.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // That's it!
    // By extending JpaRepository, we inherit methods like:
    // .save(), .findById(), .findAll(), .delete()
    // automatically.
}