package com.xfdingustc.ngaclient.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.forum.ForumGroup;
import com.xfdingustc.ngaclient.ui.adapters.ForumListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2015/9/25.
 */
public class ForumGroupPagerFragment extends Fragment {
    private static final String TAG = ForumGroupPagerFragment.class.getSimpleName();
    private View mRootView;
    private ForumGroup mForumGroup;

    private ForumListAdapter mForumListAdapter;

    @Bind(R.id.rvForumList)
    RecyclerView mRvForumList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup)mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fragment_forum_group, container, false);
            ButterKnife.bind(this, mRootView);
        }

        setupForumList();
        return mRootView;
    }

    public void setForumGroup(ForumGroup forumGroup) {
        mForumGroup = forumGroup;
    }

    private void setupForumList() {
        mRvForumList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mForumListAdapter = new ForumListAdapter(getActivity());
        mRvForumList.setAdapter(mForumListAdapter);

        //BoardHolder holder = BoardHolder.getHolder();
        mForumListAdapter.setForumList(mForumGroup.getForumList());
    }
}
