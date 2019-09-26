package com.example.exemplolista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.exemplolista.model.AppDatabase;
import com.example.exemplolista.model.ListItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Teste",Toast.LENGTH_SHORT).show();

                //Ao Clicar no botão ele irá para a tela formulário.
                Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intent);

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView. setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name1").allowMainThreadQueries().build();

        listItems = db.itemDao().getAll();

        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        listItems = new ArrayList<>();

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name1").allowMainThreadQueries().build();

        listItems = db.itemDao().getAll();

        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }
}

