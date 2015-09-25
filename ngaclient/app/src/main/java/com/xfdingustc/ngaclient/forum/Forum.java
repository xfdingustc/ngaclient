package com.xfdingustc.ngaclient.forum;

/**
 * Created by Xiaofei on 2015/9/25.
 */
public class Forum {
    private final String mId;
    private final String mName;
    private final int mIconRes;



    public Forum(String forumId, String name, int iconRes) {
        this.mId = forumId;
        this.mName = name;
        this.mIconRes = iconRes;
    }

    public String getId() {
        return mId;
    }


    public String getName() {
        return mName;
    }


    public int getIconRes() {
        return mIconRes;
    }





}
