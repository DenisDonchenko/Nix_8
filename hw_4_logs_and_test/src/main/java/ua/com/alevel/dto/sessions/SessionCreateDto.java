package ua.com.alevel.dto.sessions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SessionCreateDto {
    private Long idFilm;
    private Long idHall;

    private LocalDate dateSession;
    private LocalTime timeStart;

    public SessionCreateDto(Long idFilm, Long idHall, LocalDate dateSession,
                            LocalTime timeStart
                            ) {
        this.idFilm = idFilm;
        this.idHall = idHall;
        this.dateSession = dateSession;
        this.timeStart = timeStart;
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

   }
