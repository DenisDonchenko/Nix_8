package ua.com.alevel.dto.film;

import java.time.LocalTime;

public class CreateFilmDto {

    private String nameFilm;
    private String yearIssue;
    private LocalTime genre;

    public CreateFilmDto( String nameFilm, String yearIssue, LocalTime genre) {
        this.nameFilm = nameFilm;
        this.yearIssue = yearIssue;
        this.genre = genre;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getYearIssue() {
        return yearIssue;
    }

    public void setYearIssue(String yearIssue) {
        this.yearIssue = yearIssue;
    }

    public LocalTime getGenre() {
        return genre;
    }

    public void setGenre(LocalTime genre) {
        this.genre = genre;
    }
}
