package ir.drmazhabi.dastyaradvertisingsample;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DastyarAdView {
    private Context context;
    private final static String TAG = "DastyarAdView";
    private String FullScreenAdViewURL = "https://assets.mixkit.co/videos/preview/mixkit-tree-with-yellow-flowers-1173-large.mp4";
    private String FullScreenAdViewAction = "https://dsrapp.ir/";
    private String SmallBannerURL = "https://static.vecteezy.com/system/resources/thumbnails/002/294/876/small/back-to-school-web-banner-design-school-bag-trophy-stack-of-books-education-ornament-header-or-footer-banner-free-vector.jpg";
    private String SmallBannerAction = "https://google.com/";
    private String MediumBannerURL = "https://img.freepik.com/premium-psd/fashion-sale-social-media-post-web-banner-template_169307-2143.jpg?w=2000";
    private String MediumBannerAction = "https://translate.google.com/";
    private static DastyarAdView dastyarAdView;

    public static DastyarAdView getInstance() {
        if (dastyarAdView == null)
            dastyarAdView = new DastyarAdView();
        return dastyarAdView;
    }

    private DastyarAdView() {
    }


    public DastyarAdView loadFullScreenBanner() {
        if (context != null && dastyarAdView != null) {
            Intent intent = new Intent(context, DastyarFullScreenAdView.class);
            intent.putExtra("video_url", FullScreenAdViewURL);
            intent.putExtra("click_action", FullScreenAdViewAction);
            context.startActivity(intent);
        }
        return getInstance();
    }

    public DastyarAdView initialize(Context context) {
        this.context = context;
//        String url = "";
//
//        if (Build.VERSION.SDK_INT <= 20) {
//            url = url.replace("https://", "http://");
//        }
//
//        Response.Listener<JSONObject> listener = response -> {
//            try {
//                if (response.getBoolean("success")) {
//
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        };
//
//        Response.ErrorListener errorListener = error -> Log.e(TAG, "initialize: ", error);
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
//        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(20000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        Volley.newRequestQueue(context).add(jsonObjectRequest);
        return getInstance();
    }

    public DastyarAdView loadBanner(View adView, AdSize bannerSize) {
        if (bannerSize == AdSize.SMALL) {
            ((SmallAdView) adView).setupSmallAdView(SmallBannerURL, SmallBannerAction);
        } else if (bannerSize == AdSize.MEDIUM) {
            ((MediumAdView) adView).setupMediumAdView(MediumBannerURL, MediumBannerAction);
        }
        return getInstance();
    }
}
