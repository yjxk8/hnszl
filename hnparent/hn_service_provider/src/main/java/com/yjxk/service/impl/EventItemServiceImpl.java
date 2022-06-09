package com.yjxk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yjxk.dao.CheckItemDao;
import com.yjxk.dao.EventItemDao;
import com.yjxk.entity.PageResult;
import com.yjxk.entity.QueryPageBean;
import com.yjxk.pojo.EventItem;
import com.yjxk.service.CheckItemService;
import com.yjxk.service.EventItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查项服务
 */
@Service(interfaceClass = EventItemService.class)
@Transactional
public class EventItemServiceImpl implements EventItemService {
    //注入DAO对象
    @Autowired
    private EventItemDao eventItemDao;
    @Override
    public void add(EventItem eventItem) {
        eventItemDao.add(eventItem);
    }

    @Override
    public List<EventItem> findAll() {
        return eventItemDao.findAll();
    }
}
