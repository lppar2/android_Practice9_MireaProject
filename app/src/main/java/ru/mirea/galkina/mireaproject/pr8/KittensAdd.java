package ru.mirea.galkina.mireaproject.pr8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.galkina.mireaproject.MainActivity;
import ru.mirea.galkina.mireaproject.R;
import ru.mirea.galkina.mireaproject.pr6.App;
import ru.mirea.galkina.mireaproject.pr6.AppDatebase;

public class KittensAdd extends AppCompatActivity {
    private EditText name;
    private EditText breed;
    private EditText color;
    private EditText age;
    private Button button;

    private AppDatebase db;
    private KittensDao kittensDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kittens_view);

        db = App.getInstance().getDatabase();
        kittensDao = db.kittensDao();

        name = findViewById(R.id.editNameKitten);
        breed = findViewById(R.id.editBreedKitten);
        color = findViewById(R.id.editColorKitten);
        age = findViewById(R.id.editAgeKitten);

        button = findViewById(R.id.btnSaveKitten);
        button.setOnClickListener(this::saveBtn);
    }

    public void saveBtn(View view) {

        Kittens kitten = new Kittens();
        kitten.name = name.getText().toString();
        kitten.breed = breed.getText().toString();
        kitten.color = color.getText().toString();
        kitten.age = age.getText().toString();

        kittensDao.insert(kitten);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}