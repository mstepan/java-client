package com.max;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.concurrent.TimeUnit;

public class Main {

    private Main() throws Exception {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:5555/usage/maksym")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

    public static void main(String[] args) {
        try {
            new Main();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
