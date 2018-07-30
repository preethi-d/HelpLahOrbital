package com.example.preethidevarajan.helplahorbital;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    public String email;
    public String username;

    public User() {

    }


    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

    protected User(Parcel in) {
        email = in.readString();
        username = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //write objects values to parcel for storage
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(username);
    }
}
