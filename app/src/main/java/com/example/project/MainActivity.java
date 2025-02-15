package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView textViewName;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewName = findViewById(R.id.name);
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        Bundle extras = getIntent().getExtras();

        // Om extras från tidigare intent finns så lägg detta i shared preferences
        if (extras != null) {
            String text = extras.getString("text");
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("text" , text);
            editor.apply();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Visar menyalternativ i menyn
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // När Ändra text väljs i menyn skapas en ny intent
            case R.id.change_text:
                startActivity(new Intent(this, SecondActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Sätter texten för textview till värdet från shared preferences
        String name = preferences.getString("text", "ingen text hittades");
        textViewName.setText(name);
    }
}
