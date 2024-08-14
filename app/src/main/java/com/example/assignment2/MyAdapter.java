package com.example.assignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> myData;
    private List<Integer> myImages;
    private LayoutInflater myInflater;
    private ItemClickListener myClickListener;

    public MyAdapter(HomeActivity context, List<String> myData, List<Integer> myImages) {
        this.myData = myData;
        this.myImages = myImages;
        this.myInflater = LayoutInflater.from(context);
    }

    void setClickListener(ItemClickListener itemClickListener){
        this.myClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.item_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = myData.get(position);
        Integer img = myImages.get(position);

        holder.myImageView.setImageResource(img);

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }
    String getItem(int id){
        return myData.get(id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView myImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myImageView = itemView.findViewById(R.id.imageView4);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(myClickListener!= null)myClickListener.onItemClick(view,getAdapterPosition());
        }
    }
}