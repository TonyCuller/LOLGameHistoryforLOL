package com.tonycitadel.lolgamehistoryforlol.gamehistory.Rest;

import com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO.Champion;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO.Item;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Riot Static Data interface
 */

public interface StaticDataService {
    @GET("/api/lol/static-data/{region}/v1.2/champion/{id}")
    Call<Champion> championData(@Path("region") String region, @Path("id") String id, @Query("api_key") String apikey);

    @GET("/api/lol/static-data/{region}/v1.2/item/{id}")
    Call<Item> itemData(@Path("region") String region, @Path("id") String id, @Query("api_key") String apikey);
}