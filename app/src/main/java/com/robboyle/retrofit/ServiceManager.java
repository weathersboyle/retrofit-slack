package com.robboyle.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by robboyle on 6/17/15.
 */
public class ServiceManager {

    public static final String SLACK_ENDPOINT = "https://hooks.slack.com";

    private static final Gson GSON = new GsonBuilder().create();

    private static RestAdapter serviceAdapter = new RestAdapter.Builder()
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setEndpoint(SLACK_ENDPOINT)
            .setConverter(new GsonConverter(GSON))
            .build();
    private static SlackService slackServiceInstance;

    public static SlackService getSlackServiceInstance() {
        if (slackServiceInstance == null) {
            slackServiceInstance = serviceAdapter.create(SlackService.class);
        }
        return slackServiceInstance;
    }

}
