package zh.yen.novaeducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class UnitedKingdomPage extends AppCompatActivity {
    RecyclerView               recyclerView;
    RecyclerView.LayoutManager linearLayoutManager;
    ArrayList<UKModel> listUK;
    UKAdapter          universityAdapter;

    Button btnRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_united_kingdom_page);
        recyclerView = findViewById (R.id.recyclerView);

        linearLayoutManager = new LinearLayoutManager ( this );
        recyclerView.setLayoutManager (linearLayoutManager);
        recyclerView.setHasFixedSize (true);
        listUK = new ArrayList<>();
        universityAdapter = new UKAdapter((this),listUK);
        recyclerView.setAdapter (universityAdapter);
        btnRequest = findViewById ( R.id.request );


        recyclerView.addOnItemTouchListener (
                new RecyclerItemClickListener(this, recyclerView,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int pos) {
                        if(pos == 0){

                            Intent intent = new Intent( UnitedKingdomPage.this, DescriptionPage.class);
                            startActivity(intent);

                        }else if(pos == 1){

                            Intent intent = new Intent(UnitedKingdomPage.this,DescriptionPage.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int pos) {

                    }}));
        setInitialData ();


    }
    protected void setInitialData(){
        listUK.add ( new UKModel ("url","City, University of London","London"));
    }

}