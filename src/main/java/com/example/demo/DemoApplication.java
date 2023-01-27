package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		try{
		Web3App.app();
		SpringApplication.run(DemoApplication.class, args);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
