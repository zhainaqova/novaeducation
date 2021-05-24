package zh.yen.novaeducation;

import androidx.cardview.widget.CardView;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

public class NewsPage extends Fragment {
    View v;
    CardView cardView,cardView2,cardView3;
    ImageView imageView;
    TextView textView,textView2, textView3,textView4,textView5;
    Animation anim_from_bottom,anim_from_top,anim_from_left;
    SearchView searchView;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        v = inflater.inflate ( R.layout.news_page_fragment, container , false );
        cardView =v.findViewById (R.id.cardView);
        cardView2 =v.findViewById (R.id.cardView2);
        cardView3 =v.findViewById (R.id.cardView3);
        imageView = v.findViewById (R.id.imageView);
        textView = v.findViewById (R.id.textView);
        textView5 = v.findViewById (R.id.textView5);
        searchView = v.findViewById (R.id.searchView);

        anim_from_bottom = AnimationUtils.loadAnimation ( getActivity (),R.anim.anim_from_bottom );
        anim_from_left = AnimationUtils.loadAnimation ( getActivity (),R.anim.anim_from_left);
        anim_from_top = AnimationUtils.loadAnimation ( getActivity (),R.anim.anim_from_top);

        cardView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent (getActivity (),SecondActivity.class);
              startActivity ( intent );
            }
        } );

        getActivity ().getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                );
        getActivity ().getWindow ().getDecorView ().setSystemUiVisibility (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                                                          );
        return v;
    }
}
