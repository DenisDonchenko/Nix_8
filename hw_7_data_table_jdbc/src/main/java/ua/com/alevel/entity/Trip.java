package ua.com.alevel.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Trip extends BaseEntity {

    private String plane_name;

    private String town_to;

    private String town_out;

    private LocalTime time_out;

    private LocalTime time_in;

    private LocalDate date_in;

    private LocalDate date_out;
}
