package com.example.btlandroidcb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuFirstActivity extends AppCompatActivity {
  TextView txttable;
  ImageButton btnReturn, btnPlus;
  Button  btnPhobien, btnKhaivi, btnMonchinh, btnDouong;
  RecyclerView rcvfood;
  FoodAdapter myAdapter;
  List<Food> mListFoodPhobien, mListFoodKhaivi, mListFoodMonchinh, mListFoodDouong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_first);
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void initControl () {
        txttable = findViewById(R.id.txttable);
        String buttonText = getIntent().getStringExtra("button_text");
        txttable.setText(buttonText);

        btnPhobien = findViewById(R.id.btn_phobien);
        btnKhaivi = findViewById(R.id.btn_khaivi);
        btnMonchinh = findViewById(R.id.btn_monchinh);
        btnDouong = findViewById(R.id.btn_douong);

        rcvfood = findViewById(R.id.rcv_food);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvfood.setLayoutManager(gridLayoutManager);

        mListFoodPhobien = new ArrayList<>();
        mListFoodPhobien .add(new Food(R.drawable.cafe_1, "Cafe nâu đá", 12000));
        mListFoodPhobien .add(new Food(R.drawable.bunbohue_1, "Bún bò Huế",60000 ));
        mListFoodPhobien .add(new Food(R.drawable.ech_1, "Thịt ếch xào xả ớt", 85000));
        mListFoodPhobien .add(new Food(R.drawable.salad_1, "Salad rau trộn", 45000));
        mListFoodPhobien .add(new Food(R.drawable.sup_1, "Súp cua", 20000));
        mListFoodPhobien .add(new Food(R.drawable.tradao_1, "Trà đào cam xả", 25000));
        mListFoodPhobien .add(new Food(R.drawable.tramanhn_1, "Trà mận Hà Nội", 35000));
        mListFoodPhobien .add(new Food(R.drawable.vitquay_1, "Vịt quay Bắc Giang", 115000));
        mListFoodPhobien .add(new Food(R.drawable.botaichanh_1, "Bò tái chanh", 96000));
        mListFoodPhobien .add(new Food(R.drawable.dauhuhaisan_1, "Đậu hủ hải sản", 52000));
        mListFoodPhobien .add(new Food(R.drawable.khoaitaychien, "Khoai tây chiên", 35000));
        mListFoodPhobien .add(new Food(R.drawable.goixoaikhocaloc, "Gỏi xoài khô cá lóc", 245000));
        mListFoodPhobien .add(new Food(R.drawable.supbaongu, "Súp bào ngư", 75000));
        mListFoodPhobien.add(new Food(R.drawable.suphaisan, "Súp hải sản", 85000));
        mListFoodPhobien .add(new Food(R.drawable.comga_1, "Cơm gà xối mỡ", 65000));
        mListFoodPhobien.add(new Food(R.drawable.comrang_1, "Cơm rang dưa bò", 45000));
        mListFoodPhobien .add(new Food(R.drawable.mixao_1, "Mì xào hải sản", 65000));
        mListFoodPhobien.add(new Food(R.drawable.phoga_1, "Phở gà ", 65000));
        mListFoodPhobien .add(new Food(R.drawable.traatiso_1, "Trà atiso", 50000));
        mListFoodPhobien .add(new Food(R.drawable.trachanh_1, "Trà chanh", 10000));

        mListFoodKhaivi = new ArrayList<>();
        mListFoodKhaivi.add(new Food(R.drawable.boxaohanh, "Bò xào hành", 88000 ));
        mListFoodKhaivi.add(new Food(R.drawable.boxaoxaot, "Bò xào xả ớt",82000 ));
        mListFoodKhaivi.add(new Food(R.drawable.echchienbo, "Ếch chiên bơ",   113000));
        mListFoodKhaivi.add(new Food(R.drawable.camaichien, "Cá mai chiên", 165000));
        mListFoodKhaivi.add(new Food(R.drawable.echchienlalot, "Ếch chiên lá lốt", 189000));
        mListFoodKhaivi.add(new Food(R.drawable.echxaocuchuoi, "Ếch xào củ chuối",  124000));
        mListFoodKhaivi.add(new Food(R.drawable.goicamai, "Gỏi cá mai", 67000));
        mListFoodKhaivi.add(new Food(R.drawable.khoailangken, "Khoai lang kén", 34000));
        mListFoodKhaivi.add(new Food(R.drawable.luonxaolan, "Lươn xào lăn", 89000 ));
        mListFoodKhaivi.add(new Food(R.drawable.luonxaoxaot, "Lươn xào xả ớt", 105000));
        mListFoodKhaivi.add(new Food(R.drawable.muopdangruoc, "Mướp đắng ruốc", 30000));
        mListFoodKhaivi.add(new Food(R.drawable.muopdangxaotrung, "Mướp đắng xào trứng", 35000));
        mListFoodKhaivi.add(new Food(R.drawable.ngaohap, "Ngao hấp", 45000));
        mListFoodKhaivi.add(new Food(R.drawable.ochuongxaobotoi, "Ốc hương xào bơ tỏi",43000 ));
        mListFoodKhaivi.add(new Food(R.drawable.raumuongxao, "Rau muống xào", 25000));
        mListFoodKhaivi.add(new Food(R.drawable.botaichanh_1, "Bò tái chanh", 92000));
        mListFoodKhaivi.add(new Food(R.drawable.goixoaikhocaloc, "Gỏi xoài khô cá lóc",69000 ));
        mListFoodKhaivi.add(new Food(R.drawable.salad_1, "Salad rau trộn", 54000 ));
        mListFoodKhaivi.add(new Food(R.drawable.khoaitaychien, "Khoai tây chiên", 35000 ));
        mListFoodKhaivi.add(new Food(R.drawable.supbaongu, "Súp bào ngư", 69000));

        mListFoodMonchinh = new ArrayList<>();
        mListFoodMonchinh.add(new Food(R.drawable.canhgachienmam, "Cánh gà chiên mắm", 80000));
        mListFoodMonchinh.add(new Food(R.drawable.boluclac, "Bò lúc lắc khoai tây", 45000));
        mListFoodMonchinh.add(new Food(R.drawable.cachienlaque, "Chả cá chiên lá quế", 30000));
        mListFoodMonchinh.add(new Food(R.drawable.bachichien, "Ba chỉ chiên giòn",35000 ));
        mListFoodMonchinh.add(new Food(R.drawable.sungarang, "Sụn gà rang muối Hồng Kông", 63000));
        mListFoodMonchinh.add(new Food(R.drawable.cadieuhongxot, "Cá diêu hồng sốt cà chua", 73000));
        mListFoodMonchinh.add(new Food(R.drawable.goixoaibachtuoc, "Gỏi xoài bạch tuộc",123000 ));
        mListFoodMonchinh.add(new Food(R.drawable.mucsotpayttaya, "Mực sốt Pattaya", 55000));
        mListFoodMonchinh.add(new Food(R.drawable.ganuongnguvi, "Gà nướng ngũ vị",93000 ));
        mListFoodMonchinh.add(new Food(R.drawable.chagiohaisan, "Chả giò hải sản", 72000));
        mListFoodMonchinh.add(new Food(R.drawable.baonguchaytoi, "Bào ngư cháy tỏi",176000 ));
        mListFoodMonchinh.add(new Food(R.drawable.tomphuonghoang, "Tôm phượng hoàng", 220000));
        mListFoodMonchinh.add(new Food(R.drawable.baotuxot, "Bao tử xốt phá lấu",91000 ));
        mListFoodMonchinh.add(new Food(R.drawable.combachibo, "Cơm ba chỉ bò", 65000));
        mListFoodMonchinh.add(new Food(R.drawable.comga_1, "Cơm gà",65000 ));
        mListFoodMonchinh.add(new Food(R.drawable.luoncuonthit, "Lươn cuốn thịt", 99000));
        mListFoodMonchinh.add(new Food(R.drawable.bunluttron, "Bún gạo lứt trộn",37000 ));
        mListFoodMonchinh.add(new Food(R.drawable.nomsua, "Nộm sứa kiểu thái",88000 ));
        mListFoodMonchinh.add(new Food(R.drawable.dauhuhaisan_1, "Đậu hủ hải sản", 52000));
        mListFoodMonchinh.add(new Food(R.drawable.echchienlalot, "Ếch chiên lá lốt", 189000));

        mListFoodDouong = new ArrayList<>();
        mListFoodDouong.add(new Food(R.drawable.trachanh_1, "Trà chanh", 10000 ));
        mListFoodDouong.add(new Food(R.drawable.travai, "Trà vải", 50000));
        mListFoodDouong.add(new Food(R.drawable.coca, "Coca Cola",15000 ));
        mListFoodDouong.add(new Food(R.drawable.sevenup, "7 Up",15000 ));
        mListFoodDouong.add(new Food(R.drawable.tradao_1, "Trà đào cam xả", 45000));
        mListFoodDouong.add(new Food(R.drawable.sinhtobo, "Sinh tố bơ", 47000));
        mListFoodDouong.add(new Food(R.drawable.sinhtoxoai, "Sinh tố xoài", 47000));
        mListFoodDouong.add(new Food(R.drawable.eptao, "Nước ép táo", 35000));
        mListFoodDouong.add(new Food(R.drawable.epcam, "Nước ép cam", 35000));
        mListFoodDouong.add(new Food(R.drawable.tramanhn_1, "Trà mận Hà Nội",40000 ));
        mListFoodDouong.add(new Food(R.drawable.epluu, "Nước ép lựu", 35000));
        mListFoodDouong.add(new Food(R.drawable.cantay, "Nước cần tây", 45000));
        mListFoodDouong.add(new Food(R.drawable.traatiso_1, "Trà Atiso",40000 ));
        mListFoodDouong.add(new Food(R.drawable.epcoc, "Nước ép cóc",35000 ));
        mListFoodDouong.add(new Food(R.drawable.epoi, "Nước ép ổi",35000 ));
        mListFoodDouong.add(new Food(R.drawable.sinhtomangcau, "Sinh tố mãng cầu",47000 ));

         myAdapter = new FoodAdapter( mListFoodPhobien );
        rcvfood.setAdapter(myAdapter);

       selectButton(btnPhobien, mListFoodPhobien);

        btnPhobien.setOnClickListener(view -> selectButton(btnPhobien, mListFoodPhobien));
        btnKhaivi.setOnClickListener(view -> selectButton(btnKhaivi, mListFoodKhaivi));
        btnMonchinh.setOnClickListener(view -> selectButton(btnMonchinh, mListFoodMonchinh));
        btnDouong.setOnClickListener(view -> selectButton(btnDouong, mListFoodDouong));

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    // Hàm cập nhật RecyclerView và viền cho nút được chọn
    private void selectButton(Button selectedButton, List<Food> foodlist) {
        // Xóa background cho tất cả các nút
        btnPhobien.setBackgroundResource(R.drawable.button_menu_mon);
        btnKhaivi.setBackgroundResource(R.drawable.button_menu_mon);
        btnMonchinh.setBackgroundResource(R.drawable.button_menu_mon);
        btnDouong.setBackgroundResource(R.drawable.button_menu_mon);

        // Đặt background nổi bật cho nút được chọn
        selectedButton.setBackgroundResource(R.drawable.button_menu_mon_selected);
        updateRecyclerView(foodlist);
    }
    // Hàm cập nhật RecyclerView với danh sách mới
    public void updateRecyclerView(List<Food> newList) {
        myAdapter.setData(newList);
        myAdapter.notifyDataSetChanged();
    }

    }

