package bis.kkc.rmuti.hongmoonmang;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by I Am Coffee on 3/20/2018.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {
    private Context mContext;
    private List<Place> placeList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_card,parent,false);
        return new MyViewHolder(V);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Place place=placeList.get(position);
         holder.title.setText(place.getName());
        Glide.with(mContext).load(place.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,PlaceDetailActivity.class);
                intent.putExtra("place_key",placeList.get(position));
                mContext.startActivity(intent);}
        });
    }



    @Override
    public int getItemCount() {
        return placeList.size();
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder{

public TextView title;
public ImageView thumbnail;
        public MyViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            thumbnail=itemView.findViewById(R.id.thumbnail);
        }
    }

    public PlaceAdapter(Context mContext, List<Place> placeList) {
        this.mContext = mContext;
        this.placeList = placeList;
    }


}
