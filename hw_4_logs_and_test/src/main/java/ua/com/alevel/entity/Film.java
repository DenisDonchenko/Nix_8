package ua.com.alevel.entity;

import ua.com.alevel.util.ConstGlobal;

import java.time.LocalTime;

public class Film extends BaseEntity {
    private String nameFilm;
    private String yearIssue;
    private LocalTime filmDuration;

    public Film(String nameFilm, String yearIssue, LocalTime filmDuration) {
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

    public void setYearIssue(String yearIssue) {
        this.yearIssue = yearIssue;
    }

    public LocalTime getFilmDuration() {
        return filmDuration;
    }

    public void setFilmDuration(LocalTime filmDuration) {
        this.filmDuration = filmDuration;
    }

    @Override
    public String toString() {
        return "\"Film\" : {" +
                "\n   \"id\": " + super.getId()  +
                "\n   \"nameFilm\": " + nameFilm  +
                "\n   \"yearIssue\": " + yearIssue +
                "\n   \"filmDuration\": " + filmDuration.format(ConstGlobal.TIME_FORMATTER)  +
                "\n}";
    }
}
