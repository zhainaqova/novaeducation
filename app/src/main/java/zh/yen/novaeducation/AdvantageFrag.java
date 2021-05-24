package zh.yen.novaeducation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class AdvantageFrag extends Fragment {
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        v = inflater.inflate ( R.layout.advantage_frag, container , false );
        return v;
    }
}
