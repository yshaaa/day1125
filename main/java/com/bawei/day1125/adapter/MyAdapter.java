package com.bawei.day1125.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.day1125.MainActivity;
import com.bawei.day1125.R;
import com.bawei.day1125.bean.ShopBean;
import com.bawei.day1125.glide.GlideUtil;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MainActivity mainActivity;
    private List<ShopBean.ResultBean> list;

    private final int one=1;
    public MyAdapter(MainActivity mainActivity, List<ShopBean.ResultBean> list) {

        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        View view=null;
        switch (viewType){
            case one:
                view=LayoutInflater.from(mainActivity).inflate(R.layout.item,null);
                holder=new OneHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof OneHolder){
            ((OneHolder) holder).price.setText(list.get(position).getId());
            ((OneHolder) holder).name.setText(list.get(position).getName());
            GlideUtil.LoadImage(list.get(position).getImageUrl(),((OneHolder) holder).imageView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==1){
            return one;
        }
        return one;
    }

    private class OneHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView price;
        public OneHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.image);
            name=view.findViewById(R.id.name);
            price=view.findViewById(R.id.price);
        }
    }
}
