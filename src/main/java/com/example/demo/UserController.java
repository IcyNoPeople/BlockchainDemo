package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;

@RestController
@RequestMapping("/send")
public class UserController {

    @GetMapping
    public String sendNothing() {
        return "Please ignore";
    }

    @PostMapping
    public String sendTransfer(@RequestBody Request request) {
        try {
            System.out.println(request.getFrom());
            Web3App.transferFunds(request.getFrom(), request.getTo(), request.getAmount());
            return "ID: " + request.getId() + " Transactions has been completed.";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "error";
    }
}
