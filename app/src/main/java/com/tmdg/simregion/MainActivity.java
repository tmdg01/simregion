package com.tmdg.simregion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRu = findViewById(R.id.button_ru);
        Button buttonKz = findViewById(R.id.button_kz);
        Button buttonBy = findViewById(R.id.button_by);
        Button buttonUa = findViewById(R.id.button_ua);

        buttonRu.setOnClickListener(view -> executeCommand("su -c resetprop gsm.sim.operator.iso-country ru"));
        buttonKz.setOnClickListener(view -> executeCommand("su -c resetprop gsm.sim.operator.iso-country kz"));
        buttonBy.setOnClickListener(view -> executeCommand("su -c resetprop gsm.sim.operator.iso-country by"));
        buttonUa.setOnClickListener(view -> executeCommand("su -c resetprop gsm.sim.operator.iso-country ua"));
    }

    private void executeCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
            Toast.makeText(this, "Region Changed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error! Non-Root Device: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


}