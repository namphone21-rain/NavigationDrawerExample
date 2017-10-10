package com.examplecode.rain.navigationdrawerexample;

import java.util.ArrayList;

/**
 * Created by Rain Surasorn on 10/9/2017.
 */

public class NorthEasternMenu {

    private final String[] thai = {"ลาบหมู", "น้ำตกหมู", "ตำไทย", "ไก่ย่าง", "ข้าวเหนียว", "หมูย่าง"};
    private final String[] english = {"Salty-Sour Ground Pork Salad", "Salty-Sour Grilled Pork Salad",
            "Original Thai Papaya Salad", "Grilled Chicken", "Sticky Rice", "Grilled Pork"};
    private final int[] images = {R.drawable.laabmoo, R.drawable.numthokemoo, R.drawable.thumthai, R.drawable.grilledchicken,
    R.drawable.kowniow, R.drawable.mooyaang};
    private final int[] audios = {R.raw.laabmoo, R.raw.numthokemoo, R.raw.thumthai, R.raw.gaiyaang, R.raw.kowniow,
    R.raw.mooyaang};
    private final String[] pronunciation = {"Laab Moo", "Numthoke Moo", "Thum Thai", "Gai Yaang", "Koa Niow", "Moo Yaang"};

    public ArrayList<MenuItem> getMenuItems(){

        ArrayList<MenuItem> list = new ArrayList<>();

        for( int i = 0; i < thai.length; i++){

            list.add(new MenuItem(thai[i], english[i], images[i], audios[i], pronunciation[i]));
        }

        return list;
    }
}
