package com.example.demo.services;

import com.example.demo.exceptions.ModuleException;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.concurrent.Executor;

@org.springframework.stereotype.Service
public class ServiceB implements IServiceB {

    @Autowired
    private Executor executor;

    public String processService(Boolean mode) throws ModuleException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("Start B.... " + MDC.get("trace") + " " + Thread.currentThread().getName());
        try{
            if(mode){
                Thread.sleep(8000L);
                return "Successfully processB";
            }else{
                throw new ModuleException("Error process B at CException" );
            }
        }finally {
            System.out.println("Elapsed time processB: " + (System.currentTimeMillis() - start));
        }

    }

    @Override
    public Executor getExecutor() {
        return executor;
    }



}
