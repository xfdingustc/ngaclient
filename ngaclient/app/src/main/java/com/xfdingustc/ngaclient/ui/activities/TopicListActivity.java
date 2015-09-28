package com.xfdingustc.ngaclient.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;
import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.bean.Topic;
import com.xfdingustc.ngaclient.forum.Forum;
import com.xfdingustc.ngaclient.global.Constants;
import com.xfdingustc.ngaclient.ui.adapters.TopicListAdapter;
import com.xfdingustc.ngaclient.volley.NgaClientJsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by Xiaofei on 2015/9/28.
 */
public class TopicListActivity extends BaseActivity {
    private static final String TAG = TopicListActivity.class.getSimpleName();


    private static final String EXTRA_FID = "fid";

    private static final String JSON_TAG_DATA = "data";
    private static final String JSON_TAG_TOPIC = "__T";
    private static final String JSON_TAG_TOPIC_COUNT = "__T__ROWS";

    private RequestQueue mRequestQueue;
    private String mForumId;

    @Bind(R.id.rvTopicList)
    RecyclerView mRvTopicList;

    private TopicListAdapter mTopicListAdapter;

    public static void launch(Context context, Forum forum) {
        Intent intent = new Intent(context, TopicListActivity.class);
        intent.putExtra(EXTRA_FID, forum.getId());
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void init() {
        super.init();
        mForumId = getIntent().getStringExtra(EXTRA_FID);
        mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.start();
        initViews();
    }

    private void initViews() {
        setContentView(R.layout.activity_topic_list);
        setupTopicListView();
    }

    private void setupTopicListView() {
        mRvTopicList.setLayoutManager(new LinearLayoutManager(this));
        mTopicListAdapter = new TopicListAdapter(this);
        mRvTopicList.setAdapter(mTopicListAdapter);

        String requestUrl = Constants.API_THREAD + "?fid=" + mForumId + "&page=1&lite=js&noprefix";

        Logger.t(TAG).d("request url: " + requestUrl);

        NgaClientJsonObjectRequest request = new NgaClientJsonObjectRequest(requestUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                String encoding = "GBK";
                Logger.t(TAG).d("encoding: " + encoding);

                onHandleTopicListResponse(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.t(TAG).d("Load topic list error");
            }
        }) ;

        mRequestQueue.add(request);
    }




    private void onHandleTopicListResponse(String responseStr) {
        List<Topic> topicList = new ArrayList<>();
        try {
            JSONObject response = new JSONObject(responseStr);

            JSONObject data = response.getJSONObject(JSON_TAG_DATA);
            JSONObject topicArray = data.getJSONObject(JSON_TAG_TOPIC);
            int topicCount = data.getInt(JSON_TAG_TOPIC_COUNT);


            for (int i = 0; i < topicCount; i++) {
                String index = String.valueOf(i);
                JSONObject topicObject = (JSONObject) topicArray.get(index);

                Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

                Topic topic = gson.fromJson(topicObject.toString(), Topic.class);

                topicList.add(topic);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mTopicListAdapter.setTopicList(topicList);
    }


}
