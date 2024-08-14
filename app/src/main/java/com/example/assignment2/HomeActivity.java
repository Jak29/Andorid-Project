package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements MyAdapter.ItemClickListener {
    MyAdapter myAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Quiz");
        myList.add("Exercise");
        myList.add("Tutorial");


        ArrayList<Integer> myImages = new ArrayList<Integer>();
        myImages.add(R.drawable.quiz);
        myImages.add(R.drawable.exercise);
        myImages.add(R.drawable.tutorial);


        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new GridLayoutManager(this,1));
        myAdapter = new MyAdapter(this, myList,myImages);
        myAdapter.setClickListener(this);
        rv.setAdapter(myAdapter);


    }

    @Override
    public void onItemClick(View view, int position) {
        String option = myAdapter.getItem(position);
        Toast.makeText(this,
                "You clicked on " + option,
                Toast.LENGTH_SHORT).show();

        switch (position+1) {
            case 1:
                Intent intent = new Intent(view.getContext(),QuizActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
                break;
            case 2:
                Intent intent2 = new Intent(view.getContext(),ExerciseActivity.class);
                intent2.putExtra("position",position);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(view.getContext(),TutorialActivity.class);
                intent3.putExtra("position",position);
                startActivity(intent3);
                break;
        }

    }


}