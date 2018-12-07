package com.migueldussan.scratch.springbootdb.repository;

import com.migueldussan.scratch.springbootdb.persistence.entity.Payee;
import org.springframework.data.repository.CrudRepository;

public interface PayeeRepository extends CrudRepository<Payee, Integer> {
}
