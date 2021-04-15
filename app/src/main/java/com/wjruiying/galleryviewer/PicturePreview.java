package com.wjruiying.galleryviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE;

/**
 * @author changshuaiji
 * @description <p> picture preview </P>
 * @date 2021/4/15
 */
public class PicturePreview extends LinearLayout implements MainView {

    private Context context;

    private static Integer[] source = new Integer[]{
            1,2,3,4,5,6,7,8,9,10
    };

    private ImageView preview_image;
    private RecyclerView scroll_view;
    private int currentPos = 0;
    private List<Integer> data;

    public PicturePreview(Context context) {
        super(context);
        initView(context);
    }

    public PicturePreview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PicturePreview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        this.context = context;
        View view = LayoutInflater.from(context)
                .inflate(R.layout.picture_preview_layout, this, false);
        this.addView(view);
        preview_image = view.findViewById(R.id.preview_image);
        scroll_view = view.findViewById(R.id.scroll_view);
        /**
         * 数据源
         */
        data = Arrays.asList(source);
        /**
         * 管理器
         */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        /**
         * 绑定列表管理器
         */
        scroll_view.setLayoutManager(linearLayoutManager);
        scroll_view.setAdapter(new GalleryListAdapter(context, data, this));
        scroll_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == SCROLL_STATE_IDLE){
                    LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    Log.e("TAG", manager.getItemCount()+"");
                    if(currentPos == 1){
                        Glide.with(context).load(R.mipmap.box_tick).into(preview_image);
                    } else if(currentPos == 2){
                        Glide.with(context).load(R.mipmap.close_icon).into(preview_image);
                    } else if(currentPos == 3){
                        Glide.with(context).load(R.mipmap.domain_account_icon).into(preview_image);
                    } else if(currentPos == 4){
                        Glide.with(context).load(R.mipmap.ic_launcher).into(preview_image);
                    } else if(currentPos == 5){
                        Glide.with(context).load(R.mipmap.phone_icon).into(preview_image);
                    } else if(currentPos == 6){
                        Glide.with(context).load(R.mipmap.validation_number_icon).into(preview_image);
                    } else if(currentPos == 7){
                        Glide.with(context).load(R.mipmap.logo).into(preview_image);
                    } else if(currentPos == 8){
                        Glide.with(context).load(R.mipmap.signing_icon).into(preview_image);
                    } else if(currentPos == 9){
                        Glide.with(context).load(R.mipmap.signing_header).into(preview_image);
                    } else if(currentPos == 10){
                        Glide.with(context).load(R.mipmap.search_icon).into(preview_image);
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager){
                    LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
                    int firstVisibleItem = manager.findFirstVisibleItemPosition();
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int lastItemPosition = firstVisibleItem+(lastVisibleItem-firstVisibleItem)+1;
                    currentPos = firstVisibleItem + 1;
                    Log.e("TAG-scroll-firstVisibleItem", (firstVisibleItem + 1)+"");
                }
                if(dx < 0){//从左向右滑

                }
                Log.e("TAG", "dx="+dx+",dy="+dy);
            }
        });
    }

    @Override
    public void getPos(int position) {
        if(position == 1){
            Glide.with(context).load(R.mipmap.box_tick).into(preview_image);
        } else if(position == 2){
            Glide.with(context).load(R.mipmap.close_icon).into(preview_image);
        } else if(position == 3){
            Glide.with(context).load(R.mipmap.domain_account_icon).into(preview_image);
        } else if(position == 4){
            Glide.with(context).load(R.mipmap.ic_launcher).into(preview_image);
        } else if(position == 5){
            Glide.with(context).load(R.mipmap.phone_icon).into(preview_image);
        } else if(position == 6){
            Glide.with(context).load(R.mipmap.validation_number_icon).into(preview_image);
        } else if(position == 7){
            Glide.with(context).load(R.mipmap.logo).into(preview_image);
        } else if(position == 8){
            Glide.with(context).load(R.mipmap.signing_icon).into(preview_image);
        } else if(position == 9){
            Glide.with(context).load(R.mipmap.signing_header).into(preview_image);
        } else if(position == 10){
            Glide.with(context).load(R.mipmap.search_icon).into(preview_image);
        }
    }

    @Override
    public void setDataSource(List<Integer> dataSource) {
//        data = dataSource;
    }
}
