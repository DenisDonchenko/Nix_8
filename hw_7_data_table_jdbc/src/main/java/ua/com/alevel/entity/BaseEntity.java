package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity {
    private Date created;
    private Date updated;
    private Long id;

    public BaseEntity() {
        this.created = new Date();
        this.updated = new Date();
    }
}
