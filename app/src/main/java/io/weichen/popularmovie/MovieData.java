package io.weichen.popularmovie;

public class MovieData {
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

}
