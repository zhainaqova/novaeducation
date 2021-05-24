package zh.yen.novaeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public
class SplashScreen extends Activity {

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_splash_screen );
        int secondsDelayed = 1;
        new Handler ().postDelayed ( new Runnable() {
            public void run() {
                startActivity (new Intent ( SplashScreen.this, NavigationDrawer.class) );
                finish();
            }
        }, secondsDelayed * 1000 );
    }
}