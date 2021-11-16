package ua.com.alevel.dto.sessions;

import java.time.LocalDate;
import java.time.LocalTime;

public class SessionFindDto {
    private Long id;
    private String nameFilm;
    private LocalDate dateSession;
    private LocalTime timeStart;
    private LocalTime timeFinish;
    private String nameHall;

    public SessionFindDto() {
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
                "id=" + id +
                ", nameFilm='" + nameFilm + '\'' +
                ", dateSession=" + dateSession +
                ", timeStart=" + timeStart +
                ", timeFinish=" + timeFinish +
                ", nameHall='" + nameHall + '\'' +
                '}';
    }
}

