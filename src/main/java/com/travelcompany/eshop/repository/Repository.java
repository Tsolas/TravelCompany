package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Entities;
import java.util.List;

public interface Repository<T extends Entities> {

    //CRUD ACTIONS
    int create(T t);

    T read(int id);

    List<T> readAll();

    boolean delete(int id);

}
