package com.yjxk.service;

import com.yjxk.entity.PageResult;
import com.yjxk.entity.QueryPageBean;
import com.yjxk.pojo.EventItem;

import java.util.List;

//服务接口
public interface EventItemService {
    public void add(EventItem eventItem);

    public List<EventItem> findAll();
}
