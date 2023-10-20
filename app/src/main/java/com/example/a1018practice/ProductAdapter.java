package com.example.a1018practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    public static List<Product> productList;
    public static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Product product);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public ProductAdapter(List<Product> productList, OnItemClickListener listener){
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product, parent, false);
        return new ProductViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.imageView.setImageResource(product.getImageResource());
        holder.nameTextView.setText(product.getName());
        holder.descriptionTextView.setText(product.getDescription());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameTextView;
        public TextView descriptionTextView;
        private OnItemClickListener listener;

        public ProductViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);

            //아이템 뷰에 클릭리스너 추가
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION && ProductViewHolder.this.listener != null){
                        ProductViewHolder.this.listener.onItemClick(productList.get(position));
                    }
                }
            });
        }

    }
    public List<Product> rearrangeProductList(List<Product> originalList) {
        List<Product> rearrangedList = new ArrayList<>();

        int numRows = 2; // 행 수
        int numColumns = 3; // 열 수

        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows; row++) {
                int index = col + row * numColumns;
                if (index < originalList.size()) {
                    rearrangedList.add(originalList.get(index));
                }
            }
        }

        return rearrangedList;
    }
}
