package com.example.exemplolista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplolista.model.ListItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    // Context object used to inflate list_item layout
    private List<ListItem> listItems;
    private Context context;
    // Generated constructor from members
    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        if(position % 2 == 0){
            ListItem listItem = listItems.get(position);
            holder.textViewHead.setText(listItem.head);
            holder.textViewDesc.setText(listItem.desc);
        }
        else{

            holder.textViewHead.setText("Impar");
            holder.textViewDesc.setText("Essa é uma posição impar");
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    //View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewHead = itemView.findViewById(R.id.textViewHead);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
        }
    }
}
