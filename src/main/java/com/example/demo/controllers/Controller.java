package com.example.demo.controllers;

import com.example.demo.exceptions.ModuleException;
import com.example.demo.messaging.CompletableFutureResponseWrapper;
import com.example.demo.messaging.JsonResponse;
import com.example.demo.services.IServiceA;
import com.example.demo.services.IServiceB;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class Controller {
    @Autowired()
    IServiceA serviceA;

    @Autowired()
    IServiceB serviceB;

    @GetMapping(value="test", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JsonResponse>>  test(@RequestParam String modeA, @RequestParam String modeB) throws ModuleException, InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        MDC.put("trace", "123");
        CompletableFuture<CompletableFutureResponseWrapper> t1 = serviceA.process(Boolean.valueOf(modeA));
        CompletableFuture<CompletableFutureResponseWrapper> t2 = serviceB.process(Boolean.valueOf(modeB));
        // Wait until they are all done
        CompletableFuture.allOf(t1, t2).join();
        // Print results, including elapsed time
        System.out.println("Elapsed total time: " + (System.currentTimeMillis() - start));
        // Create response
        JsonResponse resT1 = new JsonResponse("ProcessA", t1.get().isSuccess(), t1.get().getResponse().toString());
        JsonResponse resT2 = new JsonResponse("ProcessB", t2.get().isSuccess(), t2.get().getResponse().toString());
        List<JsonResponse> response = Arrays.asList(resT1, resT2);
        // Check if there was any error
        if (!t1.get().isSuccess() || !t2.get().isSuccess()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

        return ResponseEntity.ok().body(response);
    }



}
