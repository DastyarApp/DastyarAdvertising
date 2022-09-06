package ir.drmazhabi.dastyaradvertisingsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.StyledPlayerView;


public class DastyarFullScreenAdView extends AppCompatActivity {
    private ImageView btnClose;
    private StyledPlayerView playerView;
    private ExoPlayer player;
    private String AdUri;
    private String AdAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
        setContentView(R.layout.activity_dastyar_full_screen_ad_view);

        AdUri = getIntent().getStringExtra("video_url");
        AdAction = getIntent().getStringExtra("click_action");

        initViews();
        setupPlayerView();
    }

    private void setupPlayerView() {
        player = new ExoPlayer.Builder(DastyarFullScreenAdView.this).build();
        playerView.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri(AdUri);
        player.setMediaItem(mediaItem);
        player.prepare();
        player.setPlayWhenReady(true);
        player.addListener(new Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int playbackState) {
                if (playbackState == Player.STATE_ENDED)
                    btnClose.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPlayerError(PlaybackException error) {
                Player.Listener.super.onPlayerError(error);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.setPlayWhenReady(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.setPlayWhenReady(true);
    }

    private void initViews() {
        // findViewById
        btnClose = findViewById(R.id.btn_close);
        playerView = findViewById(R.id.full_video_view);
        playerView.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(AdAction))));

        // listeners
        btnClose.setOnClickListener(view -> finish());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }
}