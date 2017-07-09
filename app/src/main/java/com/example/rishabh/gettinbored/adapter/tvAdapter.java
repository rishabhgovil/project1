package com.example.rishabh.gettinbored.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.gettinbored.OnItemClickListener;
import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.model.tv_shows;
import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

/**
 * Created by RISHABH on 07-07-2017.
 */

public class tvAdapter extends RecyclerView.Adapter<tvAdapter.TvViewHolder> {
    Context context;
    ArrayList<tv_shows> tv_showsArrayList;
    private OnItemClickListener onItemClickListener;

    public tvAdapter(Context context, ArrayList<tv_shows> tv_showsArrayList) {
        this.context = context;
        this.tv_showsArrayList = tv_showsArrayList;
    }

    @Override
    public TvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.tvlayout2, parent, false);
        return new TvViewHolder(itemview);
    }

    public void updateshows(ArrayList<tv_shows> tv_showsArrayList) {
        this.tv_showsArrayList = tv_showsArrayList;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(TvViewHolder holder, int position) {
        final tv_shows tv = tv_showsArrayList.get(position);
        holder.tvid.setText(String.valueOf(tv.getId()));
        holder.tvname.setText(tv.getName());
        holder.tvpermalink.setText(tv.getPermalink());
        holder.tvcountry.setText(tv.getCountry());
        holder.tvnetwork.setText(tv.getNetwork());
        holder.tvstatus.setText(tv.getStatus());
        holder.tvimage.setText(tv.getImage_thumbnail_path());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(tv.getImage_thumbnail_path());
                }
            }
        });


    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return tv_showsArrayList.size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {
        TextView tvid,tvname,tvpermalink,tvcountry,tvnetwork,tvstatus,tvimage;

        public TvViewHolder(View itemView) {
            super(itemView);
            tvid=(TextView)itemView.findViewById(R.id.tvid);
            tvname=(TextView)itemView.findViewById(R.id.tvname);
            tvpermalink=(TextView)itemView.findViewById(R.id.tvpermalink);
            tvcountry=(TextView)itemView.findViewById(R.id.tvcountry);
            tvnetwork=(TextView)itemView.findViewById(R.id.tvnetwork);
            tvstatus=(TextView)itemView.findViewById(R.id.tvstatus);
            tvimage=(TextView)itemView.findViewById(R.id.tvimage);
        }
    }
}
