package zh.yen.novaeducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
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

import static android.app.PendingIntent.getActivity;

public class CountryPage extends Fragment {
    RecyclerView               recyclerView;
    RecyclerView.LayoutManager linearLayoutManager;
    CountryModel            country;
    ArrayList<CountryModel> listCountries;
    CountryAdapter          countryAdapter;


    EditText searchCountry;
    CharSequence search = "";


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        view = inflater.inflate ( R.layout.activity_country_page , container, false);

        recyclerView = view.findViewById (R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager ( getActivity () );
        recyclerView.setLayoutManager (linearLayoutManager);
        recyclerView.setHasFixedSize (true);
        listCountries = new ArrayList<>();
        countryAdapter = new CountryAdapter(getActivity (),listCountries);
        recyclerView.setAdapter (countryAdapter);


        searchCountry = view.findViewById ( R.id.searchText );
        searchCountry.addTextChangedListener ( new TextWatcher () {
            @Override
            public void beforeTextChanged(CharSequence s , int start , int count , int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence , int start , int before , int count) {
                countryAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(),recyclerView,
                                              new RecyclerItemClickListener.OnItemClickListener() {
                                                  @Override
                                                  public void onItemClick(View view, final int pos) {
                                                      if(pos == 0){

                                                          Intent intent = new Intent(getActivity(), UnitedKingdomPage.class);
                                                          startActivity(intent);

                                                      }else if(pos == 1){

                                                          Intent intent = new Intent(getActivity(), UnitedKingdomPage.class);
                                                          startActivity(intent);
                                                      }
                                                  }

                                                  @Override
                                                  public void onLongItemClick(View view, int pos) {

                                                  }
                                              })
                                             );

        setInitialData ();

        return view;
    }

    protected void setInitialData(){
        listCountries.add ( new CountryModel ("UNITED KINGDOM","url"));
        listCountries.add ( new CountryModel ("CZECH REPUBLIC","url"));
        listCountries.add ( new CountryModel ("POLAND","url"));
        listCountries.add ( new CountryModel ("LITHUANIA","url"));
        listCountries.add ( new CountryModel ("HUNGARY","url"));
        listCountries.add ( new CountryModel ("ESTONIA","url"));
        listCountries.add ( new CountryModel ("SWITZERLAND","url"));
        listCountries.add ( new CountryModel ("GEORGIA","url"));
        listCountries.add ( new CountryModel ("SOUTH KOREA","url"));
        listCountries.add ( new CountryModel ("CHINA","url"));
        listCountries.add ( new CountryModel ("HANG KONG","url"));
        listCountries.add ( new CountryModel ("MALASIA","url"));
        listCountries.add ( new CountryModel ("JAPAN","url"));

    }


}