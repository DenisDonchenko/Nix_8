package ua.com.alevel.entity;

import lombok.Data;

@Data
public class Passenger extends BaseEntity{

    private String first_name;

    private String last_name;
}
