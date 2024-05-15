package com.example.fitnessproject1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Profile extends Fragment {

    private EditText et_name, et_surname, et_height, et_weight;
    private Button calculateButton;



    public Profile() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        et_name = view.findViewById(R.id.ep_name);
        et_surname = view.findViewById(R.id.ep_surname);
        et_height = view.findViewById(R.id.ep_height);
        et_weight = view.findViewById(R.id.ep_weight);
        calculateButton = view.findViewById(R.id.btn_calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

       
        return view;
    }

    private void calculateBMI() {
        String name = et_name.getText().toString();
        String surname = et_surname.getText().toString();
        String heightStr = et_height.getText().toString();
        String weightStr = et_weight.getText().toString();

        if (name.isEmpty() || surname.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(getActivity(), "Please fill all fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        double height = Double.parseDouble(heightStr);
        double weight = Double.parseDouble(weightStr);

        double bmi = calculateBMI(height, weight);


        String notification = "Dear " + name + " " + surname + ";\n\n";
        notification += "Your Body Mass Index (BMI) is: " + bmi;
        Toast.makeText(getActivity(), notification, Toast.LENGTH_LONG).show();
    }

    private double calculateBMI(double height, double weight) {

        return weight / ((height / 100) * (height / 100));
    }


}
