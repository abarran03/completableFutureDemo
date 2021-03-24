package com.example.demo.services;

import com.example.demo.exceptions.ModuleException;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.concurrent.Executor;


@org.springframework.stereotype.Service
public class ServiceA implements IServiceA{

    @Autowired
    private Executor executor;

    public String processService(Boolean mode) throws ModuleException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("Start A... " + MDC.get("trace") + " " + Thread.currentThread().getName());
        try {
            if (mode) {
                Thread.sleep(7000L);
                return "successfully processB";
            } else {
                throw new ModuleException("Error at process A at CException");
            }
        } finally {
            System.out.println("Elapsed time processA: " + (System.currentTimeMillis() - start));
        }
    }

    @Override
    public Executor getExecutor() {
        return this.executor;
    }

}
