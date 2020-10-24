package com.example.juegomemoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton ib1, ib2, ib3, ib4;
    Integer ib1_active = 0;
    Integer ib2_active = 0;
    Integer ib3_active = 0;
    Integer ib4_active = 0;
    Integer score = 0;
    TextView sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ib1 = (ImageButton) findViewById(R.id.ib1);
        ib2 = (ImageButton) findViewById(R.id.ib2);
        ib3 = (ImageButton) findViewById(R.id.ib3);
        ib4 = (ImageButton) findViewById(R.id.ib4);
        sc = (TextView) findViewById(R.id.textView2);

        ib1.setImageResource(R.drawable.img4);
        ib2.setImageResource(R.drawable.img4);
        ib3.setImageResource(R.drawable.img4);
        ib4.setImageResource(R.drawable.img4);

        ib1.setOnClickListener(imgHandler1);
        ib2.setOnClickListener(imgHandler2);
        ib3.setOnClickListener(imgHandler3);
        ib4.setOnClickListener(imgHandler4);
    }
    View.OnClickListener imgHandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib1_active == 1){
                ib1.setImageResource(R.drawable.img4);
                ib1_active = 0;
            }
            else{
                ib1.setImageResource(R.drawable.img1);
                ib1_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener imgHandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib2_active == 1){
                ib2.setImageResource(R.drawable.img4);
                ib2_active = 0;
            }
            else{
                ib2.setImageResource(R.drawable.img1);
                ib2_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener imgHandler3 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib3_active == 1){
                ib3.setImageResource(R.drawable.img4);
                ib3_active = 0;
            }
            else{
                ib3.setImageResource(R.drawable.img2);
                ib3_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener imgHandler4 = new View.OnClickListener() {
        public void onClick(View v) {
            if (ib4_active == 1){
                ib4.setImageResource(R.drawable.img4);
                ib4_active = 0;
            }
            else{
                ib4.setImageResource(R.drawable.img2);
                ib4_active = 1;
                Check_score();
            }
        }
    };
    View.OnClickListener void_button = new View.OnClickListener() {
        public void onClick(View v) {
        }
    };
    private void Check_score(){
        Integer total_active = ib1_active + ib2_active + ib3_active + ib4_active;
        if (total_active > 2){
            ib1_active = 0;
            ib2_active = 0;
            ib3_active = 0;
            ib4_active = 0;
            ib1.setImageResource(R.drawable.img4);
            ib2.setImageResource(R.drawable.img4);
            ib3.setImageResource(R.drawable.img4);
            ib4.setImageResource(R.drawable.img4);
            Toast.makeText(this, "Intenta de nuevo", Toast.LENGTH_SHORT).show();
        }
        if (ib1_active == 1 && ib2_active == 1){
            score = score + 1;
            ib1_active = 0;
            ib2_active = 0;
            // ib1.setImageResource(R.drawable.img4);
            // ib2.setImageResource(R.drawable.img4);
            ib1.setOnClickListener(void_button);
            ib2.setOnClickListener(void_button);
            Toast.makeText(this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
        }
        if (ib3_active == 1 && ib4_active == 1){
            score = score + 1;
            ib3_active = 0;
            ib4_active = 0;
            ib3.setOnClickListener(void_button);
            ib4.setOnClickListener(void_button);
            Toast.makeText(this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
        }
        sc.setText("" + score);
        if (score == 2) {
            Toast.makeText(this, "Pasas al siguiente nivel", Toast.LENGTH_SHORT).show();
            Intent siguiente = new Intent(this, nivel2.class);
            startActivity(siguiente);
        }
    }
}