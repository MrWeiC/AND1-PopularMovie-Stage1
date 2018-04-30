package io.weichen.popularmovie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.weichen.popularmovie.utilities.NetworkUtils;

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
        String posterURL = NetworkUtils.buildPosterPathURL(movieData.getMoviePosterImageThumbnail()).toString();
        Picasso.get().load(posterURL).into(holder.mMoviePosterImageView);
    }

    @Override
    public int getItemCount() {
        if (null == movieDataArrayList) return 0;
        return movieDataArrayList.size();
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView mMoviePosterImageView;

        public MovieAdapterViewHolder(View itemView) {
            super(itemView);

            mMoviePosterImageView = itemView.findViewById(R.id.iv_grid_item_poster);
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
