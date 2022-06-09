package com.yjxk.service;

import com.yjxk.entity.PageResult;
import com.yjxk.entity.QueryPageBean;
import com.yjxk.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public CheckGroup findById(Integer id);
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds);
}
