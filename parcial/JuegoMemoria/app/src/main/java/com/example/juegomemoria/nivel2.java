package com.example.juegomemoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class nivel2 extends AppCompatActivity {
    ImageButton ib21, ib22, ib23, ib24, ib25, ib26;
    Integer ib21_active = 0;
    Integer ib22_active = 0;
    Integer ib23_active = 0;
    Integer ib24_active = 0;
    Integer ib25_active = 0;
    Integer ib26_active = 0;
    Integer set_1_won = 0;
    Integer set_2_won = 0;
    Integer set_3_won = 0;
    Integer score2 = 0;
    TextView sc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);

        ib21 = (ImageButton) findViewById(R.id.ib21);
        ib22 = (ImageButton) findViewById(R.id.ib22);
        ib23 = (ImageButton) findViewById(R.id.ib23);
        ib24 = (ImageButton) findViewById(R.id.ib24);
        ib25 = (ImageButton) findViewById(R.id.ib25);
        ib26 = (ImageButton) findViewById(R.id.ib26);
        sc2 = (TextView) findViewById(R.id.sc2);

        ib21.setOnClickListener(imgHandler21);
        ib22.setOnClickListener(imgHandler22);
        ib23.setOnClickListener(imgHandler23);
        ib24.setOnClickListener(imgHandler24);
        ib25.setOnClickListener(imgHandler25);
        ib26.setOnClickListener(imgHandler26);
    }
    View.OnClickListener imgHandler21 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib21_active == 1){
                ib21.setImageResource(R.drawable.img4);
                ib21_active = 0;
            }
            else{
                ib21.setImageResource(R.drawable.img1);
                ib21_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener imgHandler22 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib22_active == 1){
                ib22.setImageResource(R.drawable.img4);
                ib22_active = 0;
            }
            else{
                ib22.setImageResource(R.drawable.img1);
                ib22_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener imgHandler23 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib23_active == 1){
                ib23.setImageResource(R.drawable.img4);
                ib23_active = 0;
            }
            else{
                ib23.setImageResource(R.drawable.img2);
                ib23_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener imgHandler24 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib24_active == 1){
                ib24.setImageResource(R.drawable.img4);
                ib24_active = 0;
            }
            else{
                ib24.setImageResource(R.drawable.img2);
                ib24_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener imgHandler25 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib25_active == 1){
                ib25.setImageResource(R.drawable.img4);
                ib25_active = 0;
            }
            else{
                ib25.setImageResource(R.drawable.img3);
                ib25_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener imgHandler26 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib26_active == 1){
                ib26.setImageResource(R.drawable.img4);
                ib26_active = 0;
            }
            else{
                ib26.setImageResource(R.drawable.img3);
                ib26_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener void_button = new View.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private void Check_score(){
        Integer total_active = ib21_active + ib22_active + ib23_active + ib24_active + ib25_active + ib26_active;
        if (total_active > 2){
            if (set_1_won == 0){
                ib21_active = 0;
                ib22_active = 0;
                ib21.setImageResource(R.drawable.img4);
                ib22.setImageResource(R.drawable.img4);
            }
            if (set_2_won == 0){
                ib23_active = 0;
                ib24_active = 0;
                ib23.setImageResource(R.drawable.img4);
                ib24.setImageResource(R.drawable.img4);
            }
            if (set_3_won == 0){
                ib25_active = 0;
                ib26_active = 0;
                ib25.setImageResource(R.drawable.img4);
                ib26.setImageResource(R.drawable.img4);
            }
            Toast.makeText(this, "Intenta de nuevo", Toast.LENGTH_SHORT).show();
        }
        if (ib21_active == 1 && ib22_active == 1){
            score2 = score2 + 1;
            ib21_active = 0;
            ib22_active = 0;
            // ib1.setImageResource(R.drawable.img4);
            // ib2.setImageResource(R.drawable.img4);
            ib21.setOnClickListener(void_button);
            ib22.setOnClickListener(void_button);
            set_1_won = 1;
            Toast.makeText(this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
        }
        if (ib23_active == 1 && ib24_active == 1){
            score2 = score2 + 1;
            ib23_active = 0;
            ib24_active = 0;
            ib23.setOnClickListener(void_button);
            ib24.setOnClickListener(void_button);
            set_2_won = 1;
            Toast.makeText(this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
        }
        if (ib25_active == 1 && ib26_active == 1){
            score2 = score2 + 1;
            ib25_active = 0;
            ib26_active = 0;
            ib25.setOnClickListener(void_button);
            ib26.setOnClickListener(void_button);
            set_3_won = 1;
        }
        sc2.setText("" + score2);
        if (score2 == 3) {
            Toast.makeText(this, "¡Ganaste!", Toast.LENGTH_SHORT).show();
            Intent siguiente = new Intent(this, ganaste.class);
            startActivity(siguiente);
        }
    }
}