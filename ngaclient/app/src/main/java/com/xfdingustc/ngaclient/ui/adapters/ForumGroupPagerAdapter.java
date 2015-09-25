package com.xfdingustc.ngaclient.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orhanobut.logger.Logger;
import com.xfdingustc.ngaclient.forum.ForumGroup;
import com.xfdingustc.ngaclient.ui.fragments.ForumGroupPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaofei on 2015/9/25.
 */
public class ForumGroupPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = ForumGroupPagerAdapter.class.getSimpleName();
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitle = new ArrayList<>();

    public ForumGroupPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addForumGroup(ForumGroup froumGroup) {
        ForumGroupPagerFragment fragment = new ForumGroupPagerFragment();
        fragment.setForumGroup(froumGroup);
        mFragmentList.add(fragment);
        Logger.t(TAG).d("Title: " + froumGroup.getName());
        mFragmentTitle.add(froumGroup.getName());
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Logger.t(TAG).d("Title: " + mFragmentTitle.get(position));
        return mFragmentTitle.get(position);
    }
}
