package hr.project.seedubrovnik;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;


import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

public class TuristicObjectListAdapter extends ArrayAdapter<TuristicObject>{
    private static final String TAG = "TuristicObjectListAdapt";
    private Context myContext;
    private int  mResource;
    private int lastPosition = -1;

    static class ViewHolder {
        TextView name;
        TextView partOfTown;
        TextView typeOfObject;
        Button buttonDescription;
        Button buttonLocation;
        ImageView image;
    }

    public TuristicObjectListAdapter(@NonNull Context context, int resource, @NonNull List<TuristicObject> objects) {
        super(context, resource, objects);
        this.myContext = myContext;
        myContext = context;
        mResource = resource;
        Log.d(TAG, "TuristicObjectListAdapter: Contructor finish!!!");
    }
    
    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        setUpImageLoader();
        String name = getItem(position).getName();
        String partsOfTown = getItem(position).getPartOfTown();
        String TypeOfObject = getItem(position).getTypeOfObject();
        String imageURL = getItem(position).getImageURL();
        final Uri geoPos = getItem(position).getGeoURI();

        final  View result;
        ViewHolder holder;

        if (convertView == null){

            LayoutInflater inflater = LayoutInflater.from(myContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textView1);
            holder.partOfTown = (TextView) convertView.findViewById(R.id.textView2);
            holder.typeOfObject = (TextView) convertView.findViewById(R.id.textView3);
            holder.buttonDescription = (Button) convertView.findViewById(R.id.ButtonDescription);
            holder.buttonLocation = (Button) convertView.findViewById(R.id.ButtonLocation);
            holder.image = (ImageView) convertView.findViewById(R.id.imageView);
            result = convertView;
            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(myContext, (position > lastPosition) ? R.anim.loading_down_anim : R.anim.loading_up_anim);
        result.startAnimation(animation);
        lastPosition = position;


        int defoultImage = myContext.getResources().getIdentifier("@drawable/image_failed", null, myContext.getPackageName());


        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defoultImage )
                .showImageOnFail(defoultImage )
                .showImageOnLoading(defoultImage ).build();


        imageLoader.displayImage(imageURL, holder.image, options);

        holder.name.setText(name);
        holder.partOfTown.setText(partsOfTown);
        holder.typeOfObject.setText(TypeOfObject);
        holder.buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW);
                mapIntent.setData(geoPos);
                myContext.startActivity(mapIntent);
            }
        });


        return convertView;
    }


    private void setUpImageLoader(){

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                myContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}
