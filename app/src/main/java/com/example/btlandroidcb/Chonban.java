package com.example.btlandroidcb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chonban extends AppCompatActivity {
    Button btn_table1,btn_table2, btn_table3, btn_table4, btn_table5, btn_table6, btn_table7, btn_table8, btn_table9, btn_table10, btn_table11, btn_table12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chonban);
        btn_table1 = findViewById(R.id.btn_table1);
        btn_table2 = findViewById(R.id.btn_table2);
        btn_table3 = findViewById(R.id.btn_table3);
        btn_table4 = findViewById(R.id.btn_table4);
        btn_table5 = findViewById(R.id.btn_table5);
        btn_table6 = findViewById(R.id.btn_table6);
        btn_table7 = findViewById(R.id.btn_table7);
        btn_table8 = findViewById(R.id.btn_table8);
        btn_table9 = findViewById(R.id.btn_table9);
        btn_table10 = findViewById(R.id.btn_table10);
        btn_table11 = findViewById(R.id.btn_table11);
        btn_table12 = findViewById(R.id.btn_table12);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String buttonText = button.getText().toString();

                Intent intenttbl = new Intent(Chonban.this, MenuFirstActivity.class);
                intenttbl.putExtra("button_text", buttonText);
                startActivity(intenttbl);
            }
        };
        btn_table1.setOnClickListener(listener);
        btn_table2.setOnClickListener(listener);
        btn_table3.setOnClickListener(listener);
        btn_table4.setOnClickListener(listener);
        btn_table5.setOnClickListener(listener);
        btn_table6.setOnClickListener(listener);
        btn_table7.setOnClickListener(listener);
        btn_table8.setOnClickListener(listener);
        btn_table9.setOnClickListener(listener);
        btn_table10.setOnClickListener(listener);
        btn_table11.setOnClickListener(listener);
        btn_table12.setOnClickListener(listener);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}