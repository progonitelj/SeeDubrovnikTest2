package hr.dbk.projects.seeDbk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewListAdapter2 extends RecyclerView.Adapter<RecyclerViewListAdapter2.ViewHolder> {

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Category object = (Category) items.get(position);
        holder.title.setText(object.getName());
        holder.image.setImageDrawable(myContext.getResources().getDrawable(object.getImg()));


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView1);
            title = itemView.findViewById(R.id.textView1);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
