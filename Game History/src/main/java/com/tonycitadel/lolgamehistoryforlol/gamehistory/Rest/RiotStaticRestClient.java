package com.tonycitadel.lolgamehistoryforlol.gamehistory.Rest;

import com.squareup.okhttp.OkHttpClient;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Riot Static Client
 */
public class RiotStaticRestClient {
    private static final String BASE_URL = "https://global.api.pvp.net";
    private StaticDataService staticDataService;

    public RiotStaticRestClient() {
        OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        staticDataService = retrofit.create(StaticDataService.class);
    }

    public StaticDataService getStaticDataService() {
        return staticDataService;
    }

}
