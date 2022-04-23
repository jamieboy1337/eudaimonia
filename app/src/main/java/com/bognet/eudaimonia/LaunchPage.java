package com.bognet.eudaimonia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.bognet.eudaimonia.homescreen.HomeScreen;
import com.bognet.eudaimonia.input.KeyboardHandler;
import com.google.android.material.snackbar.Snackbar;

import lombok.Getter;

// in actuality:
// bump to an initial activity which displays a logo
//
public class LaunchPage extends AppCompatActivity implements View.OnClickListener {

    private EditText nameField;
    private View homeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.launch_page);

        this.nameField = this.findViewById(R.id.editTextTextPersonName);
        this.homeView = this.findViewById(R.id.linearLayout);

        Button button = this.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String name = this.nameField.getText().toString();
        KeyboardHandler.hideKeyboard(this, this.homeView);
        if (name.length() <= 0) {
            Snackbar.make(this.homeView, "Name cannot be blank.", Snackbar.LENGTH_LONG).show();
        } else {
            // advance app state
            Intent i = new Intent(this, HomeScreen.class);
            this.startActivity(i);
            // removes this activity from the stack
            finish();
            // ignore the tear for now we can engineer it later
        }
    }
}