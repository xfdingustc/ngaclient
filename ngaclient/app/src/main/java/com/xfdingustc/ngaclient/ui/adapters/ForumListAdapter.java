package com.xfdingustc.ngaclient.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.forum.Forum;
import com.xfdingustc.ngaclient.ui.activities.TopicListActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Xiaofei on 2015/9/28.
 */
public class ForumListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
    View.OnClickListener {
    private static final String TAG = ForumListAdapter.class.getSimpleName();
    private final Context mContext;
    private List<Forum> mForumList;


    public ForumListAdapter(Context context) {
        this.mContext = context;
    }

    public void setForumList(List<Forum> forumList) {
        mForumList = forumList;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_forum, parent, false);

        return new ForumListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ForumListViewHolder viewHolder = (ForumListViewHolder) holder;
        Forum forum = mForumList.get(position);
        viewHolder.mBoardName.setText(forum.getName());
        viewHolder.mCivboardIcon.setImageResource(forum.getIconRes());

        viewHolder.mRlBoardItem.setTag(holder);
        viewHolder.mRlBoardItem.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (mForumList != null) {
            return mForumList.size();
        } else {
            return 0;
        }
    }

    @Override
    public void onClick(View v) {
        ForumListViewHolder viewHolder = (ForumListViewHolder) v.getTag();
        int position = viewHolder.getPosition();
        switch (v.getId()) {
            case R.id.rlBoardItem:
                lauchTopicListActivity(position);

                break;
        }
    }

    private void lauchTopicListActivity(int position) {
        Forum forum = mForumList.get(position);
        TopicListActivity.launch(mContext, forum);

        /*
        String fidString = mBoardCategory.get(position).getUrl();

        if (position != 0 && !HttpUtil.HOST_PORT.equals("")) {
            HttpUtil.HOST = HttpUtil.HOST_PORT + HttpUtil.Servlet_timer;
        }
        int fid = 0;
        try {
            fid = Integer.parseInt(fidString);
        } catch (Exception e) {
            final String tag = this.getClass().getSimpleName();
            Log.e(tag, Log.getStackTraceString(e));
            Log.e(tag, "invalid fid " + fidString);
        }
        if (fid == 0) {
            String tip = fidString + "绝对不存在";
            / *
            if (toast != null) {
                toast.setText(tip);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            } else {
                toast = Toast.makeText(MainActivity.this, tip,
                    Toast.LENGTH_SHORT);

                toast.show();
            }
            return;
        }

        Logger.t(TAG).i("set host:" + HttpUtil.HOST);

        String url = HttpUtil.Server + "/thread.php?fid=" + fidString + "&rss=1";
        PhoneConfiguration config = PhoneConfiguration.getInstance();
        if (!StringUtil.isEmpty(config.getCookie())) {
            url = url + "&" + config.getCookie().replace("; ", "&");
        }

        //addToRecent();
        if (!StringUtil.isEmpty(url)) {
            FlexibleTopicListActivity.launch(mContext, fid);
            if (PhoneConfiguration.getInstance().showAnimation) {
                //overridePendingTransition(R.anim.zoom_enter,
                //    R.anim.zoom_exit);
            }
        } */
    }


    public class ForumListViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.civBoardIcon)
        CircleImageView mCivboardIcon;

        @Bind(R.id.tvBoardName)
        TextView mBoardName;

        @Bind(R.id.rlBoardItem)
        RelativeLayout mRlBoardItem;


        public ForumListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
