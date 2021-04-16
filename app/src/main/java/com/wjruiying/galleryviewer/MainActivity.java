package com.wjruiying.galleryviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static Integer[] source = new Integer[]{
            1,2,3,4,5,6,7,8,9,10
    };

    private PicturePreview picturePreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        picturePreview = findViewById(R.id.picture_preview);
//        picturePreview.setDataSource(Arrays.asList(source));
    }
}