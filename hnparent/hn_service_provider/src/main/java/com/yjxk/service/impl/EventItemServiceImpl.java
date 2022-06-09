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
    //事件问题项分页查询
    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();//查询条件
        //完成分页查询，基于mybatis框架提供的分页助手插件完成
        PageHelper.startPage(currentPage,pageSize);
        //select * from t_checkitem limit 0,10
        Page<EventItem> page = eventItemDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<EventItem> rows = page.getResult();
        return new PageResult(total,rows);
    }
    //根据ID删除事件问题项
    @Override
    public void deleteById(Integer id) {

        eventItemDao.deleteById(id);
    }
    @Override
    public void edit(EventItem checkItem) {
        eventItemDao.edit(checkItem);
    }

    @Override
    public EventItem findById(Integer id) {
        return eventItemDao.findById(id);
    }

    @Override
    public List<EventItem> findAll() {
        return eventItemDao.findAll();
    }
}
