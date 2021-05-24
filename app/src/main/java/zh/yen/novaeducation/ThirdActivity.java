package zh.yen.novaeducation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;

public class ThirdActivity extends AppCompatActivity {
    ImageView down;
    ScrollView third_scroll;
    Animation from_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initViews();
        setAnimation();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                            );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

                                                             );
        onClicked();

    }

    public void initViews(){
        down = findViewById(R.id.down_arrow);
        third_scroll = findViewById(R.id.third_scroll_view);
        from_bottom = AnimationUtils.loadAnimation ( this, R.anim.anim_from_bottom );
    }

    public void setAnimation(){
        down.setAnimation(from_bottom);
        third_scroll.setAnimation(from_bottom);
    }

    public void onClicked(){

        down.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent( ThirdActivity.this, SecondActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(down, "background_image_transition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation ( ThirdActivity.this, pairs );

                startActivity(secondActivity, options.toBundle());
            }
        });

    }
}