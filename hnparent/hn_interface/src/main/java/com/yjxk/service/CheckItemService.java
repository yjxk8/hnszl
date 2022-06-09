package com.yjxk.service;

import com.yjxk.entity.PageResult;
import com.yjxk.entity.QueryPageBean;
import com.yjxk.pojo.EventItem;

import java.util.List;

//服务接口
public interface CheckItemService {
    public void add(EventItem checkItem);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public void deleteById(Integer id);
    public void edit(EventItem checkItem);
    public EventItem findById(Integer id);
    public List<EventItem> findAll();
}
