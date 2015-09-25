package com.xfdingustc.ngaclient.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.forum.ForumGroup;

import butterknife.ButterKnife;

/**
 * Created by Xiaofei on 2015/9/25.
 */
public class ForumGroupPagerFragment extends Fragment {

    private View mRootView;
    private ForumGroup mForumGroup;

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

        return mRootView;
    }

    public void setForumGroup(ForumGroup forumGroup) {
        mForumGroup = forumGroup;
    }
}
