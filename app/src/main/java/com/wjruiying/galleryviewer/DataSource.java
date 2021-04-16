package com.wjruiying.galleryviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author changshuaiji
 * @description <p> data source </P>
 * @date 2021/4/15
 */
public class DataSource implements Parcelable {

    private List<String> data;

    public DataSource() {
    }

    protected DataSource(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataSource> CREATOR = new Creator<DataSource>() {
        @Override
        public DataSource createFromParcel(Parcel in) {
            return new DataSource(in);
        }

        @Override
        public DataSource[] newArray(int size) {
            return new DataSource[size];
        }
    };

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
