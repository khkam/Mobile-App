package com.example.assignment_details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

public class FoodDetails extends AppCompatActivity {
    private TextView name, cook_time, prep_time, ingred, steps;
    private FirebaseAuth database;
    private DatabaseReference reference;
    private String food_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        if (getIntent() !=null) {
            food_ID = getIntent().getStringExtra("foodID");
        }

        reference = FirebaseDatabase.getInstance().getReference("Food");
        name = findViewById(R.id.foodname);
        cook_time = findViewById(R.id.cook_time);
        prep_time = findViewById(R.id.prep_time);
        ingred = findViewById(R.id.ingred);
        steps = findViewById(R.id.steps);


        reference.child(food_ID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Food food = snapshot.getValue(Food.class);

                name.setText(food.getFoodname());
                cook_time.setText(food.getCook_time());
                prep_time.setText(food.getPrep_time());
                ingred.setText(food.getIngred());
                steps.setText(food.getSteps());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FoodDetails.this, "Error!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}