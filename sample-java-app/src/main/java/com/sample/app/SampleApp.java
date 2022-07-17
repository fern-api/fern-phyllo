package com.sample.app;

import com.fern.java.auth.BasicAuthHeader;
import com.phyllo.client.connect.ConnectServiceClient;
import com.phyllo.types.connect.Account;
import com.phyllo.types.connect.AccountId;
import com.phyllo.types.connect.WorkPlatform;
import com.phyllo.types.connect.WorkPlatformId;

public class SampleApp {

    public static void main(String... args) {
        ConnectServiceClient connectServiceClient =
                ConnectServiceClient.getClient("https://api.sandbox.getphyllo.com");

        BasicAuthHeader basicAuthHeader =
                BasicAuthHeader.of("4dab2366-20b1-4d2f-86e1-d47749f33c23",
                        "51ac7485-b366-4bfd-8fd2-963e6a58fdb3");

        exampleGetWorkPlatform(connectServiceClient, basicAuthHeader);
        exampleGetUser(connectServiceClient, basicAuthHeader);
    }

    private static void exampleGetWorkPlatform(
            ConnectServiceClient connectServiceClient, BasicAuthHeader basicAuthHeader) {
        System.out.println("####### fetching work platform by id #######");
        WorkPlatform workPlatform = connectServiceClient.getWorkPlatform(
                basicAuthHeader, WorkPlatformId.valueOf("dfe5c762-10b2-44fd-b3f2-2c6387690da8"));
        System.out.println(
                "Received work platform with name " + workPlatform.name() + " and url " + workPlatform.url());
        System.out.println();
    }

    private static void exampleGetUser(
            ConnectServiceClient connectServiceClient, BasicAuthHeader basicAuthHeader) {
        System.out.println("####### fetching account by id #######");
        Account account = connectServiceClient.getAccount(
                basicAuthHeader, AccountId.valueOf("db49910f-9311-4ede-94a2-f16d3043152f"));
        System.out.println(
                "Received account for " + account.user().name() + "!");
        System.out.println(
                "Account status is " + account.status() + "!");
        System.out.println();
    }
}
