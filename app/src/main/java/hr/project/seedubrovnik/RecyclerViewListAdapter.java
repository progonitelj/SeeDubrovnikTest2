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

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewListAdapter";

    private Context myContext;
    List<PartsOfTown> items = new ArrayList<>();

    public RecyclerViewListAdapter(Context myContext, List<PartsOfTown> items) {
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
        final PartsOfTown object = items.get(position);
        //holder.title.setText(object.getName());
        //holder.desc.setText(holder.desc.getText() + object.getDesc());
        holder.image.setImageDrawable(myContext.getResources().getDrawable(object.getImage()));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on item");
                Toast.makeText(myContext, "Clicked " + object.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(myContext, MidActivity.class);
                intent.putExtra("stringName", object.getName());
                intent.putExtra("SelectedItem", "monument");
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
        //TextView title, desc;
        LinearLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView1);
            //title = itemView.findViewById(R.id.TextView1);
            //desc  = itemView.findViewById(R.id.TextView2);
            parentLayout =  itemView.findViewById(R.id.parentLayout);
        }
    }
}
