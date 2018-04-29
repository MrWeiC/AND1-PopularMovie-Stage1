package io.weichen.popularmovie;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();

    final private GridItemClickListener mOnClickListener;

    public ArrayList<MovieData> movieDataArrayList;

    public interface GridItemClickListener {
        void onGridItemClick(int index);
    }

    public MovieAdapter(GridItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

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
        return movieDataArrayList.size();
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //TODO: to be removed
        public final TextView mMovieTextView;

        public MovieAdapterViewHolder(View itemView) {
            super(itemView);
            //TODO: to be removed
            mMovieTextView = (TextView) itemView.findViewById(R.id.grid_item_test_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int postion = getAdapterPosition();
            mOnClickListener.onGridItemClick(postion);
        }
    }

    public void setMovieData(ArrayList<MovieData> movieData) {
        movieDataArrayList = movieData;
        notifyDataSetChanged();
    }
}
