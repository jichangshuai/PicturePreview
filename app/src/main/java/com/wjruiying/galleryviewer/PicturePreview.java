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

import java.util.ArrayList;
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
    private DataSource dataSource;

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

    private ImageView preview_image;
    private RecyclerView scroll_view;
    private int currentPos = 0;
//    private List<Integer> data = new ArrayList<>();

    private GalleryListAdapter adapter;

    private OnDataSourceListener onDataSourceListener;

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
//        data = Arrays.asList(source);
        /**
         * 管理器
         */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        /**
         * 绑定列表管理器
         */
        scroll_view.setLayoutManager(linearLayoutManager);
//        scroll_view.setAdapter(new GalleryListAdapter(context, data, this));
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
        Glide.with(context).load(dataSource.getData().get(position)).into(preview_image);
    }

    public void setDataSource(List<String> data){
        if(dataSource == null){
            dataSource = new DataSource();
        }
        dataSource.setData(data);
        adapter = new GalleryListAdapter(context, dataSource.getData(), this);
        scroll_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
