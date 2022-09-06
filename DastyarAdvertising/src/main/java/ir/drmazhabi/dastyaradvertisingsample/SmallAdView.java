package ir.drmazhabi.dastyaradvertisingsample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

public class SmallAdView extends FrameLayout {
    private String smallAdViewURL;
    private String smallAdViewAction;

    public SmallAdView(@NonNull Context context) {
        super(context);
    }

    public SmallAdView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SmallAdView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void setupView(View view) {
        LinearLayout small_ad_view = view.findViewById(R.id.small_ad_view);
        ImageView small_ad_image = view.findViewById(R.id.small_ad_image);
        Button small_ad_button = view.findViewById(R.id.small_ad_button);
        Glide.with(this)
                .load(Uri.parse(smallAdViewURL))
                .fitCenter()
                .into(small_ad_image);
        small_ad_image.setOnClickListener(view2 -> getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(smallAdViewAction))));
        removeAllViews();
        addView(small_ad_view);
    }

    public void setupSmallAdView(String imageURL, String clickAction) {
        this.smallAdViewURL = imageURL;
        this.smallAdViewAction = clickAction;
        View view = LayoutInflater.from(getContext()).inflate(R.layout.small_ad_view, this);
        if (smallAdViewAction != null && smallAdViewURL != null)
            setupView(view);
    }
}
