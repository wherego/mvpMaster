package mvpmaster.lht.com.lht.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvpmaster.lht.com.lht.R;
import mvpmaster.lht.com.lht.ui.activity.zhihudetail.ZhiHuDetailActivity;
import mvpmaster.lht.com.lht.ui.beanIml.NewsTimeLine;
import mvpmaster.lht.com.lht.ui.weight.TopStoriesViewPager;
import mvpmaster.lht.com.lht.utils.ScreenUtil;

/**
 * Created by Ly on 2016/11/2.
 */

public class ZhiHuAdapter extends RecyclerView.Adapter {
    private Context context;
    private NewsTimeLine newsTimeLine = new NewsTimeLine();

    private int status = 1;
    private final int LOAD_MORE = 0;
    private final int LOAD_PULL_TO = 1;
    private final int LOAD_NONE = 2;
    private final int LOAD_END = 3;
    private final int LOAD_FAILURE = 4;
    private final int TYPE_TOP = -1;
    private final int TYPE_FOOTER = -2;

    public ZhiHuAdapter(Context context) {
        this.context = context;
    }

    public void addData(NewsTimeLine newsTimeLine) {
        this.newsTimeLine.getStories().addAll(newsTimeLine.getStories());
        this.newsTimeLine.setDate(newsTimeLine.getDate());
        notifyDataSetChanged();
    }

    public void resetData(NewsTimeLine newsTimeLine) {
        this.newsTimeLine = newsTimeLine;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (newsTimeLine != null) {
            if (newsTimeLine.getTop_stories() != null) {
                if (position == 0) {
                    return TYPE_TOP;
                } else if (position + 1 == getItemCount()) {
                    return TYPE_FOOTER;
                } else {
                    return position;
                }
            } else if (position + 1 == getItemCount()) {
                return TYPE_FOOTER;
            } else {
                return position;
            }
        }
        return position;
    }

    /**
     * 开启轮播
     *
     * @param holder
     */
    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        if (holder instanceof TopStoriesViewHolder) {
            TopStoriesViewHolder topStoriesViewHolder = (TopStoriesViewHolder) holder;
            topStoriesViewHolder.vp_top_stories.startAutoRun();
        }
    }

    /**
     * 关闭轮播
     *
     * @param holder
     */
    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        if (holder instanceof TopStoriesViewHolder) {
            TopStoriesViewHolder topStoriesViewHolder = (TopStoriesViewHolder) holder;
            topStoriesViewHolder.vp_top_stories.stopAutoRun();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TOP) {
            View rootView = View.inflate(parent.getContext(), R.layout.item_zhihu_top_stories, null);
            return new TopStoriesViewHolder(rootView);
        } else if (viewType == TYPE_FOOTER) {
            View view = View.inflate(parent.getContext(), R.layout.activity_view_footer, null);
            return new FooterViewHolder(view);
        } else {
            View rootView = View.inflate(parent.getContext(), R.layout.item_zhihu_stories, null);
            return new StoriesViewHolder(rootView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            footerViewHolder.bindItem();
        } else if (holder instanceof TopStoriesViewHolder) {
            TopStoriesViewHolder topStoriesViewHolder = (TopStoriesViewHolder) holder;
            if (newsTimeLine != null && newsTimeLine.getTop_stories() != null)
                topStoriesViewHolder.bindItem(newsTimeLine.getTop_stories());
        } else if (holder instanceof StoriesViewHolder) {
            StoriesViewHolder storiesViewHolder = (StoriesViewHolder) holder;
            if (newsTimeLine != null && newsTimeLine.getStories() != null)
                storiesViewHolder.bindItem(newsTimeLine.getStories().get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return null == newsTimeLine.getStories() ? 2 : newsTimeLine.getStories().size() + 2;
    }

    // change recycler state
    public void updateLoadStatus(int status) {
        this.status = status;
        notifyDataSetChanged();
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_load_prompt)
        TextView tv_load_prompt;
        @Bind(R.id.progress)
        ProgressBar progress;

        public FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtil.instance(context).dip2px(40));
            itemView.setLayoutParams(params);
        }

        private void bindItem() {
            switch (status) {
                case LOAD_MORE:
                    progress.setVisibility(View.VISIBLE);
                    tv_load_prompt.setText("正在加载...");
                    itemView.setVisibility(View.VISIBLE);
                    break;
                case LOAD_PULL_TO:
                    progress.setVisibility(View.GONE);
                    tv_load_prompt.setText("上拉加载更多");
                    itemView.setVisibility(View.VISIBLE);
                    break;
                case LOAD_NONE:
                    System.out.println("LOAD_NONE----");
                    progress.setVisibility(View.GONE);
                    tv_load_prompt.setText("已无更多加载");
                    break;
                case LOAD_FAILURE:
                    progress.setVisibility(View.GONE);
                    tv_load_prompt.setText("加载失败");
                    itemView.setVisibility(View.VISIBLE);
                    break;
                case LOAD_END:
                    itemView.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * TopStories
     */
    class TopStoriesViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.vp_top_stories)
        TopStoriesViewPager vp_top_stories;
        @Bind(R.id.tv_top_title)
        TextView tv_top_title;

        public TopStoriesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bindItem(List<NewsTimeLine.TopStoriesBean> topList) {
            vp_top_stories.init(context, topList, tv_top_title, new TopStoriesViewPager.ViewPagerClickListenner() {
                @Override
                public void onClick(NewsTimeLine.TopStoriesBean item) {
                    if (null != item)
                        ZhiHuDetailActivity.ZhiHuDetailActivity(context, item.getId() + "");
                }
            });
        }
    }

    /**
     * Stories
     */
    class StoriesViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.card_stories)
        CardView card_stories;
        @Bind(R.id.tv_stories_title)
        TextView tv_stories_title;
        @Bind(R.id.iv_stories_img)
        ImageView iv_stories_img;

        public StoriesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            ScreenUtil screenUtil = ScreenUtil.instance(context);
            int screenWidth = screenUtil.getScreenWidth();
            card_stories.setLayoutParams(new LinearLayout.LayoutParams(screenWidth, LinearLayout.LayoutParams.WRAP_CONTENT));

        }

        public void bindItem(NewsTimeLine.StoriesBean stories) {
            tv_stories_title.setText(stories.getTitle());
            List<String> images = stories.getImages();
            Glide.with(context).load(images.get(0)).centerCrop().into(iv_stories_img);
            card_stories.setOnClickListener(v -> ZhiHuDetailActivity.ZhiHuDetailActivity(context, stories.getId() + ""));
        }
    }


    public int getLOAD_MORE() {
        return LOAD_MORE;
    }

    public int getLOAD_PULL_TO() {
        return LOAD_PULL_TO;
    }

    public int getLOAD_NONE() {
        return LOAD_NONE;
    }

    public int getLOAD_END() {
        return LOAD_END;
    }

    public int getTYPE_TOP() {
        return TYPE_TOP;
    }

    public int getTYPE_FOOTER() {
        return TYPE_FOOTER;
    }

    public int getLOAD_FAILURE() {
        return LOAD_FAILURE;
    }
}
