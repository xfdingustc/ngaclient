package com.xfdingustc.ngaclient.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.orhanobut.logger.Logger;
import com.xfdingustc.ngaclient.R;
import com.xfdingustc.ngaclient.global.Constants;
import com.xfdingustc.ngaclient.global.JsonTag;
import com.xfdingustc.ngaclient.volley.NgaClientStringRequest;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Xiaofei on 2015/9/29.
 */
public class LoginActivity extends BaseActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Bind(R.id.etUsername)
    EditText mEtUsername;

    @Bind(R.id.etPassword)
    EditText mEtPassword;

    @OnClick(R.id.fabConfirm)
    public void onFabConfirmClicked() {
        if (!loginValidate()) {
            return;
        }

        String requestUrl = Constants.API_LOGIN;

        NgaClientStringRequest request = new NgaClientStringRequest(Request.Method.POST,
            requestUrl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Logger.t(TAG).d(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.t(TAG).d(error.getMessage());
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();

                headers.put(JsonTag.EMAIL, mEtUsername.getText().toString());
                headers.put(JsonTag.PASSWORD, mEtPassword.getText().toString());

                return headers;
            }
        };

        mRequestQueue.add(request);
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
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
        initViews();
    }

    private void initViews() {
        setContentView(R.layout.activity_login);
        setupAuthcodeImage();
    }

    private void setupAuthcodeImage() {
        String url = "http://account.178.com/q_vcode.php?_act=gen_reg";


    }

    public boolean loginValidate() {
        boolean valid = true;

        String userName = mEtUsername.getText().toString();
        String passWord = mEtPassword.getText().toString();

        if (userName.isEmpty()) {
            mEtUsername.setError(getString(R.string.username_error));
            valid = false;
        } else {
            mEtUsername.setError(null);
        }

        if (passWord.isEmpty()) {
            mEtPassword.setError(getString(R.string.password_error));
            valid = false;
        } else {
            mEtPassword.setError(null);
        }

        return valid;
    }


}
