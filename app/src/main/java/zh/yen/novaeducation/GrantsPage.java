package zh.yen.novaeducation;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GrantsPage extends Fragment {
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        v = inflater.inflate ( R.layout.activity_grants_page, container , false );
        return v;
    }
}