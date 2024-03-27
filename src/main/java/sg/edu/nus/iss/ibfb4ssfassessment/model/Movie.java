package sg.edu.nus.iss.ibfb4ssfassessment.model;

import java.util.Date;

public class Movie {

    private int movieID;
    private String title;
    private String year;
    private String rated;
    private Long releaseDate;
    private String runTime;
    private String genre;
    private String director;
    private Double rating;
    private Date formattedReleaseDate;
    private int count;

    public Movie(int movieID, String title, String year, String rated, Long releaseDate, String runTime, String genre,
            String director, Double rating, int count) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.releaseDate = releaseDate;
        this.runTime = runTime;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.count = count;
    }

    public Movie(){
    }

    public int getMovieID() {
        return movieID;
    }
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getRated() {
        return rated;
    }
    public void setRated(String rated) {
        this.rated = rated;
    }
    public Long getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Long releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getRunTime() {
        return runTime;
    }
    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Date getFormattedReleaseDate() {
        return formattedReleaseDate;
    }
    public void setFormattedReleaseDate(Date formattedReleaseDate) {
        this.formattedReleaseDate = formattedReleaseDate;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Movie [movieID=" + movieID + ", title=" + title + ", year=" + year + ", rated=" + rated
                + ", releaseDate=" + releaseDate + ", runTime=" + runTime + ", genre=" + genre + ", director="
                + director + ", rating=" + rating + ", formattedReleaseDate=" + formattedReleaseDate + ", count="
                + count + "]";
    }
    
}
