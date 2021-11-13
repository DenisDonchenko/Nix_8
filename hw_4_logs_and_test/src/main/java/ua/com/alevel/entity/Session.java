package ua.com.alevel.entity;

import ua.com.alevel.util.ConstGlobal;

import java.time.LocalDate;
import java.time.LocalTime;

public class Session extends BaseEntity {

    private Long idFilm;
    private Long idHall;

    private LocalDate dateSession;
    private LocalTime timeStart;
    private LocalTime timeFinish;
    private int freePlaces;

        public Session(Long idFilm, Long idHall, LocalDate dateSession,
                       LocalTime timeStart, LocalTime timeFinish, int freePlaces) {
        this.idFilm = idFilm;
        this.idHall = idHall;
        this.dateSession = dateSession;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.freePlaces = freePlaces;
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public Long getIdHall() {
        return idHall;
    }

    public void setIdHall(Long idHall) {
        this.idHall = idHall;
    }

    public LocalDate getDateSession() {
        return dateSession;
    }

    public void setDateSession(LocalDate dateSession) {
        this.dateSession = dateSession;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(LocalTime timeFinish) {
        this.timeFinish = timeFinish;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    @Override
    public String toString() {
        return "\"Session\" : {" +
                "\n   \"id\": " + super.getId() +
                "\n   \"idFilm\": " + idFilm +
                "\n   \"idHall\": " + idHall +
                "\n   \"dateSession\": " + dateSession.format(ConstGlobal.DATE_FORMATTER) +
                "\n   \"timeStart\": " + timeStart.format(ConstGlobal.TIME_FORMATTER) +
                "\n   \"timeFinish\": " + timeFinish.format(ConstGlobal.TIME_FORMATTER) +
                "\n   \"freePlaces\": " + freePlaces +
                "\n}";
    }
}
