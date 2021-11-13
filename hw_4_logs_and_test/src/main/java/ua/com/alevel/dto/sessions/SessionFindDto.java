package ua.com.alevel.dto.sessions;

import ua.com.alevel.util.ConstGlobal;

import java.time.LocalDate;
import java.time.LocalTime;

public class SessionFindDto {

    private String nameFilm;
    private LocalDate dateSession;
    private LocalTime timeStart;
    private LocalTime timeFinish;
    private String nameHall;


    public SessionFindDto() {
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
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

    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }

    @Override
    public String toString() {
        return "SessionFindDto{" +
                "Name film -'" + nameFilm + '\'' +
                ", date session - " + dateSession.format(ConstGlobal.DATE_FORMATTER) +
                ", show start time - " + timeStart.format(ConstGlobal.TIME_FORMATTER) +
                ", show finish time - " + timeFinish.format(ConstGlobal.TIME_FORMATTER) +
                ", name hall - '" + nameHall + '\'' +
                '}';
    }
}

