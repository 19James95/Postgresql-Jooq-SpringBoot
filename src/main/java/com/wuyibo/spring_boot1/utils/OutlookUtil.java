package com.wuyibo.spring_boot1.utils;


import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.UsernamePasswordCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.requests.GraphServiceClient;
import okhttp3.Request;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.security.AuthProvider;
import java.util.Arrays;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;


public class OutlookUtil {

    final static String clientId = "c41eb25c-ba0c-473a-9c25-191d83c21777";
    final static String tenantId = "common"; // or "common" for multi-tenant apps
    //        final String tenantId = "consumers";
    final static String clientSecret = "ELl8Q~THTc1RoOW3AMzG~5g12r1L5TT5SDFHcajW";
    final static List<String> scopes = Arrays.asList("https://graph.microsoft.com/.default");
    public static GraphServiceClient<Request> getClient(){

        UsernamePasswordCredentialsProvider()
        TokenCredentialAuthProvider authProvider = new TokenCredentialAuthProvider(
                new ClientSecretCredentialBuilder().clientId(clientId).clientSecret(clientSecret).tenantId(tenantId).build()
        );

        GraphServiceClient<Request> graphClient = GraphServiceClient
                        .builder()
                        .authenticationProvider(authProvider)
                        .buildClient();
        return graphClient;

    }

    public static void getEmail() throws IOException {
        String tokenUrl = String.format("https://login.microsoftonline.com/%s/oauth2/v2.0/token", tenantId);

        // 构建请求体
        String requestBody = "grant_type=client_credentials" +
                "&client_id=" + URLEncoder.encode(clientId, "UTF-8") +
                "&client_secret=" + URLEncoder.encode(clientSecret, "UTF-8") +
                "&scope=https://graph.microsoft.com/.default";

        // 发起获取访问令牌的请求
        String accessToken = requestAccessToken(tokenUrl, requestBody);

        // 发起带有访问令牌的请求
        String apiUrl = "https://graph.microsoft.com/v1.0/me/messages";
        String responseData = makeGetRequest(apiUrl, accessToken);

        // 处理响应
        System.out.println("Response: " + responseData);
    }

    private static String requestAccessToken(String tokenUrl, String requestBody) throws IOException {
        // 发起获取访问令牌的请求
        URL url = new URL(tokenUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        connection.getOutputStream().write(requestBody.getBytes("UTF-8"));

        // 读取响应内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        // 解析 JSON 响应获取访问令牌
        String accessToken = parseAccessToken(response.toString());
        System.out.println("Access Token: " + accessToken);

        return accessToken;
    }

    private static String makeGetRequest(String apiUrl, String accessToken) throws IOException {
        // 发起带有访问令牌的 GET 请求
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + accessToken);

        // 读取响应内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }

    private static String parseAccessToken(String jsonResponse) {
        // 简单的 JSON 解析，实际项目中应使用 JSON 库进行更安全和可靠的解析
        String[] parts = jsonResponse.split("\"");
        return parts[3];
    }
}
