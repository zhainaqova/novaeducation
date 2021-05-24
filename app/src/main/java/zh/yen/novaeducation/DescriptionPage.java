package zh.yen.novaeducation;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class DescriptionPage extends AppCompatActivity {
    Toolbar   toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView back;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.description_page );
        toolbar = findViewById ( R.id.back_toolbar );
        setActionBar ( toolbar );
        back = findViewById ( R.id.back );
        tabLayout = findViewById ( R.id.tabLayout );
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = findViewById ( R.id.viewPager );
        TabAdapter tabAdapter = new TabAdapter ( getSupportFragmentManager () , tabLayout.getTabCount () );
        viewPager.setAdapter ( tabAdapter );
        viewPager.addOnPageChangeListener ( new TabLayout.TabLayoutOnPageChangeListener ( tabLayout ) );
        tabLayout.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem ( tab.getPosition ());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
        back.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DescriptionPage.this,CountryPage.class);
                startActivity ( intent );
            }
        } );
    }
}