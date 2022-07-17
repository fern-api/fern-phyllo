package com.sample.app;

import com.fern.java.auth.BasicAuthHeader;
import com.phyllo.client.connect.ConnectServiceClient;
import com.phyllo.types.connect.AllAccountsResponse;
import com.phyllo.types.connect.AllWorkPlatformsResponse;
import com.phyllo.types.connect.WorkPlatform;
import java.util.Optional;
import java.util.stream.Collectors;

public class SampleApp {

    public static void main(String... args) {
        ConnectServiceClient connectServiceClient =
                ConnectServiceClient.getClient("https://api.sandbox.getphyllo.com");

        BasicAuthHeader basicAuthHeader =
                BasicAuthHeader.of("4dab2366-20b1-4d2f-86e1-d47749f33c23",
                        "51ac7485-b366-4bfd-8fd2-963e6a58fdb3");

        AllWorkPlatformsResponse allWorkPlatforms = connectServiceClient.getAllWorkPlatforms(basicAuthHeader,
                Optional.empty(),
                Optional.empty(),
                Optional.empty());
        System.out.printf("Received %d work platforms!\n", allWorkPlatforms.data().size());

        String commaDelimitedWorkPlatformNames = allWorkPlatforms.data().stream()
                .map(WorkPlatform::name)
                .collect(Collectors.joining(", "));
        System.out.println("The names are: " + commaDelimitedWorkPlatformNames);

        AllAccountsResponse allAccountsResponse = connectServiceClient.getAllAccounts(
                basicAuthHeader,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty());
        allAccountsResponse.data();
    }
}
