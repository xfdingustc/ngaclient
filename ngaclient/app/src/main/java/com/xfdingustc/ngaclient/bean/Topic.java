package com.xfdingustc.ngaclient.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xfdingustc.ngaclient.utils.ToStringUtils;

/**
 * Created by Xiaofei on 2015/9/28.
 */
public class Topic {

    @Expose
    @SerializedName("tid")
    public int id;

    @Expose
    public String subject;

    @Expose
    public String author;

    @Expose
    @SerializedName("tpcurl")
    public String url;


    @Override
    public String toString() {
        return ToStringUtils.getString(this);
    }
}
