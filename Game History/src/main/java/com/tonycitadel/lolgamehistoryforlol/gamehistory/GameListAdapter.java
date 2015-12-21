package com.tonycitadel.lolgamehistoryforlol.gamehistory;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.tonycitadel.lolgamehistoryforlol.gamehistory.POJO.Game;

import java.util.List;

/**
 * Custom Adapter Class
 */
public class GameListAdapter extends ArrayAdapter<Game> {
    int resource;
    private String items = "http://ddragon.leagueoflegends.com/cdn/5.24.2/img/item/";
    private String spells = "http://ddragon.leagueoflegends.com/cdn/5.24.2/img/spell/Summoner";
    private String championImgaeData = "http://ddragon.leagueoflegends.com/cdn/5.24.2/img/champion/";
    private Context context;
    private LayoutInflater inflater;
    private List<Game> gameData;


    public GameListAdapter(Context context, int resource, List<Game> gameData) {
        super(context, resource, gameData);
        this.context = context;
        this.resource = resource;
        this.gameData = gameData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
        }


        TextView champion = (TextView) convertView.findViewById(R.id.champName);
        TextView level = (TextView) convertView.findViewById(R.id.level);
        TextView cs = (TextView) convertView.findViewById(R.id.cs);
        ImageView item0 = (ImageView) convertView.findViewById(R.id.item1);
        ImageView item1 = (ImageView) convertView.findViewById(R.id.item2);
        ImageView item2 = (ImageView) convertView.findViewById(R.id.item3);
        ImageView item3 = (ImageView) convertView.findViewById(R.id.item4);
        ImageView item4 = (ImageView) convertView.findViewById(R.id.item5);
        ImageView item5 = (ImageView) convertView.findViewById(R.id.item6);
        ImageView item6 = (ImageView) convertView.findViewById(R.id.trinket);
        ImageView championImage = (ImageView) convertView.findViewById(R.id.championImage);
        ImageView ss1 = (ImageView) convertView.findViewById(R.id.ss1);
        ImageView ss2 = (ImageView) convertView.findViewById(R.id.ss2);


        ImageView win = (ImageView) convertView.findViewById(R.id.win);


        Game data = gameData.get(position);

        switch (data.getSpell1()) {
            case 21:
                Picasso.with(context).load(spells + "Barrier.png").fit().into(ss1);
                break;
            case 1:
                Picasso.with(context).load(spells + "Boost.png").fit().into(ss1);
                break;
            case 2:
                Picasso.with(context).load(spells + "Clairvoyance.png").fit().into(ss1);
                break;
            case 14:
                Picasso.with(context).load(spells + "Dot.png").fit().into(ss1);
                break;
            case 3:
                Picasso.with(context).load(spells + "Exhaust.png").fit().into(ss1);
                break;
            case 4:
                Picasso.with(context).load(spells + "Flash.png").fit().into(ss1);
                break;
            case 6:
                Picasso.with(context).load(spells + "Haste.png").fit().into(ss1);
                break;
            case 7:
                Picasso.with(context).load(spells + "Heal.png").fit().into(ss1);
                break;
            case 13:
                Picasso.with(context).load(spells + "Mana.png").fit().into(ss1);
                break;
            case 17:
                Picasso.with(context).load(spells + "OdinGarrison.png").fit().into(ss1);
                break;
            case 30:
                Picasso.with(context).load(spells + "PorpRecall.png").fit().into(ss1);
                break;
            case 31:
                Picasso.with(context).load(spells + "PorpThrow.png").fit().into(ss1);
                break;
            case 11:
                Picasso.with(context).load(spells + "Smite.png").fit().into(ss1);
                break;
            case 32:
                Picasso.with(context).load(spells + "Snowball.png").fit().into(ss1);
                break;
            case 12:
                Picasso.with(context).load(spells + "Teleport.png").fit().into(ss1);
                break;


        }

        switch (data.getSpell2()) {
            case 21:
                Picasso.with(context).load(spells + "Barrier.png").fit().into(ss2);
                break;
            case 1:
                Picasso.with(context).load(spells + "Boost.png").fit().into(ss2);
                break;
            case 2:
                Picasso.with(context).load(spells + "Clairvoyance.png").fit().into(ss2);
                break;
            case 14:
                Picasso.with(context).load(spells + "Dot.png").fit().into(ss2);
                break;
            case 3:
                Picasso.with(context).load(spells + "Exhaust.png").fit().into(ss2);
                break;
            case 4:
                Picasso.with(context).load(spells + "Flash.png").fit().into(ss2);
                break;
            case 6:
                Picasso.with(context).load(spells + "Haste.png").fit().into(ss2);
                break;
            case 7:
                Picasso.with(context).load(spells + "Heal.png").fit().into(ss2);
                break;
            case 13:
                Picasso.with(context).load(spells + "Mana.png").fit().into(ss2);
                break;
            case 17:
                Picasso.with(context).load(spells + "OdinGarrison.png").fit().into(ss2);
                break;
            case 30:
                Picasso.with(context).load(spells + "PorpRecall.png").fit().into(ss2);
                break;
            case 31:
                Picasso.with(context).load(spells + "PorpThrow.png").fit().into(ss2);
                break;
            case 11:
                Picasso.with(context).load(spells + "Smite.png").fit().into(ss2);
                break;
            case 32:
                Picasso.with(context).load(spells + "Snowball.png").fit().into(ss2);
                break;
            case 12:
                Picasso.with(context).load(spells + "Teleport.png").fit().into(ss2);
                break;
        }


        champion.setText(data.getChampionName());
        level.setText("Level: " + String.valueOf(data.getStats().getLevel()));
        cs.setText("CS: " + String.valueOf(data.getStats().getMinionsKilled()));

        Picasso.with(context).load(championImgaeData + data.getChampionKey() + ".png").fit().into(championImage);

        Picasso.with(context).load(items + data.getStats().getItem1() + ".png").error(R.drawable.items).fit().into(item1);
        Picasso.with(context).load(items + data.getStats().getItem2() + ".png").error(R.drawable.items).fit().into(item2);
        Picasso.with(context).load(items + data.getStats().getItem3() + ".png").error(R.drawable.items).fit().into(item3);
        Picasso.with(context).load(items + data.getStats().getItem4() + ".png").error(R.drawable.items).fit().into(item4);
        Picasso.with(context).load(items + data.getStats().getItem5() + ".png").error(R.drawable.items).fit().into(item5);
        Picasso.with(context).load(items + data.getStats().getItem6() + ".png").error(R.drawable.items).fit().into(item6);
        Picasso.with(context).load(items + data.getStats().getItem0() + ".png").error(R.drawable.items).fit().into(item0);

        if (!data.getStats().getWin()) {
            win.setBackgroundColor(Color.RED);
        }


        return convertView;

    }

}