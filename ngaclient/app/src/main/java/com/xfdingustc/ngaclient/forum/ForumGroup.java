package com.xfdingustc.ngaclient.forum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaofei on 2015/9/25.
 */
public class ForumGroup {
    private final String mName;

    private List<Forum> mForumList = new ArrayList<>();

    public ForumGroup(String name) {
        this.mName = name;
    }


    public List<Forum> getForumList() {
        return mForumList;
    }



    public String getName() {
        return mName;
    }

    public void add(Forum forum) {
        mForumList.add(forum);


    }
}
