package com.xfdingustc.ngaclient.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.forum.ForumGroup;
import com.xfdingustc.ngaclient.forum.ForumGroupHolder;
import com.xfdingustc.ngaclient.ui.adapters.ForumGroupPagerAdapter;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ForumGroupPagerAdapter mForumGroupPagerAdater;

    @Bind(R.id.forumGroupPager)
    ViewPager mForumGroupPager;

    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }

    @Override
    protected void init() {
        super.init();
        initViews();
    }

    private void initViews() {
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupForumGroupPager();
    }

    private void setupForumGroupPager() {
        mForumGroupPagerAdater = new ForumGroupPagerAdapter(getSupportFragmentManager());

        List<ForumGroup> forumGroupList = ForumGroupHolder.getHolder().getForumGroupList();
        for (ForumGroup forumGroup : forumGroupList) {
            mForumGroupPagerAdater.addForumGroup(forumGroup);
        }

        mForumGroupPager.setAdapter(mForumGroupPagerAdater);
        mTabLayout.setupWithViewPager(mForumGroupPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
