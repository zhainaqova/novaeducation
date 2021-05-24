package zh.yen.novaeducation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
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
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    ImageView second_back_arrow,second_arrow_up;
    TextView second_title,second_subtitle,more_details;
    Animation from_left,from_right,from_bottom;

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_second );

        second_arrow_up = findViewById ( R.id.second_arrow_up);
        second_back_arrow = findViewById ( R.id.second_back_arrow);
        second_title = findViewById ( R.id.secondTitle);
        second_subtitle = findViewById ( R.id.secondSubTitle);
        more_details = findViewById ( R.id.moreDetails);

        second_arrow_up.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (SecondActivity.this,ThirdActivity.class);
                startActivity ( intent );
            }
        } );

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                            );
        getWindow ().getDecorView ().setSystemUiVisibility (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                                                          );
        from_bottom = AnimationUtils.loadAnimation ( this,R.anim.anim_from_bottom );
        from_left = AnimationUtils.loadAnimation ( this,R.anim.anim_from_left);
        from_right = AnimationUtils.loadAnimation ( this,R.anim.anim_from_right );

        second_arrow_up.setAnimation ( from_left );
        second_title.setAnimation ( from_right );
        second_subtitle.setAnimation ( from_right );
        second_arrow_up.setAnimation ( from_bottom );
        more_details.setAnimation ( from_bottom );

        second_back_arrow.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondActivity.this, NewsPage.class);
                startActivity(intent);
            }
        });
        second_arrow_up.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent thirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(second_arrow_up, "background_image_transition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SecondActivity.this, pairs);

                startActivity(thirdActivity, options.toBundle());
            }
        });
    }
}
