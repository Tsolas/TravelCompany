package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.Entities;
import com.travelcompany.eshop.repository.Repository;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl<T extends Entities> implements Repository<T> {

    private final List<T> list;

    public RepositoryImpl() {
        list = new ArrayList<>();
    }

    @Override
    public int create(T t) {
        list.add(t);
        return t.getId();
    }

    @Override
    public T read(int id) {
        for (T t : list) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public List<T> readAll() {
        return list;
    }

    @Override
    public boolean delete(int id) {
        T t = read(id);
        if (t != null) {
            list.remove(t);
            return true;
        }
        return false;
    }

}
