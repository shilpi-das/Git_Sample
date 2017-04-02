package com.gl.newsvolleyparser.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.gl.newsvolleyparser.R;
import com.gl.newsvolleyparser.model.NewsModel;
import com.gl.newsvolleyparser.utils.VolleySingleton;

import java.util.List;

/**
 * Created by shilpi.das on 25-09-2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private List<NewsModel> mRecyclerItemModelList;
    private LayoutInflater inflater;
    private View view;
    private NewsModel recyclerItemModel;
    private VolleySingleton mVolleySingleton;
    private ImageLoader mImageLoader;

    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;

        inflater = LayoutInflater.from(mContext);
    }

    public void setNewsList(List<NewsModel> recyclerItemModelList) {
        this.mRecyclerItemModelList = recyclerItemModelList;
        //when new range comes
        notifyItemRangeChanged(0, recyclerItemModelList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.recycer_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        recyclerItemModel = mRecyclerItemModelList.get(position);
        holder.tvTitle.setText(recyclerItemModel.getmTitle());
        holder.tvDescription.setText(recyclerItemModel.getmDescription());
        holder.tvLink.setText(recyclerItemModel.getmUrl());
        holder.tvLink.setMovementMethod(LinkMovementMethod.getInstance());
        holder.tvAuthor.setText(recyclerItemModel.getmAuthor());

        String urlImage = recyclerItemModel.getmImageUrl();
        if (urlImage != null) {

            mVolleySingleton = VolleySingleton.getInstance();
            mImageLoader = mVolleySingleton.getImageLoder();
            mImageLoader.get(urlImage, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    Drawable drawable=new BitmapDrawable(mContext.getResources(),response.getBitmap());

                    holder.ivNewsImage.setBackground(drawable);
                }

                @Override
                public void onErrorResponse(VolleyError error) {
                    holder.ivNewsImage.setImageResource(R.drawable.demo);


                }
            });



        }


    }

    @Override
    public int getItemCount() {
        return mRecyclerItemModelList.size();
    }

    //Definition of ViewHolder class
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDescription, tvLink, tvAuthor;
        private ImageView ivNewsImage;

        public ViewHolder(View itemView) {
            super(itemView);
            //Initializing data items
            initialize();
            //setting on click listener on image view
            //  setListener();

        }


   /*     public void setListener() {
            ivFlag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, tvCountryName.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            ivSpot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, tvSpotName.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });


        }*/

        public void initialize() {
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            tvLink = (TextView) itemView.findViewById(R.id.tvLink);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            ivNewsImage = (ImageView) itemView.findViewById(R.id.ivNewsImage);


        }
    }
}
