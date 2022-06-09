package com.yjxk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yjxk.dao.CheckItemDao;
import com.yjxk.entity.PageResult;
import com.yjxk.entity.QueryPageBean;
import com.yjxk.pojo.EventItem;
import com.yjxk.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查项服务
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    //注入DAO对象
    @Autowired
    private CheckItemDao checkItemDao;
    @Override
    public void add(EventItem checkItem) {
        checkItemDao.add(checkItem);
    }

    //检查项分页查询
    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();//查询条件
        //完成分页查询，基于mybatis框架提供的分页助手插件完成
        PageHelper.startPage(currentPage,pageSize);
        //select * from t_checkitem limit 0,10
        Page<EventItem> page = checkItemDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<EventItem> rows = page.getResult();
        return new PageResult(total,rows);
    }

    //根据ID删除检查项
    @Override
    public void deleteById(Integer id) {
        //判断当前检查项是否已经关联到检查组
        long count = checkItemDao.findCountByCheckItemId(id);
        if(count > 0){
            //当前检查项已经被关联到检查组，不允许删除
            new RuntimeException();
        }
        checkItemDao.deleteById(id);
    }

    @Override
    public void edit(EventItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    @Override
    public EventItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    @Override
    public List<EventItem> findAll() {
        return checkItemDao.findAll();
    }
}
