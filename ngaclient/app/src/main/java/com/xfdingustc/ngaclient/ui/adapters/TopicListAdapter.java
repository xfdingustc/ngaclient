package com.xfdingustc.ngaclient.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.bean.Topic;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2015/9/28.
 */
public class TopicListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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

        viewHolder.tvSubject.setText(topic.getSubject());
    }

    @Override
    public int getItemCount() {
        return mTopicList == null ? 0 : mTopicList.size();
    }

    public class TopicListItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tvSubject)
        TextView tvSubject;

        public TopicListItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
