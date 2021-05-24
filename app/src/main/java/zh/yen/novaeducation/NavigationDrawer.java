package zh.yen.novaeducation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {
    DrawerLayout          drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar               toolbar;
    NavigationView        navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.drawer_layout );
        drawerLayout = findViewById ( R.id.drawer );
        toolbar = findViewById ( R.id.toolBar );
        setSupportActionBar ( toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toggle = new ActionBarDrawerToggle ( this , drawerLayout , toolbar , R.string.open , R.string.close );
        drawerLayout.addDrawerListener ( toggle );
        toggle.syncState ();
        navigationView = findViewById ( R.id.nav_view );
        changeFragment(new CountryPage ());

        navigationView.setNavigationItemSelectedListener ( new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                int id = item.getItemId ();
                drawerLayout.closeDrawers();
                switch (id) {
                    case R.id.country:
                        changeFragment(new CountryPage());
                        return true;
                    case R.id.grants:
                        changeFragment ( new GrantsPage());
                        break;
                    case R.id.university:
                      changeFragment(new UniversityPage());
                        break;
                    case R.id.news:
                        changeFragment ( new NewsPage());
                        break;
                    case R.id.settings:
                        changeFragment ( new SettingPage());
                        break;
                    case R.id.share:
                            Intent i = new Intent (Intent.ACTION_SEND);
                            i.setType ("text/plain");
                            i.putExtra ( Intent.EXTRA_SUBJECT,"Title");
                            String message = "App Link";
                            i.putExtra ( Intent.EXTRA_TEXT,message);
                            startActivity ( Intent.createChooser ( i,"share"));
                        break;
                    case R.id.nav_abtus:
                        changeFragment ( new AboutUsPage());
                        break;
                    default:
                        return true;
                }
                return true;
            }
        } );
    }

    public void changeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

}
