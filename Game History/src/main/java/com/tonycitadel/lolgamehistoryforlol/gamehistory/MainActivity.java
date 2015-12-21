package com.tonycitadel.lolgamehistoryforlol.gamehistory;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO.Champion;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO.Game;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO.Model;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.Rest.ApiKey;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.Rest.RiotRestClient;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.Rest.RiotStaticRestClient;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Game> gameDataList = new ArrayList<>();
    private ListView listView;
    private GameListAdapter adapter;
    private String apiKey = ApiKey.getAPIKEY();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        adapter = new GameListAdapter(this, R.layout.list_row, gameDataList);
        listView.setAdapter(adapter);
        downloadData();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void downloadData() {
        RiotRestClient client = new RiotRestClient();
        client.getRecentGamesService().listRecentGames("na", "20806859", apiKey).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Response<Model> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    gameDataList.addAll(response.body().getGames());
                    Toast toast = Toast.makeText(getApplicationContext(), response.code() + " Success", Toast.LENGTH_SHORT);

                    toast.show();
                    for (int i = 0; i < gameDataList.size(); i++) {
                        champName(gameDataList.get(i).getChampionId(), i);
                    }

                    adapter.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Toast toast = Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT);
                toast.show();


            }
        });

    }

    public void champName(int id, final int position) {
        RiotStaticRestClient client = new RiotStaticRestClient();

        client.getStaticDataService().championData("na", String.valueOf(id), apiKey).enqueue(new Callback<Champion>() {
            @Override
            public void onResponse(Response<Champion> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    gameDataList.get(position).setChampionName(response.body().getName());
                    gameDataList.get(position).setChampionKey(response.body().getKey());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }


}
