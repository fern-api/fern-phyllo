# Phyllo Clients

This repository contains:

- [Fern API Definition](/api/src/connect/connect.yml) of the Phyllo Connect API
- [Sample app](./sample-java-app/src/main/java/com/sample/app/SampleApp.java) consuming [generated Java SDK](./sample-java-app/build.gradle#L13)

> The Fern team wrote the definition based on your docs.

## Java Sample App

The core logic lives in [SampleApp.java](./sample-java-app/src/main/java/com/sample/app/SampleApp.java).

> Fern provides the user with an easy way to instantiate a client

```java
ConnectServiceClient client = ConnectServiceClient
  .getClient("https://api.sandbox.getphyllo.com")
```

> and type safety when invoking different endpoints.

```java
WorkPlatform workPlatform = client.getWorkPlatform(
  basicAuthHeader, workPlatformId);
```

**Run the sample app by:**

- opening [./sample-java-app](./sample-java-app/) in Intellij
- hitting play on main

The output you will see after hitting play is:

```
####### fetching work platform by id #######
Received work platform with name Reddit and url https://www.reddit.com

####### fetching account by id #######
Received account for Arvind!
Account status is CONNECTED!
```
