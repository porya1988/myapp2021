package com.example.myapp2021.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private String buy;
    private String amount;


    protected Note(Parcel in) {
        buy = in.readString();
        amount = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(buy);
        dest.writeString(amount);
    }
}
