package com.examplecode.rain.navigationdrawerexample;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rain Suasorn on 10/9/2017.
 */

public class MenuAdapter extends BaseAdapter {

    ArrayList<MenuItem> menu_list;

    Context context;
    LayoutInflater inflater;
    ViewHolder viewHolder;

    public MenuAdapter(Context context, ArrayList<MenuItem> menu_list){
        this.context = context;
        this.menu_list = menu_list;
        viewHolder = null;
        inflater = LayoutInflater.from(context);

    }

    public void setMenu_list(ArrayList<MenuItem> menu_list){
        this.menu_list = menu_list;
    }

    @Override
    public int getCount() {
        return menu_list.size();
    }

    @Override
    public Object getItem(int position) {
        return menu_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if( convertView == null){

            convertView =
                    inflater.inflate(R.layout.one_cell_menu, parent,false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) convertView.getTag();
        }


        MenuItem item = (MenuItem) getItem(position);
        viewHolder.foodImageView.setBackgroundResource(item.getImage());
        viewHolder.english.setText(item.getEnlgish());
        viewHolder.thai.setText(item.getThai());
        viewHolder.pronunc.setText(item.getPronunciation());
        viewHolder.playAudio.setTag(item.getAudio());

        return convertView;
    }


    private class ViewHolder{

        ImageView foodImageView;
        TextView english;
        TextView thai;
        TextView pronunc;
        Button playAudio;

        MediaPlayer mediaPlayer; // manage and audio


        ViewHolder(View v){

            foodImageView = (ImageView)v.findViewById(R.id.imageView);
            english = (TextView)v.findViewById(R.id.english);
            thai = (TextView)v.findViewById(R.id.thai);
            pronunc = (TextView)v.findViewById(R.id.pronunciation);
            playAudio = (Button)v.findViewById(R.id.audio);
            playAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int audio = (Integer)view.getTag();
                    mediaPlayer = MediaPlayer.create(view.getContext(), audio);
                    mediaPlayer.start();
                }
            });
        }

    }
}
