package com.example.demo;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class Web3App {

    private static final String nodeUrl = System.getenv().getOrDefault("WEB3J_NODE_URL", "https://sepolia.infura.io/v3/<key>");
    private static final String privateKey = System.getenv().getOrDefault("WEB3J_PRIVATE_KEY", "privateKey");
    private static final String walletAddress = System.getenv().getOrDefault("WEB3J_WALLET_ADDRESS", "privatewallet");

    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(21000L);
    private static final BigInteger GAS_PRICE = BigInteger.valueOf(10000000L);

    private static SimpleTransfer simpleTransfer;

    public Web3App(){
    }


    public static void app() throws Exception {

        Web3j web3 = Web3j.build(new HttpService(nodeUrl));
        System.out.println("Deploying HelloWorld contract ...");


        Credentials credentials = Credentials.create(privateKey);

        simpleTransfer = SimpleTransfer.load(walletAddress, web3, credentials, GAS_LIMIT, GAS_PRICE);

        simpleTransfer.deposit(walletAddress,BigInteger.valueOf(1000)).send();

    }

    public static void transferFunds(String from, String to, double amount) throws Exception {
        try {
            int amountInt = (int)(amount);
            simpleTransfer.transfer(from, to, BigInteger.valueOf(amountInt)).send();
        } catch (Exception e){
            throw e;
        }
    }

}


