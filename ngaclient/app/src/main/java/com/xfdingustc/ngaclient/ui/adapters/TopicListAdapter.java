package com.xfdingustc.ngaclient.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.bean.Topic;
import com.xfdingustc.ngaclient.ui.activities.TopicActivity;
import com.xfdingustc.ngaclient.ui.activities.TopicListActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2015/9/28.
 */
public class TopicListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final Context mContext;
    private List<Topic> mTopicList;

    public TopicListAdapter(Context context) {
        this.mContext = context;
    }

    public void setTopicList(List<Topic> topicList) {
        mTopicList = topicList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_topic, parent, false);
        return new TopicListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TopicListItemViewHolder viewHolder = (TopicListItemViewHolder)holder;

        Topic topic = mTopicList.get(position);

        viewHolder.tvSubject.setText(topic.subject);

        viewHolder.tvUserName.setText(topic.author);

        viewHolder.llTopicTitle.setTag(viewHolder);
        viewHolder.llTopicTitle.setOnClickListener(this);


    }

    @Override
    public int getItemCount() {
        return mTopicList == null ? 0 : mTopicList.size();
    }

    @Override
    public void onClick(View v) {
        TopicListItemViewHolder viewHolder = (TopicListItemViewHolder)v.getTag();
        int position = viewHolder.getLayoutPosition();
        Topic topic = mTopicList.get(position);

        switch (v.getId()) {
            case R.id.llTopicTitle:
                TopicActivity.launch(mContext, topic);
                break;
        }

    }

    public class TopicListItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tvSubject)
        TextView tvSubject;

        @Bind(R.id.tvUserName)
        TextView tvUserName;

        @Bind(R.id.llTopicTitle)
        LinearLayout llTopicTitle;

        public TopicListItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
