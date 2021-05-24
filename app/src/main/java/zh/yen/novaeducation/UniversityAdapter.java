package zh.yen.novaeducation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class UniversityAdapter  extends RecyclerView.Adapter<UniversityAdapter.MyViewHolder>{
    private Context            context;
    private List<UniversityModel> universities;
    private List<UniversityModel> filteredUniversities;

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public ImageView imageView;
        public TextView  nameView,location;

        public MyViewHolder(View v){
            super(v);
            imageView = v.findViewById ( R.id.uniPhoto );
            nameView = v.findViewById ( R.id.uniName);
            location = v.findViewById ( R.id.uniLocation);
        }

    }
    public UniversityAdapter(Context context,List<UniversityModel> universities){
        this.context = context;
        this.universities = universities;
        this.filteredUniversities = universities;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView;
        itemView = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.university_info, parent, false );

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityAdapter.MyViewHolder holder , int position) {
        UniversityModel item = universities.get(position);
        Glide.with ( context.getApplicationContext () )
                .load ( item.getPhoto () )
                .placeholder ( R.drawable.photo )
                .into ( holder.imageView );
        holder.nameView.setText ( item.getName() );
        holder.location.setText ( item.getLocation() );
    }

    @Override
    public int getItemCount(){
        return filteredUniversities.size ();
    }
    public
    Filter getFilter(){
        return new Filter (){

            @Override
            protected
            FilterResults performFiltering(CharSequence constraint) {
                String Key = constraint.toString();
                if(Key.isEmpty ()){
                    filteredUniversities = universities;
                }else{
                    List<UniversityModel> isFiltered = new ArrayList<> ();
                    for(UniversityModel row:universities){
                        if(row.getName().toLowerCase().contains(Key.toLowerCase ())){
                            isFiltered.add (row);
                        }
                    }
                    filteredUniversities = isFiltered;
                }
                FilterResults filterResults = new FilterResults ();
                filterResults.values = filteredUniversities;
                return filterResults;
            }

            @Override
            protected
            void publishResults(CharSequence constraint , FilterResults results) {
                filteredUniversities = (List<UniversityModel>)results.values;
                notifyDataSetChanged ();
            }
        };
    }

}

