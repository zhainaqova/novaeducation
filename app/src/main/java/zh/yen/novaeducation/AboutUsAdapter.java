package zh.yen.novaeducation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AboutUsAdapter extends FragmentStatePagerAdapter {
    int counttab;
    public AboutUsAdapter(@NonNull FragmentManager fm , int counttab) {
        super (fm,counttab);
        this.counttab = counttab;
    }
    @NonNull
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
               ContactsFrag contactsFrag = new ContactsFrag ();
                return contactsFrag;
            case 1:
                AddressFrag addressFrag = new AddressFrag();
                return addressFrag;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return counttab;
    }
}
