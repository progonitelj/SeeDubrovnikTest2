package hr.project.seedubrovnik;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewListAdapter";

    private Context myContext;
    List<TuristicObject> items = new ArrayList<>();

    public RecyclerViewListAdapter(Context myContext, List<TuristicObject> items) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Started!!!");
        TuristicObject object = items.get(position);
        holder.title.setText(object.getName());
        holder.pot.setText(holder.pot.getText() + object.getPartOfTown());
        holder.image.setImageDrawable(myContext.getResources().getDrawable(object.getImage()));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, pot;
        RelativeLayout paretnLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView1);
            title = itemView.findViewById(R.id.TextView1);
            pot  = itemView.findViewById(R.id.TextView2);
        }
    }
}
