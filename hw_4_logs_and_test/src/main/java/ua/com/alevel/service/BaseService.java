package ua.com.alevel.service;


import ua.com.alevel.entity.BaseEntity;

public interface BaseService <ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(Long id);
    ENTITY findById(Long id);
    ENTITY[] findAll();
}
