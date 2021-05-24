package zh.yen.novaeducation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder>{
    private Context           context;
    private List<CountryModel> countries;
    private List<CountryModel> filteredCountries;

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public ImageView imageView;
        public TextView  nameView;

        public MyViewHolder(View v){
            super(v);
            imageView = v.findViewById ( R.id.countryPhoto );
            nameView = v.findViewById ( R.id.countryName);

        }

    }
    public CountryAdapter(Context context,List<CountryModel> countries){
        this.context = context;
        this.countries = countries;
        this.filteredCountries = countries;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView;
        itemView = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.activity_country_info, parent, false );

        return new MyViewHolder(itemView);
    }

    @Override
    public void  onBindViewHolder(final MyViewHolder holder, int position) {
        CountryModel item = countries.get ( position );
        Glide.with ( context.getApplicationContext () )
                .load ( item.getPhoto () )
                .placeholder ( R.drawable.photo )
                .into ( holder.imageView );
        holder.nameView.setText ( item.getName () );
    }
    @Override
    public int getItemCount(){
        return filteredCountries.size ();
    }
    public Filter getFilter(){
        return new Filter (){

            @Override
            protected
            FilterResults performFiltering(CharSequence constraint) {
                String Key = constraint.toString();
                if(Key.isEmpty ()){
                    filteredCountries = countries;
                }else{
                    List<CountryModel> isFiltered = new ArrayList<> ();
                    for(CountryModel row:countries){
                        if(row.getName().toLowerCase().contains(Key.toLowerCase ())){
                            isFiltered.add (row);
                        }
                    }
                    filteredCountries = isFiltered;
                }
                FilterResults filterResults = new FilterResults ();
                filterResults.values = filteredCountries;
                return filterResults;
            }

            @Override
            protected
            void publishResults(CharSequence constraint , FilterResults results) {
                filteredCountries = (List<CountryModel>)results.values;
                notifyDataSetChanged ();
            }
        };
    }

}