package com.example.exemplolista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemplolista.model.AppDatabase;
import com.example.exemplolista.model.ListItem;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database-name1").allowMainThreadQueries().build();

                ListItem item = new ListItem();
                EditText textHead = findViewById(R.id.editTextHead);
                EditText textDesc = findViewById(R.id.editTextDesc);

                item.head = textHead.getText().toString();
                item.desc = textDesc.getText().toString();

                db.itemDao().insertAll(item);

                //Volta para a tela encerrando a activity.
                finish();
            }
        });
    }
}
