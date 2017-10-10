package com.examplecode.rain.navigationdrawerexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LearnToOrderFragment extends Fragment {

    ArrayList<MenuItem> menuItems = new ArrayList<>();
    CheckBox drinks;
    CheckBox quickMeal;
    CheckBox esaanFood;
    ListView listView;

    public LearnToOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn_to_order, container, false);

        drinks = (CheckBox)view.findViewById(R.id.drinksCheckBox);
        drinks.setChecked(true);

        quickMeal = (CheckBox)view.findViewById(R.id.quickMealCheckBox);
        quickMeal.setChecked(true);

        esaanFood = (CheckBox)view.findViewById(R.id.esaarnCheckBox);
        esaanFood.setChecked(true);

        listView = (ListView)view.findViewById(R.id.listView);
        setMenuItems();
        final MenuAdapter adapter = new MenuAdapter(getContext(), menuItems);
        listView.setAdapter(adapter);

        Button updateButton = (Button)view.findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkDrinksMenu();
                checkQuickMealMenu();
                checkEsaanMenu();
                adapter.setMenu_list(menuItems);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    private void checkEsaanMenu(){

        ArrayList<MenuItem> esaarnFoodMenu = new NorthEasternMenu().getMenuItems();
        boolean isAdded = esaanFoodIsAdded();

        if( esaanFood.isChecked()){

            if( !isAdded ){
                menuItems.addAll(esaarnFoodMenu);
            }
        }else{
            if( isAdded){
                menuItems.removeAll(esaarnFoodMenu);
            }
        }
    }

    private void checkQuickMealMenu(){

        ArrayList<MenuItem> quickMealMenu = new QuickOrderMenu().getMenuItems();
        boolean isAdded = quickMealIsAdded();

        if(quickMeal.isChecked()){

            if( ! isAdded ){

                menuItems.addAll(quickMealMenu);
            }
        }else{
            if( isAdded ){
                menuItems.removeAll(quickMealMenu);
            }
        }
    }

    private void checkDrinksMenu(){
        ArrayList<MenuItem> drinksMenu = new DrinksMenu().getMenuItems();
        boolean isAdded = drinksAreAdded();

        if (drinks.isChecked()) {
            if (!isAdded) {
                menuItems.addAll(drinksMenu);
            }
        } else {
            if (isAdded) {

                menuItems.removeAll(drinksMenu);
            }
        }
    }

    private boolean esaanFoodIsAdded(){

        if (menuItems.isEmpty()){
            return false;
        }

        ArrayList<MenuItem> esaanFood = new NorthEasternMenu().getMenuItems();
        for (MenuItem item: esaanFood) {
            if( menuItems.contains(item)){
                return true;
            }
        }

        return false;
    }

    private boolean quickMealIsAdded(){
        if (menuItems.isEmpty()){
            return false;
        }

        ArrayList<MenuItem> quickMeal = new QuickOrderMenu().getMenuItems();
        for (MenuItem item: quickMeal) {
            if( menuItems.contains(item)){
                return true;
            }
        }

        return false;
    }

    private boolean drinksAreAdded(){
        if (menuItems.isEmpty()){
            return false;
        }

        ArrayList<MenuItem> drinks = new DrinksMenu().getMenuItems();
        for (MenuItem item: drinks) {
            if( menuItems.contains(item)){
                return true;
            }
        }

        return false;
    }
    private void setMenuItems(){

        DrinksMenu drinks = new DrinksMenu();
        menuItems.addAll(drinks.getMenuItems());

        QuickOrderMenu quickMeal = new QuickOrderMenu();
        menuItems.addAll(quickMeal.getMenuItems());

        NorthEasternMenu esaarnFood = new NorthEasternMenu();
        menuItems.addAll(esaarnFood.getMenuItems());
    }

}
