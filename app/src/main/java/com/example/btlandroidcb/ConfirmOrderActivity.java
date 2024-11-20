package com.example.btlandroidcb;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ConfirmOrderActivity extends AppCompatActivity {
      ListView lvConfirm;
      TextView tvTotalPriceConfirm;
      List<Food> listfood;
      OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirm_order);
         lvConfirm = findViewById(R.id.lvConfirm);
         tvTotalPriceConfirm = findViewById(R.id.tvTotalPriceConfirm);
         // Nhận danh sách Food từ Intent
         listfood = getIntent().getParcelableArrayListExtra("foodlist");
         int totalPrice = getIntent().getIntExtra("totalprice", 0);
        // Thiết lập adapter
         orderAdapter = new OrderAdapter(this, listfood);
         lvConfirm.setAdapter(orderAdapter);

        NumberFormat formatter = NumberFormat.getInstance();
        tvTotalPriceConfirm.setText("Tổng giá: " + formatter.format(totalPrice)  + " VNĐ");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}