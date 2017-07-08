package com.example.rishabh.gettinbored.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.model.tv_shows;
import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

/**
 * Created by RISHABH on 07-07-2017.
 */

public class tvAdapter2 extends RecyclerView.Adapter<tvAdapter2.ViewHolder> {

    Context context;
    ArrayList<tvclass> tvclassArrayList;

    public tvAdapter2(Context context, ArrayList<tvclass> tvclassArrayList) {
        this.context = context;
        this.tvclassArrayList = tvclassArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=li.inflate(R.layout.tvlayout2,parent,false);
        return new ViewHolder(itemview);
    }
    public void updateshow(ArrayList<tvclass> tvclassArrayList) {
        this.tvclassArrayList = tvclassArrayList;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        tvclass tv=tvclassArrayList.get(position);
        holder.tvid.setText(String.valueOf(tv.getTv_shows().getId()));
        holder.tvname.setText(tv.getTv_shows().getName());
        holder.tvpermalink.setText(tv.getTv_shows().getPermalink());
        holder.tvcountry.setText(tv.getTv_shows().getCountry());
        holder.tvnetwork.setText(tv.getTv_shows().getNetwork());
        holder.tvstatus.setText(tv.getTv_shows().getStatus());
        holder.tvimage.setText(tv.getTv_shows().getImage_thumbnail_path());

    }

    @Override
    public int getItemCount() {
        return tvclassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvid,tvname,tvpermalink,tvcountry,tvnetwork,tvstatus,tvimage;
        public ViewHolder(View itemView) {
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
