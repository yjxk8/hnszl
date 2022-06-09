package com.yjxk.dao;

import com.github.pagehelper.Page;
import com.yjxk.pojo.EventItem;

import java.util.List;

public interface EventItemDao {
    public void add(EventItem eventItem);
    public Page<EventItem> selectByCondition(String queryString);
    public List<EventItem> findAll();
    public void deleteById(Integer id);
    public void edit(EventItem checkItem);
    public EventItem findById(Integer id);
}