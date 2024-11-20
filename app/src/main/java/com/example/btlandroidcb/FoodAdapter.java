package com.example.btlandroidcb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;

public class FoodAdapter extends  RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

  private List<Food> mListFood;

    public FoodAdapter(List<Food> mListFood) {
        this.mListFood = mListFood;
    }

    public void setData(List<Food> newList) {
     this.mListFood = newList;
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
    Food food = mListFood.get(position);
    if (food == null) {
        return;
    }

    holder.imgFood.setImageResource(food.getImage());
    holder.tvNameFood.setText(food.getName());
    NumberFormat formatter = NumberFormat.getInstance();
    holder.tvPrice.setText(String.valueOf(formatter.format(food.getPrice())+ "đ"));
    holder.tvQuantity.setText(String.valueOf(food.getQuantity()));
        // Kiểm tra số lượng để hiển thị/ẩn btnMinus và tvQuantity
        if(food.getQuantity()>0) {
            holder.tvQuantity.setVisibility(View.VISIBLE);
            holder.btnMins.setVisibility(View.VISIBLE);
        }
        else {
            holder.tvQuantity.setVisibility(View.GONE);
            holder.btnMins.setVisibility(View.GONE);
        }
        // Xử lý sự kiện cho btnPlus
        holder.btnPlus.setOnClickListener(view -> {
            food.setQuantity(food.getQuantity() + 1); // Tăng số lượng
            holder.tvQuantity.setText(String.valueOf(food.getQuantity()));
            notifyItemChanged(position);  // Cập nhật giao diện
        });
        holder.btnMins.setOnClickListener(view -> {
            if(food.getQuantity()>0) {
                food.setQuantity(food.getQuantity() - 1); // Giảm số lượng
                holder.tvQuantity.setText(String.valueOf(food.getQuantity()));
                notifyItemChanged(position);  // Cập nhật giao diện
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mListFood != null) {
            return mListFood.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFood;
        private TextView tvNameFood,tvPrice, tvQuantity;
        private ImageButton btnMins, btnPlus;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFood = itemView.findViewById(R.id.img_food);
            tvNameFood = itemView.findViewById(R.id.tv_name_food);
            tvPrice = itemView.findViewById(R.id.tv_price);
            btnMins = itemView.findViewById(R.id.btnMins);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            btnPlus = itemView.findViewById(R.id.btnPlus);
        }
    }
}
