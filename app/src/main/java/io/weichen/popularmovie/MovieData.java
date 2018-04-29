package io.weichen.popularmovie;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieData implements Parcelable{
    private String originalTitle;
    private String moviePosterImageThumbnail;
    private String overview;
    private String userRating;
    private String releaseDate;

    public MovieData(String originalTitle, String moviePosterImageThumbnail, String overview, String userRating, String releaseDate) {
        this.originalTitle = originalTitle;
        this.moviePosterImageThumbnail = moviePosterImageThumbnail;
        this.overview = overview;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
    }

    protected MovieData(Parcel in) {
        originalTitle = in.readString();
        moviePosterImageThumbnail = in.readString();
        overview = in.readString();
        userRating = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<MovieData> CREATOR = new Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel in) {
            return new MovieData(in);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getMoviePosterImageThumbnail() {
        return moviePosterImageThumbnail;
    }

    public String getOverview() {
        return overview;
    }

    public String getUserRating() {
        return userRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(originalTitle);
        parcel.writeString(moviePosterImageThumbnail);
        parcel.writeString(overview);
        parcel.writeString(userRating);
        parcel.writeString(releaseDate);
    }
}
