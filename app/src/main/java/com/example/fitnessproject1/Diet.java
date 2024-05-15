package com.example.fitnessproject1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Diet extends Fragment implements MealAdapter.MealClickListener{

    private RecyclerView recyclerView;
    private MealAdapter mealAdapter;
    private List<Meal> mealList;

    public Diet(){

    }

    @Override
    public void onItemClick(Meal meal) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_diet, container, false);


        Button calculateButton = view.findViewById(R.id.btn_dietcalculate);



        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mealList = createSampleMeals();

        mealAdapter = new MealAdapter(mealList);
        recyclerView.setAdapter(mealAdapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalCalories = mealAdapter.calculateTotalCalories();

                if(totalCalories>3000){

                    Toast.makeText(getActivity(), "Total Calories: " + totalCalories + "  Eat less", Toast.LENGTH_SHORT).show();

                }else if(totalCalories<3000 && totalCalories>2000){


                    Toast.makeText(getActivity(), "Total Calories: " + totalCalories + "  You're healty", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(getActivity(), "Total Calories: " + totalCalories + "  Eat more", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }

    private int calculateTotalCalories() {
        int totalCalories = 0;
        for (Meal meal : mealList) {
            if (meal.isSelected()) { // Eğer yemek seçiliyse
                totalCalories += meal.getCalories(); // Toplam kaloriye ekle
            }
        }
        return totalCalories;
    }

    private List<Meal> createSampleMeals() {
        List<Meal> mealList = new ArrayList<>();


        Meal meal1 = new Meal("Pasta", R.drawable.pasta, 350);
        Meal meal2 = new Meal("Pilav", R.drawable.pilav, 380);
        Meal meal3 = new Meal("Omlette", R.drawable.omlette, 300);
        Meal meal4 = new Meal("Hamburger", R.drawable.hamburger, 400);
        Meal meal5 = new Meal("Pizza", R.drawable.pizza, 800);
        Meal meal6 = new Meal("Fries", R.drawable.fries, 450);
        Meal meal7 = new Meal("Bread", R.drawable.bread, 360);
        Meal meal8 = new Meal("Coke", R.drawable.coke, 250);
        Meal meal9 = new Meal("Juice", R.drawable.juice, 100);
        Meal meal10 = new Meal("Baklava", R.drawable.baklava, 650);
        Meal meal11 = new Meal("Sütlaç", R.drawable.sutlac, 360);


        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);
        mealList.add(meal4);
        mealList.add(meal5);
        mealList.add(meal6);
        mealList.add(meal7);
        mealList.add(meal8);
        mealList.add(meal9);
        mealList.add(meal10);
        mealList.add(meal11);


        return mealList;
    }

}
