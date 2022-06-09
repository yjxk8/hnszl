package com.yjxk.dao;

import com.github.pagehelper.Page;
import com.yjxk.pojo.EventItem;

import java.util.List;

public interface EventItemDao {
    public void add(EventItem eventItem);

    public List<EventItem> findAll();
}