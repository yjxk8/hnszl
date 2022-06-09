package com.yjxk.dao;

import com.github.pagehelper.Page;
import com.yjxk.pojo.EventItem;

import java.util.List;

public interface CheckItemDao {
    public void add(EventItem checkItem);
    public Page<EventItem> selectByCondition(String queryString);
    public long findCountByCheckItemId(Integer id);
    public void deleteById(Integer id);
    public void edit(EventItem checkItem);
    public EventItem findById(Integer id);
    public List<EventItem> findAll();
}