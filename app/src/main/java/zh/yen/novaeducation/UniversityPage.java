package zh.yen.novaeducation;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class UniversityPage extends Fragment {
    RecyclerView              recyclerView;
    RecyclerView.LayoutManager linearLayoutManager;
    UniversityModel            university;
    ArrayList<UniversityModel> listUniversities;
    UniversityAdapter universityAdapter;
    Button btnRequest;

    EditText     searchUni;
    CharSequence search = "";
    View         v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        v = inflater.inflate ( R.layout.activity_university_page, container, false);
        recyclerView = v.findViewById (R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager ( getActivity () );
        recyclerView.setLayoutManager (linearLayoutManager);
        recyclerView.setHasFixedSize (true);
        listUniversities = new ArrayList<>();
        universityAdapter = new UniversityAdapter((getActivity ()),listUniversities);
        recyclerView.setAdapter (universityAdapter);
        btnRequest = v.findViewById ( R.id.request );
        searchUni = v.findViewById ( R.id.searchText );
        searchUni.addTextChangedListener ( new TextWatcher () {
            @Override
            public void beforeTextChanged(CharSequence s , int start , int count , int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence , int start , int before , int count) {
                universityAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        recyclerView.addOnItemTouchListener (
                new RecyclerItemClickListener(getActivity (), recyclerView,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int pos) {
                        if(pos == 0){

                            Intent intent = new Intent( getActivity (), DescriptionPage.class);
                            startActivity(intent);

                        }else if(pos == 1){

                            Intent intent = new Intent(getActivity (),DescriptionPage.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int pos) {

                    }}));
        setInitialData ();
        request();
        return v;
    }
    protected void setInitialData(){
        listUniversities.add ( new UniversityModel ("url","City, University of London","London"));
    }
    protected void request(){
       btnRequest.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getActivity (),RequestPage.class);
                startActivity ( i );
            }
        } );
    }
}