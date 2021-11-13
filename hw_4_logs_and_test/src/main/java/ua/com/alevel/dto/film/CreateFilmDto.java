package ua.com.alevel.dto.film;

import java.time.LocalTime;

public class CreateFilmDto {

    private String nameFilm;
    private String yearIssue;
    private LocalTime filmDuration;

    public CreateFilmDto( String nameFilm, String yearIssue, LocalTime filmDuration) {
        this.nameFilm = nameFilm;
        this.yearIssue = yearIssue;
        this.filmDuration = filmDuration;
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

    public LocalTime getFilmDuration() {
        return filmDuration;
    }

    public void setFilmDuration(LocalTime filmDuration) {
        this.filmDuration = filmDuration;
    }
}
