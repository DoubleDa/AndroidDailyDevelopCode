package com.dyx.rosd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    private LinearLayoutManager mLinearLayoutManager;
    /**
     * 是否正在加载
     */
    private boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        isScrollBottom();
    }

    private void isScrollBottom() {
        /**
         * 方法一：第一个可见item的位置 + 当前可见的item个数 >= item的总个数
         */
        methodFirst();
        /**
         * 方法二
         */
        methodSecond();
    }

    private void methodSecond() {
        rvMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!isLoading && recyclerView.canScrollVertically(1)) {
                    isLoading = true;
                    loadMoreData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void methodFirst() {
        rvMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    //可见条目数目
                    int visibleItemCount = mLinearLayoutManager.getChildCount();
                    //总共条目数目
                    int totalItemCount = mLinearLayoutManager.getItemCount();
                    //第一个可见的条目位置
                    int firstVisibleItemPos = mLinearLayoutManager.findFirstVisibleItemPosition();
                    if (!isLoading && (firstVisibleItemPos + visibleItemCount) >= totalItemCount) {
                        isLoading = true;
                        /**
                         * 加载更多
                         */
                        loadMoreData();
                    }
                }
            }
        });
    }

    private void loadMoreData() {

    }

    private void initView() {
        /**
         * 初始化RecyclerView
         */
        mLinearLayoutManager = new LinearLayoutManager(this);
        rvMain.setLayoutManager(mLinearLayoutManager);
        rvMain.setHasFixedSize(true);
        /**
         * 添加监听事件(已失效)
         */
        rvMain.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        /**
         * 添加监听事件
         */
        rvMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                /**
                 * 滚动状态变化时回调
                 */
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        /**
                         * 静止没有滚动
                         */
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        /**
                         * 正在被外部拖拽,一般为用户正在用手指滚动
                         */
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        /**
                         * 自动滚动
                         */
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                /**
                 * 滚动时回调
                 * dx:水平滑动距离
                 * dy:垂直滑动距离
                 */

            }
        });
        /**
         * 是否可以在水平或者垂直方向滑动(1,-1)
         */
        //可向左滑动
        rvMain.canScrollHorizontally(1);
        //可向右滑动
        rvMain.canScrollHorizontally(-1);
        //可向上滑动
        rvMain.canScrollVertically(1);
        //可向下滑动
        rvMain.canScrollVertically(-1);
    }
}
