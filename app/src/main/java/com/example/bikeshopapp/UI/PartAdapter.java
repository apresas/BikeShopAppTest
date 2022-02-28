package com.example.bikeshopapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikeshopapp.Entity.Part;
import com.example.bikeshopapp.Entity.Product;
import com.example.bikeshopapp.R;

import java.util.List;

public class PartAdapter extends RecyclerView.Adapter<PartAdapter.PartViewHolder> {
    class PartViewHolder extends RecyclerView.ViewHolder{
        private final TextView partIDView;
        private final TextView partTitleView;
        private final TextView partPriceView;
        private PartViewHolder(View itemView){
            super(itemView);
            partIDView = itemView.findViewById(R.id.text_view_id);
            partTitleView = itemView.findViewById(R.id.text_view_title);
            partPriceView = itemView.findViewById(R.id.text_view_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Part current = mParts.get(position);
                    Intent intent = new Intent(context, PartList.class);
                    intent.putExtra("id", current.getPartID());
                    intent.putExtra("name", current.getPartName());
                    intent.putExtra("price", current.getPrice());
                    intent.putExtra("productID", current.getProductID());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Part> mParts;
    private final Context context;
    private final LayoutInflater inflater;
    public PartAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }
    @NonNull
    @Override
    public PartAdapter.PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.part_list_item, parent, false);
        return new PartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartAdapter.PartViewHolder holder, int position) {
        if (mParts != null) {
            Part current = mParts.get(position);
            int ID = current.getPartID();
            String name = current.getPartName();
            double price = current.getPrice();
            holder.partTitleView.setText(name);
            holder.partIDView.setText(Integer.toString(ID));
            holder.partPriceView.setText(Double.toString(price));
        }
        else {
            holder.partIDView.setText("No Product Name");
        }
    }
    public void setParts(List<Part> parts) {
        mParts = parts;
        notifyDataSetChanged();
    }

//    public Part getPartAt(int position) {
//        return getItem(position);
//    }


    @Override
    public int getItemCount() {
        if (mParts != null){
        return mParts.size();
        }
        else return 0;
    }
}
