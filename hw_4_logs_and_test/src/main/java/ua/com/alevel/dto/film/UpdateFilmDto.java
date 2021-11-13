package ua.com.alevel.dto.film;

import java.time.LocalTime;

public class UpdateFilmDto {

    private Long id;
    private String nameFilm;
    private String yearIssue;
    private LocalTime filmDuration;

    public UpdateFilmDto(Long id, String nameFilm, String yearIssue, LocalTime filmDuration) {
        this.id = id;
        this.nameFilm = nameFilm;
        this.yearIssue = yearIssue;
        this.filmDuration = filmDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setFilmDuration(LocalTime genre) {
        this.filmDuration = filmDuration;
    }
}
