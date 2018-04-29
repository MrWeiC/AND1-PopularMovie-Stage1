package io.weichen.popularmovie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder>{

    public ArrayList<MovieData> movieDataArrayList;

    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForMovieItem = R.layout.grid_item_movie;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForMovieItem, viewGroup, shouldAttachToParentImmediately);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder holder, int position) {
        MovieData movieData = movieDataArrayList.get(position);
        holder.mMovieTextView.setText(movieData.getOriginalTitle());
    }

    @Override
    public int getItemCount() {
        if (null == movieDataArrayList) return 0;
        return movieDataArrayList.size();    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder{
        //TODO: to be removed
        public final TextView mMovieTextView;
        public MovieAdapterViewHolder(View itemView) {
            super(itemView);
            //TODO: to be removed
            mMovieTextView = (TextView)itemView.findViewById(R.id.grid_item_test_title);
        }
    }

    public void setMovieData(ArrayList<MovieData> movieData){
        movieDataArrayList = movieData;
        notifyDataSetChanged();
    }
}
