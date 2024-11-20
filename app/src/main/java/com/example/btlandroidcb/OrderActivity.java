package com.example.btlandroidcb;

import static android.widget.Toast.*;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
   ImageButton btn_back;
   ListView lv_item_order;
   TextView tvTotal;
   Button btnComfirm;
    OrderAdapter orderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        btn_back = findViewById(R.id.btnBack);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        lv_item_order = findViewById(R.id.lvItemOrder);
        tvTotal = findViewById(R.id.tvTotal);
        ArrayList<Food> selectedFoods = getIntent().getParcelableArrayListExtra("selectedFoods");

        if(selectedFoods != null) {
            orderAdapter = new OrderAdapter(this, selectedFoods);
            lv_item_order.setAdapter(orderAdapter);

            int totalPrice = orderAdapter.calculateTotalPrice();
            NumberFormat formatter = NumberFormat.getInstance();
            tvTotal.setText("Tổng giá: " + formatter.format(totalPrice)  + " VNĐ");
        }
         btnComfirm = findViewById(R.id.btnConfirm);
        btnComfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderActivity.this, "Gọi món thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OrderActivity.this, ConfirmOrderActivity.class);
                intent.putParcelableArrayListExtra("foodlist", new ArrayList<>(selectedFoods));
                intent.putExtra("totalprice",orderAdapter.calculateTotalPrice());
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}