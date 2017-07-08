package com.example.rishabh.gettinbored.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.model.foodmodel;

import java.util.ArrayList;

/**
 * Created by RISHABH on 05-07-2017.
 */

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.FoodViewHolder> {

    Context context;
    ArrayList<foodmodel> foodmodelArrayList;

    public foodAdapter(Context context, ArrayList<foodmodel> foodmodelArrayList) {
        this.context = context;
        this.foodmodelArrayList = foodmodelArrayList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=li.inflate(R.layout.cricketlayout,parent,false);
        return new FoodViewHolder(itemview);
    }
    public void updatefoods(ArrayList<foodmodel> foodmodelArrayList) {
        this.foodmodelArrayList=foodmodelArrayList;
        notifyDataSetChanged();

    }
    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
            foodmodel foodees=foodmodelArrayList.get(position);
        holder.tvname.setText(foodees.getName());
        holder.tvdescription.setText(foodees.getDescription());
        holder.tvprice.setText(foodees.getPrice());
        holder.tvcalories.setText(foodees.getCalories());
    }

    @Override
    public int getItemCount() {
        return foodmodelArrayList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
            TextView tvname,tvprice,tvdescription,tvcalories;
        public FoodViewHolder(View itemView) {
            super(itemView);
            tvname=(TextView)itemView.findViewById(R.id.name);
            tvprice=(TextView)itemView.findViewById(R.id.price);
            tvdescription=(TextView)itemView.findViewById(R.id.description);
            tvcalories=(TextView)itemView.findViewById(R.id.calories);
        }
    }
}
