package com.shirozuo.footbasketsport;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>{
    private final int galleryItems;
    private TypedArray galleryImage;
    private final int typeOfArray;

    public GalleryAdapter(int galleryItems, int typeOfArray) {
        this.galleryItems = galleryItems;
        this.typeOfArray = typeOfArray;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_gallery, parent, false);

        galleryImage = parent.getContext().getResources().obtainTypedArray(typeOfArray);

        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return galleryItems;
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGallery;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);

            ivGallery = itemView.findViewById(R.id.iv_image_item);
        }
        void bind(int position){
            ivGallery.setImageResource(galleryImage.getResourceId(position, -1));
        }
    }
}
