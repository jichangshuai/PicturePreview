package com.wjruiying.galleryviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE;

public class MainActivity extends AppCompatActivity {

    private static Integer[] source = new Integer[]{
            1,2,3,4,5,6,7,8,9,10
    };
//
//    private ImageView preview_image;
//
//    private RecyclerView scroll_view;
//    private List<Integer> data;
//
//    private int currentPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        findViewById();
    }

//    private void findViewById(){
//        preview_image = findViewById(R.id.preview_image);
//
//        scroll_view = findViewById(R.id.scroll_view);
//        /**
//         * 数据源
//         */
//        data = Arrays.asList(source);
//        /**
//         * 管理器
//         */
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
//        /**
//         * 绑定列表管理器
//         */
//        scroll_view.setLayoutManager(linearLayoutManager);
//        scroll_view.setAdapter(new GalleryListAdapter(this, data, this::getPos));
//        scroll_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
//                if(newState == SCROLL_STATE_IDLE){
//                    Log.e("TAG", manager.getItemCount()+"");
//                    if(currentPos == 1){
//                        Glide.with(MainActivity.this).load(R.mipmap.box_tick).into(preview_image);
//                    } else if(currentPos == 2){
//                        Glide.with(MainActivity.this).load(R.mipmap.close_icon).into(preview_image);
//                    } else if(currentPos == 3){
//                        Glide.with(MainActivity.this).load(R.mipmap.domain_account_icon).into(preview_image);
//                    } else if(currentPos == 4){
//                        Glide.with(MainActivity.this).load(R.mipmap.ic_launcher).into(preview_image);
//                    } else if(currentPos == 5){
//                        Glide.with(MainActivity.this).load(R.mipmap.phone_icon).into(preview_image);
//                    } else if(currentPos == 6){
//                        Glide.with(MainActivity.this).load(R.mipmap.validation_number_icon).into(preview_image);
//                    } else if(currentPos == 7){
//                        Glide.with(MainActivity.this).load(R.mipmap.logo).into(preview_image);
//                    } else if(currentPos == 8){
//                        Glide.with(MainActivity.this).load(R.mipmap.signing_icon).into(preview_image);
//                    } else if(currentPos == 9){
//                        Glide.with(MainActivity.this).load(R.mipmap.signing_header).into(preview_image);
//                    } else if(currentPos == 10){
//                        Glide.with(MainActivity.this).load(R.mipmap.search_icon).into(preview_image);
//                    }
//                }
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//                if (layoutManager instanceof LinearLayoutManager){
//                    LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
//                    int firstVisibleItem = manager.findFirstVisibleItemPosition();
//                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
//                    int lastItemPosition = firstVisibleItem+(lastVisibleItem-firstVisibleItem)+1;
//                    currentPos = firstVisibleItem + 1;
//                    Log.e("TAG-scroll-firstVisibleItem", (firstVisibleItem + 1)+"");
//                }
//                if(dx < 0){//从左向右滑
//
//                }
//                Log.e("TAG", "dx="+dx+",dy="+dy);
//            }
//        });
//    }

//    @Override
//    public void getPos(int position) {
//        if(position == 1){
//            Glide.with(MainActivity.this).load(R.mipmap.box_tick).into(preview_image);
//        } else if(position == 2){
//            Glide.with(MainActivity.this).load(R.mipmap.close_icon).into(preview_image);
//        } else if(position == 3){
//            Glide.with(MainActivity.this).load(R.mipmap.domain_account_icon).into(preview_image);
//        } else if(position == 4){
//            Glide.with(MainActivity.this).load(R.mipmap.ic_launcher).into(preview_image);
//        } else if(position == 5){
//            Glide.with(MainActivity.this).load(R.mipmap.phone_icon).into(preview_image);
//        } else if(position == 6){
//            Glide.with(MainActivity.this).load(R.mipmap.validation_number_icon).into(preview_image);
//        } else if(position == 7){
//            Glide.with(MainActivity.this).load(R.mipmap.logo).into(preview_image);
//        } else if(position == 8){
//            Glide.with(MainActivity.this).load(R.mipmap.signing_icon).into(preview_image);
//        } else if(position == 9){
//            Glide.with(MainActivity.this).load(R.mipmap.signing_header).into(preview_image);
//        } else if(position == 10){
//            Glide.with(MainActivity.this).load(R.mipmap.search_icon).into(preview_image);
//        }
//    }
}