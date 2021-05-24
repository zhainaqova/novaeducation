package zh.yen.novaeducation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabAdapter extends FragmentStatePagerAdapter {
    int counttab;
    public TabAdapter(@NonNull FragmentManager fm , int counttab) {
        super ( fm , counttab);
        this.counttab = counttab;
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
       switch (i){
           case 0:
               DescriptionFrag descriptionFrag = new DescriptionFrag ();
               return descriptionFrag;
           case 1:
               AdvantageFrag advantageFrag = new AdvantageFrag ();
               return advantageFrag;
           case 2:
               RequirementFrag requirementFrag = new RequirementFrag ();
               return requirementFrag;
           case 3:
               ProgramFrag programFrag= new ProgramFrag ();
               return programFrag;
           default:
               return null;
       }
    }

    @Override
    public int getCount() {
        return counttab;
    }
}
