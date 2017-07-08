package com.example.rishabh.gettinbored.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.gettinbored.OnItemClickListener;
import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

/**
 * Created by RISHABH on 07-07-2017.
 */

public class tvAdapter extends RecyclerView.Adapter<tvAdapter.TvViewHolder> {
    Context context;
    ArrayList<tvclass> tvclassArrayList;
   OnItemClickListener onItemClickListener;

    public tvAdapter(Context context, ArrayList<tvclass> tvclassArrayList) {
        this.context = context;
        this.tvclassArrayList = tvclassArrayList;
    }

    @Override
    public TvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.tvlayout, parent, false);
        return new TvViewHolder(itemview);
    }

    public void updateshows(ArrayList<tvclass> tvclassArrayList) {
        this.tvclassArrayList = tvclassArrayList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(TvViewHolder holder, int position) {
        tvclass tv = tvclassArrayList.get(position);

        holder.tvtotal.setText(String.valueOf(tv.getTotal()));
        holder.tvpage.setText(String.valueOf(tv.getPage()));

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return tvclassArrayList.size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {
        TextView tvpage, tvtotal;

        public TvViewHolder(View itemView) {
            super(itemView);
            tvtotal = (TextView) itemView.findViewById(R.id.tvtotal);
            tvpage = (TextView) itemView.findViewById(R.id.tvpage);

        }
    }
}
