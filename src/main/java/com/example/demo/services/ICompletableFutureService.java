package com.example.demo.services;

import com.example.demo.exceptions.ModuleException;
import com.example.demo.messaging.CompletableFutureResponseWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;

public interface ICompletableFutureService {

    String processService(Boolean mode) throws ModuleException, InterruptedException ;

    Executor getExecutor();

    default CompletableFuture<CompletableFutureResponseWrapper> process(Boolean mode) {
        return CompletableFuture.supplyAsync(()-> {
                    CompletableFutureResponseWrapper res = new CompletableFutureResponseWrapper();
                    try {
                        res.setSuccess(true);
                        res.setResponse(this.processService(mode));
                    } catch (CompletionException | ModuleException | InterruptedException e) {
                        res.setSuccess(false);
                        res.setResponse(e.getMessage());
                    }
                    return res;
                }
        , getExecutor());
    }
}
