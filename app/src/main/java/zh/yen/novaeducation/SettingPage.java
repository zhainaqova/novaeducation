package zh.yen.novaeducation;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SettingPage extends Fragment {
    LinearLayout lineL;
    TextView general;
    View                  v;
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        v = inflater.inflate ( R.layout.activity_setting_page, container , false );
        general = v.findViewById ( R.id.general );
        lineL = v.findViewById ( R.id.lineL);
        general.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getActivity (),Preference.class);
                startActivity (i);
            }
        } );

        load_setting ();
        return v;
    }
    private void load_setting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences (getActivity ());
        boolean chk_night = sp.getBoolean ( "NIGHT" , false );
        if (chk_night) {
           lineL.setBackgroundColor ( Color.parseColor ( "#222222" ) );
        } else {
            lineL.setBackgroundColor ( Color.parseColor ( "#ffffff" ) );
        }

        Activity a = getActivity ();
        String orien = sp.getString ( "ORIENTATION" , "false" );
        if ("1".equals ( orien )) {
            a.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_BEHIND );
        } else if ("2".equals ( orien )) {
            a.setRequestedOrientation ( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        } else if ("3".equals ( orien )) {
            a.setRequestedOrientation ( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );
        }
    }
    @Override
    public void onResume(){
        load_setting ();
        super.onResume();}
}