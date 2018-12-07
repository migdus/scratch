package com.migueldussan.scratch.springbootdb.repository.runner;

import com.migueldussan.scratch.springbootdb.persistence.entity.Payee;
import com.migueldussan.scratch.springbootdb.repository.PayeeRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PayeeApplicationRunner implements ApplicationRunner {

    private PayeeRepository payeeRepository;

    public PayeeApplicationRunner(PayeeRepository payeeRepository) {
        this.payeeRepository = payeeRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        payeeRepository.save(new Payee("amazon"));
    }
}
