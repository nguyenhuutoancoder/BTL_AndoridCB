package com.example.btlandroidcb;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {

    private int image;
    private String name;
    private int price;
    private int quantity;

    public Food(int image, String name, int price) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }
    protected Food(Parcel in) {
        image = in.readInt();
        name = in.readString();
        price = in.readInt();
        quantity = in.readInt();
    }
    public static final Parcelable.Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeInt(quantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}
