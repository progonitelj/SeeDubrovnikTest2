package hr.project.seedubrovnik;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewListAdapterTur extends RecyclerView.Adapter<RecyclerViewListAdapterTur.ViewHolder>{

    private static final String TAG = "RecyclerViewListAdapterTurO";

    private Context myContext;
    List<TuristicObject> items = new ArrayList<>();

    public RecyclerViewListAdapterTur(Context myContext, List<TuristicObject> items) {
        this.myContext = myContext;
        this.items = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final TuristicObject object = items.get(position);
        holder.title.setText(object.getName());
        holder.partOfTown.setText(object.getDescription());
        holder.image.setImageDrawable(myContext.getResources().getDrawable(object.getImage()));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, "Clicked " + object.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(myContext, Bottom_Activity.class);
                intent.putExtra("stringName", object.getName());
                intent.putExtra("geo", object.getGeoURI());
                intent.putExtra("img", object.getImage());
                intent.putExtra("desc",object.getDescription());
                intent.putExtra("pot",object.getPartOfTown());
                myContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, partOfTown;
        LinearLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView1);
            title = itemView.findViewById(R.id.TextView1);
            partOfTown = itemView.findViewById(R.id.TextView2);
            parentLayout =  itemView.findViewById(R.id.parentLayout);
        }
    }
}
