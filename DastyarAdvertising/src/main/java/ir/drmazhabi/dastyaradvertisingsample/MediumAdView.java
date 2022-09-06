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

public class MediumAdView extends FrameLayout {
    private String mediumAdViewURL;
    private String mediumAdViewAction;

    public MediumAdView(@NonNull Context context) {
        super(context);
    }

    public MediumAdView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MediumAdView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setupMediumAdView(String imageURL, String clickAction) {
        this.mediumAdViewURL = imageURL;
        this.mediumAdViewAction = clickAction;
        View view = LayoutInflater.from(getContext()).inflate(R.layout.medium_ad_view, this);
        if (mediumAdViewURL != null && mediumAdViewAction != null)
            setupView(view);
    }

    private void setupView(View view) {
        LinearLayout medium_ad_view = view.findViewById(R.id.medium_ad_view);
        ImageView medium_ad_image = view.findViewById(R.id.medium_ad_image);
        Button medium_ad_button = view.findViewById(R.id.medium_ad_button);
        Glide.with(this)
                .load(Uri.parse(mediumAdViewURL))
                .fitCenter()
                .into(medium_ad_image);
        medium_ad_image.setOnClickListener(view2 -> getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mediumAdViewAction))));
        removeAllViews();
        addView(medium_ad_view);
    }
}
