package com.wjruiying.galleryviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE;

/**
 * @author changshuaiji
 * @description <p> picture preview </P>
 * @date 2021/4/15
 */
public class PicturePreview extends LinearLayout implements MainView {

    private Context context;
    private DataSource dataSource;

    private ImageView preview_image;
    private RecyclerView scroll_view;
    private int currentPos = 0;

    private FrameLayout preview_fl;
    private ZoomImageView preview_image_view;
    private ImageButton back_to_normal;
    /**是否有预览功能**/
    private boolean hasPreview = false;

    private GalleryListAdapter adapter;

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
        preview_image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasPreview){
                    Glide.with(context).load(dataSource.getData().get(currentPos)).into(preview_image_view);
                    preview_fl.setVisibility(VISIBLE);
                }
            }
        });
        scroll_view = view.findViewById(R.id.scroll_view);
        /**
         * 管理器
         */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        /**
         * 绑定列表管理器
         */
        scroll_view.setLayoutManager(linearLayoutManager);
        scroll_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == SCROLL_STATE_IDLE){
                    LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    Log.e("TAG", manager.getItemCount()+"");
                    Glide.with(context).load(dataSource.getData().get(currentPos)).into(preview_image);
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
                    currentPos = firstVisibleItem;
//                    Log.e("TAG-scroll-firstVisibleItem", (firstVisibleItem)+"");
                }
                if(dx < 0){//从左向右滑

                }
                Log.e("TAG", "dx="+dx+",dy="+dy);
            }
        });

        preview_fl = view.findViewById(R.id.preview_fl);
//        preview_fl.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                preview_fl.setVisibility(GONE);
//                adapter.notifyDataSetChanged();
//            }
//        });
        preview_fl.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
                preview_fl.setVisibility(GONE);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        preview_image_view = view.findViewById(R.id.preview_image_view);
        back_to_normal = view.findViewById(R.id.back_to_normal);
        back_to_normal.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                preview_fl.setVisibility(GONE);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    public void getPos(int position) {
        currentPos = position;
        Glide.with(context).load(dataSource.getData().get(position)).into(preview_image);
    }

    @Override
    public void getFirstData(List<String> dataSource) {
        if(dataSource != null && dataSource.size() > 0){
            Glide.with(context).load(dataSource.get(0)).into(preview_image);
        }
    }

    public void setDataSource(List<String> data){
        if(dataSource == null){
            dataSource = new DataSource();
        }
        getFirstData(data);
        dataSource.setData(data);
        adapter = new GalleryListAdapter(context, dataSource.getData(), this);
        scroll_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
