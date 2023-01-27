package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.util.codec.binary.Base64;

public class Request {

    private int id;
    private Long timestamp;
    private String from;
    private String to;
    private double amount;
    private String key;
    private String signature;

    public Request(@JsonProperty("uid") int id,
            @JsonProperty("timestamp") Long timestamp,
            @JsonProperty("from") String from,
            @JsonProperty("to") String to,
            @JsonProperty("amount") double amount,
            @JsonProperty("key") String key,
            @JsonProperty("signature") String signature){
        this.id = id;
        this.timestamp = timestamp;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.key = key;
        this.signature = signature;

    }

    public int getId(){
        return id;
    };
    public Long getTimestamp(){
        return timestamp;
    };
    public String getFrom(){
        return from;
    };
    public String getTo(){
        return to;
    };
    public double getAmount(){
        return amount;
    };
    public String getKey(){
        return key;
    };
    public String getSignature(){
        return signature;
    };


}
