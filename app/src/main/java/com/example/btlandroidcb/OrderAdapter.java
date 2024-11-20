package com.example.btlandroidcb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

public class OrderAdapter extends BaseAdapter {
    private Context context;
    private List<Food> foodList;

    public OrderAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false);
        }
        Food food = foodList.get(position);

        ImageView imgFood = convertView.findViewById(R.id.imgFood);
        TextView tvName = convertView.findViewById(R.id.tv_food_name);
        TextView tvTotalPrice = convertView.findViewById(R.id.tv_total_price);
        TextView tvQuantity = convertView.findViewById(R.id.tv_quantity);

        imgFood.setImageResource(food.getImage());
        tvName.setText(food.getName());
        tvQuantity.setText(String.valueOf("x" + food.getQuantity()));
        NumberFormat formatter = NumberFormat.getInstance();
        tvTotalPrice.setText(String.valueOf(formatter.format(food.getPrice() * food.getQuantity())) + "đ");
        return convertView;
    }
    public int calculateTotalPrice() {
        int total = 0;
        for (Food food : foodList) {
            total += food.getPrice() * food.getQuantity();
        }
        return total;
    }

}
