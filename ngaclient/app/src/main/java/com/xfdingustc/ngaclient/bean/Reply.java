package com.xfdingustc.ngaclient.bean;

import com.google.gson.annotations.Expose;
import com.xfdingustc.ngaclient.utils.ToStringUtils;

/**
 * Created by Xiaofei on 2015/9/29.
 */
public class Reply {

    @Expose
    public String content;


    @Override
    public String toString() {
        return ToStringUtils.getString(this);
    }
}
