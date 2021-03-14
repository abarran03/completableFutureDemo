package com.example.demo.services;

import com.example.demo.exceptions.ModuleException;


@org.springframework.stereotype.Service
public class ServiceA implements IServiceA{

    public String processService(Boolean mode) throws ModuleException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("Start A...");
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

}
