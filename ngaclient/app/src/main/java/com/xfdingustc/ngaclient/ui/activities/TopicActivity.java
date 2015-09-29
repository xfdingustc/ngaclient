package com.xfdingustc.ngaclient.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;
import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.bean.Reply;
import com.xfdingustc.ngaclient.bean.Topic;
import com.xfdingustc.ngaclient.global.Constants;
import com.xfdingustc.ngaclient.global.JsonTag;
import com.xfdingustc.ngaclient.ui.adapters.ReplyListAdapter;
import com.xfdingustc.ngaclient.volley.NgaClientJsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Xiaofei on 2015/9/28.
 */
public class TopicActivity extends BaseActivity {
    private static final String TAG = TopicActivity.class.getSimpleName();
    private static final String EXTRA_TOPIC_ID = "tid";
    private static final String EXTRA_TOPIC_URL = "topic_url";



    private String mTopicUrl;
    private RequestQueue mRequestQueue;

    @Bind(R.id.rvReplyList)
    RecyclerView mRvReplyList;

    private ReplyListAdapter mReplyListAdapter;


    public static void launch(Context context, Topic topic) {
        Intent intent = new Intent(context, TopicActivity.class);
        intent.putExtra(EXTRA_TOPIC_URL, topic.url);
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
        mTopicUrl = getIntent().getStringExtra(EXTRA_TOPIC_URL);
        mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.start();
        initViews();
    }

    private void initViews() {
        setContentView(R.layout.activity_topic);
        setupTopicReplyList();
    }

    private void setupTopicReplyList() {
        mRvReplyList.setLayoutManager(new LinearLayoutManager(this));
        mReplyListAdapter = new ReplyListAdapter(this);
        mRvReplyList.setAdapter(mReplyListAdapter);

        String requestUrl = Constants.HOST_URL + mTopicUrl + "&page=1&lite=js&noprefix&v2";
        NgaClientJsonObjectRequest request = new NgaClientJsonObjectRequest(requestUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Logger.t(TAG).json(response.toString());
                onHandleTopicReplyResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(request);
    }

    private void onHandleTopicReplyResponse(JSONObject response) {
        List<Reply> replyList = new ArrayList<>();
        try {
            JSONObject data = response.getJSONObject(JsonTag.DATA);
            int replayCount = data.getInt(JsonTag.REPLY_ROWS);

            JSONObject replyArray = data.getJSONObject(JsonTag.REPLY);

            for (int i = 0; i < replayCount; i++) {
                String indexStr = String.valueOf(i);

                Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
                JSONObject replyObj = replyArray.getJSONObject(indexStr);

                Reply reply = gson.fromJson(replyObj.toString(), Reply.class);

                replyList.add(reply);
                //Logger.t(TAG).d(reply.toString());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mReplyListAdapter.setReplyList(replyList);
    }
}
