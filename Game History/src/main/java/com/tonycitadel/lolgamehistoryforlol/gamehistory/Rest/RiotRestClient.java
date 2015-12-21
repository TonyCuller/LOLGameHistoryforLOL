package com.tonycitadel.lolgamehistoryforlol.gamehistory.Rest;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import java.io.IOException;

/**
 * Riot Rest Client
 */
public class RiotRestClient {
    private static final String BASE_URL = "https://na.api.pvp.net";
    private RecentGamesService recentGamesService;

    public RiotRestClient() {
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed((chain.request()));
                return response;
            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recentGamesService = retrofit.create(RecentGamesService.class);
    }

    public RecentGamesService getRecentGamesService() {
        return recentGamesService;
    }

}
