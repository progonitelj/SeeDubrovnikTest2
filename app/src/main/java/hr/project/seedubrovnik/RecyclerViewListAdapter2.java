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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewListAdapter2 extends RecyclerView.Adapter<RecyclerViewListAdapter2.ViewHolder>{

    private static final String TAG = "RecyclerViewListAdapter";
    private Context myContext;
    List items = new ArrayList();

    public <T> RecyclerViewListAdapter2(Context myContext, List<T> items) {
        this.myContext = myContext;
        this.items = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.welcome_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
            final PartsOfTown object = (PartsOfTown) items.get(position);
            holder.title.setText(object.getName());
            holder.image.setImageDrawable(myContext.getResources().getDrawable(object.getImage()));
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (object.getName().equals("Food")){
                        Intent intent = new Intent(myContext, MidActivity.class);
                        intent.putExtra("table", "restaurants");
                        myContext.startActivity(intent);
                    }
                    else if(object.getName().equals("Monuments")){
                        Intent intent = new Intent(myContext, MidActivity.class);
                        intent.putExtra("table", "objects");
                        myContext.startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(myContext, PickDestination.class);
                        myContext.startActivity(intent);
                    }
                }
            });





    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView1);
            title = itemView.findViewById(R.id.TextView1);
            parentLayout =  itemView.findViewById(R.id.parentLayout);
        }
    }
}
