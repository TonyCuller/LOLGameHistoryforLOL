package com.tonycitadel.lolgamehistoryforlol.gamehistory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.Rest.ApiKey;

import java.io.IOException;

public class SummonerSearchActivity extends Activity {
    private EditText et;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner_search);

        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSummonerId();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summoner_search, menu);
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

    private void getSummonerId() {
        et = (EditText) findViewById(R.id.editText);
        final String name = et.getText().toString().toLowerCase();
        System.out.println(name);


        if (name != "") {
            System.out.println(name);
            OkHttpClient client = new OkHttpClient();

            final Request request = new Request.Builder()
                    .url("https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/" + name + "?api_key=" + ApiKey.getAPIKEY())
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {

                }

                @Override
                public void onResponse(Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String data = response.body().string();
                        JsonParser parser = new JsonParser();
                        JsonObject obj = (JsonObject) parser.parse(data);
                        JsonObject nameObj = obj.getAsJsonObject(name);
                        long id = nameObj.get("id").getAsLong();
                        System.out.println(id);
                        Intent intent = new Intent(getApplication(), MainActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                }
            });

        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter a Summoner Name", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

