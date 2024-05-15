package com.example.fitnessproject1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {
    private static List<Meal> mealList;
    private static MealClickListener listener;

    public interface MealClickListener {
        void onItemClick(Meal meal);
    }

    public MealAdapter(List<Meal> mealList) {
        this.mealList = mealList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, parent, false);
        return new MealViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = mealList.get(position);
        holder.mealNameTextView.setText(meal.getName());
        holder.calorieTextView.setText("Calories: " + meal.getCalories());
        holder.cb_diet.setChecked(meal.isSelected());


        holder.cb_diet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                meal.setSelected(isChecked);
            }
        });

        Glide.with(holder.itemView.getContext())
                .load(meal.getImageResourceId())
                .into(holder.mealImageView);
    }

    public int calculateTotalCalories() {
        int totalCalories = 0;
        for (Meal meal : mealList) {
            if (meal.isSelected()) {
                totalCalories += meal.getCalories();
            }
        }
        return totalCalories;
    }



    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public static class MealViewHolder extends RecyclerView.ViewHolder {
        ImageView mealImageView;
        TextView mealNameTextView;
        TextView calorieTextView;

        CheckBox cb_diet;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            mealImageView = itemView.findViewById(R.id.meal_image_view);
            mealNameTextView = itemView.findViewById(R.id.meal_name_text_view);
            calorieTextView = itemView.findViewById(R.id.calorie_text_view);
            cb_diet = itemView.findViewById(R.id.cb_diet);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(mealList.get(position));
                    }
                }
            });

            cb_diet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Meal meal = mealList.get(position);
                        meal.setSelected(cb_diet.isChecked());
                    }
                }
            });
        }
    }
}
