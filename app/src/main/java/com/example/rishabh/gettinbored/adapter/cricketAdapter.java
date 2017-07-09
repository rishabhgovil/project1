package com.example.rishabh.gettinbored.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.model.cricketmodel;
import com.example.rishabh.gettinbored.model.matches;
import com.example.rishabh.gettinbored.model.tvclass;

import java.util.ArrayList;

/**
 * Created by RISHABH on 07-07-2017.
 */

public class cricketAdapter extends RecyclerView.Adapter<cricketAdapter.CricketViewHolder> {

    Context context;
    ArrayList<matches> matchesArrayList;
    public static final String TAG="hi";

    public cricketAdapter(Context context, ArrayList<matches> matchesArrayList) {
        this.context = context;
        this.matchesArrayList = matchesArrayList;
    }

    @Override
    public CricketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=li.inflate(R.layout.cricketlayout,parent,false);
        Log.d(TAG, "onCreateViewHolder: created");
        return new CricketViewHolder(itemview);
    }
    public void updatematches(ArrayList<matches> matchesArrayList) {
        this.matchesArrayList = matchesArrayList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(CricketViewHolder holder, int position) {
        final matches cm=matchesArrayList.get(position);
        holder.team1.setText(cm.getTeam1());
        Log.d(TAG, "onBindViewHolder: binded");
        holder.team2.setText(cm.getTeam2());
        holder.unique_id.setText(String.valueOf(cm.getUnique_id()));
        holder.date.setText(cm.getDate());
        holder.matchStarted.setText(cm.getMatchStarted());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class CricketViewHolder extends RecyclerView.ViewHolder{
        TextView team1,team2,unique_id,date,matchStarted;
        public CricketViewHolder(View itemView) {
            super(itemView);
            team1=(TextView)itemView.findViewById(R.id.team1);
            team2=(TextView)itemView.findViewById(R.id.team2);
            unique_id=(TextView)itemView.findViewById(R.id.unique_id);
            date=(TextView)itemView.findViewById(R.id.date);
            matchStarted=(TextView)itemView.findViewById(R.id.matchStarted);
        }
    }
}
