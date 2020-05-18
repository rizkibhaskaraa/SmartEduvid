package com.example.smarteduvid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // membuat recyclerview in linear layout

        myAdapter = new MyAdapter(this,getMyList());
        mRecyclerView.setAdapter(myAdapter);

    }

    private ArrayList <Model> getMyList() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model ();
        m.setTitle("Edukasi Seputar Covid-19");
        m.setDescription("Berikut merupakan Informasi Edukasi mengenai Covid-19");
        m.setImage((R.drawable.information));


        models.add(m);

        m = new Model();
        m.setTitle("Data Covid-19 Di Indonesia");
        m.setDescription("Data Persebaran Covid-19 di Indonesia");
        m.setImage((R.drawable.world));
        models.add(m);

        m = new Model();
        m.setTitle("Nomor Darurat Covid-19");
        m.setDescription("Berikut merupakan Nomor Darurat untuk Tanggap Covid-19 Indonesia");
        m.setImage((R.drawable.call));
        models.add(m);

        m = new Model();
        m.setTitle("Daftar Rumah Sakit Rujukan Covid-19");
        m.setDescription("Berikut Daftar Rumah Sakit Rujukan untuk Covid-19 Di Seluruh Indonesia");
        m.setImage((R.drawable.hospital));
        models.add(m);


        return models;

    }
            //create an interface class
            // now go to holder class
    //now create an activity

}
