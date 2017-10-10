package com.examplecode.rain.navigationdrawerexample;

import java.util.ArrayList;

/**
 * Created by Rain Suasorn on 10/9/2017.
 */

public class DrinksMenu {

    private final String[] thai = {"น้ำขวด", "โค้ก", "เบียร์สิงห์", "สไปรท์"};
    private final String[] english = {"water in a bottle", "Coke",  "Singha Beer", "Sprite"};
    private final int[] images = {R.drawable.numkoad, R.drawable.coke, R.drawable.beersing, R.drawable.sprite};
    private final int[] audios = {R.raw.numkoad, R.raw.coke, R.raw.beersing, R.raw.sprite};
    private final String[] pronunciation = {"Num Koad", "Coke", "Beer Sing", "Sprite"};


    public ArrayList<MenuItem> getMenuItems(){

        ArrayList<MenuItem> list = new ArrayList<>();

        for( int i = 0; i < thai.length; i++){

            list.add(new MenuItem(thai[i], english[i], images[i], audios[i], pronunciation[i]));
        }

        return list;
    }

}
