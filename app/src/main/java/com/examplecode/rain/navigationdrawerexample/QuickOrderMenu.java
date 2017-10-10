package com.examplecode.rain.navigationdrawerexample;

import java.util.ArrayList;

/**
 * Created by Rain Suasorn on 10/9/2017.
 */

public class QuickOrderMenu {

    private final String[] thai = {"ข้าวผัดไก่", "ผัดไทยกุ้ง", "กะเพราไก่ไข่ดาว", "ข้าวไข่เจียวหมูสับ", "ผัดขี้เมา", "ผัดซีอิ๊วไก่"};
    private final String[] english = {"Chicken Fried Rice", "Shrimp Pad Thai",
            "Chicken Gaprow with Egg", "Thai Omellet Over Rice", "Seafood Pad Keemow",
            "Chicken Pad See-eew"};
    private final int[] images = {R.drawable.chickenfriedrice, R.drawable.shrimppadthai,
            R.drawable.kowgaprowgai, R.drawable.kowkaijiowmoosub, R.drawable.padkeemowtalay,
            R.drawable.chicken_pad_see_eew};
    private final int[] audios = {R.raw.kowpudgai, R.raw.pudthaigoong, R.raw.gaprowgaikaidow,
            R.raw.kaawkaijiowmoosub, R.raw.pudkeemow, R.raw.pudsee_eewgai };
    private final String[] pronunciation = {"Kow Pud Gai", "Pud Thai Goong", "Ga-prow Gai Kai Daaw",
            "Kow Kaijiow Moosub", "Pud Keemow", "Pud See-eew Gai"};

    public ArrayList<MenuItem> getMenuItems(){

        ArrayList<MenuItem> list = new ArrayList<>();

        for( int i = 0; i < thai.length; i++){

            list.add(new MenuItem(thai[i], english[i], images[i], audios[i], pronunciation[i]));
        }

        return list;
    }

}
