package com.example.demo.services;

import com.example.demo.exceptions.ModuleException;
@org.springframework.stereotype.Service
public class ServiceB implements IServiceB {

    public String processService(Boolean mode) throws ModuleException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("Start B....");
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
}
