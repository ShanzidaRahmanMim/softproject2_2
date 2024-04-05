package com.example.wandergo.Activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wandergo.R;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageViewHolder> {

    private Context context;
    private int[] images; private String[] texts;

    public ImageListAdapter(Context context, int[] images,String texts[]) {
        this.context = context;
        this.images = images;
        this.texts=texts;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        int imageResource = images[position];String text = texts[position];
        holder.imageView.setImageResource(imageResource);
        holder.text1.setText(text);
        String send = text;
        //if(text == "Beaches") send = "beaches" ;
        if ("Beaches".equals(text)) send = "Beach";
        else if("Mountains".equals(text)) send = "Mountain";
        else if("Forest".equals(text)) send = "Forest";
        else if("Tourist Places".equals(text)) send = "Tourist Place";
        else if("Island".equals(text)) send = "Island";


        String finalSend = send;

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context ,BeachListActivity.class);
                intent.putExtra("selected", finalSend);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView text1,text2,text3,text4,text5;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            text1 = itemView.findViewById(R.id.textView1);

        }
    }
}
