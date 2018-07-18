package com.example.hoang.project_demo_3.ViewHolder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hoang.project_demo_3.R;
import com.example.hoang.project_demo_3.entity.Request;
import com.example.hoang.project_demo_3.utilities.Interface.ItemClickListener;

import java.util.List;

public class OrderRecycleViewAdapter extends RecyclerView.Adapter<OrderRecycleViewAdapter.CartViewHolder> {
    private List<Request> listData;
    private Context context;

    public OrderRecycleViewAdapter(List<Request> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderRecycleViewAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.order_item, parent, false);
        return new OrderRecycleViewAdapter.CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderRecycleViewAdapter.CartViewHolder holder, int position) {
        holder.txt_price.setText(listData.get(position).getTotal());
        holder.txt_name.setText(listData.get(position).getName());
        holder.txt_adress.setText(listData.get(position).getAddress());
        holder.txt_phone.setText(listData.get(position).getPhone());
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txt_name, txt_price, txt_adress, txt_phone;


        private ItemClickListener itemClickListener;

        public TextView getTxt_name() {
            return txt_name;
        }

        public void setTxt_name(TextView txt_name) {
            this.txt_name = txt_name;
        }

        public TextView getTxt_price() {
            return txt_price;
        }

        public void setTxt_price(TextView txt_price) {
            this.txt_price = txt_price;
        }


        public ItemClickListener getItemClickListener() {
            return itemClickListener;
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public CartViewHolder(View itemView) {
            super(itemView);
            txt_phone = itemView.findViewById(R.id.order_total);
            txt_name = itemView.findViewById(R.id.order_name);
            txt_price = itemView.findViewById(R.id.order_total);
            txt_adress = itemView.findViewById(R.id.order_adress);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
