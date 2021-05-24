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

public class UKAdapter extends RecyclerView.Adapter<UKAdapter.MyViewHolder>{
private Context            context;
private List<UKModel> universities;


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
    public UKAdapter(Context context, ArrayList<UKModel> universities){
        this.context = context;
        this.universities = universities;

    }
    @Override
    public
    UKAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView;
        itemView = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.university_info, parent, false );

        return new UKAdapter.MyViewHolder ( itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {
        UKModel item = universities.get(position);
        Glide.with ( context.getApplicationContext () )
                .load ( item.getPhoto () )
                .placeholder ( R.drawable.photo )
                .into ( holder.imageView );
        holder.nameView.setText ( item.getName() );
        holder.location.setText ( item.getLocation() );
    }

    @Override
    public
    int getItemCount() {
        return 0;
    }


}