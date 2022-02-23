package com.example.bikeshopapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikeshopapp.Entity.Product;
import com.example.bikeshopapp.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    class ProductViewHolder extends RecyclerView.ViewHolder{
        private final TextView productItemView;
        private final TextView productTitleView;
        private final TextView productPriceView;
        private ProductViewHolder(View itemView){
            super(itemView);
            productItemView = itemView.findViewById(R.id.text_view_id);
            productTitleView = itemView.findViewById(R.id.text_view_title);
            productPriceView = itemView.findViewById(R.id.text_view_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Product current = mProducts.get(position);
                    Intent intent = new Intent(context, PartList.class);
                    intent.putExtra("id", current.getProductID());
                    intent.putExtra("name", current.getProductName());
                    intent.putExtra("price", current.getProductPrice());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Product> mProducts;
    private final Context context;
    private final LayoutInflater inflater;
    public ProductAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.product_list_item, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        if (mProducts != null) {
            Product current = mProducts.get(position);
            int ID = current.getProductID();
            String name = current.getProductName();
            double price = current.getProductPrice();
            holder.productTitleView.setText(name);
            holder.productItemView.setText(Integer.toString(ID));
            holder.productPriceView.setText(Double.toString(price));
        }
        else {
            holder.productItemView.setText("No Product Name");
        }
    }
    public void setProducts(List<Product> products) {
        mProducts=products;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (mProducts != null){
        return mProducts.size();
        }
        else return 0;
    }
}
