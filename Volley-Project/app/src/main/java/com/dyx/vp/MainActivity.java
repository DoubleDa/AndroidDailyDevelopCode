package com.dyx.vp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.apkfuns.logutils.LogUtils;

import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.but_string_request)
    Button butStringRequest;
    @Bind(R.id.but_json_request)
    Button butJsonRequest;
    @Bind(R.id.but_image_request)
    Button butImageRequest;
    @Bind(R.id.but_image_loader)
    Button butImageLoader;
    @Bind(R.id.iv_show)
    ImageView ivShow;
    @Bind(R.id.but_network_image_view)
    NetworkImageView butNetworkImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        handleNetworkImageView();
    }

    private void handleNetworkImageView() {
        RequestQueue queue = Volley.newRequestQueue(this);
        ImageLoader loader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });

        butNetworkImageView.setDefaultImageResId(R.mipmap.img_default);
        butNetworkImageView.setErrorImageResId(R.mipmap.img_error);
        butNetworkImageView.setImageUrl("http://p4.so.qhimg.com/bdr/326__/t01ce1dce23e0bfdbb9.jpg", loader);
    }

    @OnClick({R.id.but_string_request, R.id.but_json_request, R.id.but_image_request, R.id.but_image_loader, R.id.but_network_image_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_string_request:
                handleStringRequest();
                break;
            case R.id.but_json_request:
                handleJsonRequest();
                break;
            case R.id.but_image_request:
                handleImageRequest();
                break;
            case R.id.but_image_loader:
                handleImageLoader();
                break;
            default:
                break;
        }
    }


    private void handleImageLoader() {
        RequestQueue queue = Volley.newRequestQueue(this);
        ImageLoader loader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(ivShow, R.mipmap.img_default, R.mipmap.img_error);

        loader.get("http://p4.so.qhimg.com/bdr/326__/t01ce1dce23e0bfdbb9.jpg", listener, 400, 400);
    }

    private void handleImageRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        ImageRequest request = new ImageRequest("http://p4.so.qhimg.com/bdr/326__/t01ce1dce23e0bfdbb9.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        ivShow.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i(error.toString());
            }
        });
        queue.add(request);
    }

    private void handleJsonRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest("http://192.168.7.77:8081/listBooks", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                LogUtils.i(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i(error.toString());
            }
        });
        queue.add(request);
    }

    private void handleStringRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, "http://192.168.7.77:8081/listBooks", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LogUtils.i(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i(error.toString());
            }
        });
        queue.add(request);
    }
}
