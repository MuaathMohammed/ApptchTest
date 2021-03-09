package com.example.loginwithwebapi.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginwithwebapi.Models.Blogs;
import com.example.loginwithwebapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {
private ArrayList<Blogs> BlogData;
private Context _context;

    public BlogAdapter(ArrayList<Blogs> blogData, Context _context) {
        BlogData = blogData;
        this._context = _context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_content, parent, false);
        final ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Blogs bd=BlogData.get(position);
        holder.BTitle.setText(bd.getBlogTitle());
        holder.BCreator.setText(bd.getBlogCreator());
        holder.BDescription.setText(bd.getBlogDescription());
        Picasso.get().load(bd.getBlogImage()).into(holder.BImg);

    }

    @Override
    public int getItemCount() {
        return BlogData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView BImg;
        TextView BTitle,BDescription,BCreator;

    public ViewHolder(@NonNull View itemView) {

        super(itemView);
        BImg=itemView.findViewById(R.id.image_view_news);
        BTitle=itemView.findViewById(R.id.News_Title);
        BCreator=itemView.findViewById(R.id.BlogCreator);
        BDescription=itemView.findViewById(R.id.News_Desc);



    }
}
}
