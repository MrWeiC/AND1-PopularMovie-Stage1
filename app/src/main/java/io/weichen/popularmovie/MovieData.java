package io.weichen.popularmovie;

public class MovieData {
    String originalTitle;
    String moviePosterImageThumbnail;
    String overview;
    String userRating;
    String releaseDate;

    public MovieData(String originalTitle, String moviePosterImageThumbnail, String overview, String userRating, String releaseDate) {
        this.originalTitle = originalTitle;
        this.moviePosterImageThumbnail = moviePosterImageThumbnail;
        this.overview = overview;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
    }
}
