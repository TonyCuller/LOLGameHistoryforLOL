package com.tonycitadel.lolgamehistoryforlol.gamehistory.Rest;

import com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO.Model;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Recent Games Service
 */


public interface RecentGamesService {
    @GET("/api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    Call<Model> listRecentGames(@Path("region") String region, @Path("summonerId") String summonerId, @Query("api_key") String apiKey);

}


