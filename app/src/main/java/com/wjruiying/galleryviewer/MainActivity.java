package com.wjruiying.galleryviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static String[] source = new String[]{
            "https://ilearningtmp.fairyclass.cn/109b17e56a0c43c0960acf08fdceba21.png",
            "https://ilearningtmp.fairyclass.cn/03010465ac15469b95bb359b57041bd3.png",
            "https://ilearningtmp.fairyclass.cn/04dab28c5e844988b6c39530eac68eb4.png",
            "https://ilearningtmp.fairyclass.cn/0549fcb3796342708695fa68bb54404c.png",
            "https://ilearningtmp.fairyclass.cn/0707c130d5fa40e5b15e89ad706e85f2.png",
            "https://ilearningtmp.fairyclass.cn/083f5772af4a49858d3c7546d8731282.png",
            "https://ilearningtmp.fairyclass.cn/0f622413ff904c448804e8063c4f49ab.png",
            "https://ilearningtmp.fairyclass.cn/0f761b100200447180e2b5e0acfa9468.png",
            "https://ilearningtmp.fairyclass.cn/1b668bd50caa4717b88523a6764d6660.png",
            "https://ilearningtmp.fairyclass.cn/1b7298c7542f4f3f8b11385e6a72d370.png",
            "https://ilearningtmp.fairyclass.cn/1cf484b94c5140fab2339f9669687116.png",
            "https://ilearningtmp.fairyclass.cn/1e2c825bb84343a99b5e4731a7ef7441.png",
            "https://ilearningtmp.fairyclass.cn/1d72e27d0ac9474d95172e2b2672fb75.png",
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