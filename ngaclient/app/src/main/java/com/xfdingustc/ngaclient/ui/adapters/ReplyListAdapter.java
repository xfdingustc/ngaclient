package com.xfdingustc.ngaclient.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.bean.Reply;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2015/9/29.
 */
public class ReplyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private List<Reply> mReplyList;

    public ReplyListAdapter(Context context) {
        this.mContext = context;
    }

    public void setReplyList(List<Reply> replyList) {
        mReplyList = replyList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_reply, parent, false);

        return new ReplyListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Reply reply = mReplyList.get(position);

        ReplyListItemViewHolder viewHolder = (ReplyListItemViewHolder)holder;

        viewHolder.tvReply.setText(reply.content);
    }

    @Override
    public int getItemCount() {
        return mReplyList == null ? 0 : mReplyList.size();
    }

    public class ReplyListItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tvReply)
        TextView tvReply;

        public ReplyListItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
