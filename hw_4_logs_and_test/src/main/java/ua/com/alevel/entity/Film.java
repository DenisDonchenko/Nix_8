package ua.com.alevel.entity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Film extends BaseEntity {
    private String nameFilm;
    private String yearIssue;
    private LocalTime genre;

    public Film(String nameFilm, String yearIssue, LocalTime genre) {
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

    @Override
    public String toString() {
        return "Film{" +
                " id='" + super.getId() + '\'' +
                ", nameFilm='" + nameFilm + '\'' +
                ", yearIssue=" + yearIssue +
                ", genre='" + genre.format(DateTimeFormatter.ofPattern("H:mm")) + '\'' +
                '}';
    }
}
