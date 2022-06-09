package com.yjxk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yjxk.constant.MessageConstant;
import com.yjxk.entity.PageResult;
import com.yjxk.entity.QueryPageBean;
import com.yjxk.entity.Result;
import com.yjxk.pojo.EventItem;
import com.yjxk.service.CheckItemService;
import com.yjxk.service.EventItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 事件问题管理
 */

@RestController
@RequestMapping("/eventitem")
public class EventItemController {
    @Reference//查找服务
    private EventItemService eventItemService;

    //新增事件问题项
    @RequestMapping("/add")
    public Result add(@RequestBody EventItem eventItem){
        try{
            eventItemService.add(eventItem);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return  new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    //事件问题项分页查询
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = eventItemService.pageQuery(queryPageBean);
        return pageResult;
    }

    //删除事件问题项
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try{
            eventItemService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return  new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }
    //编辑检查项
    @RequestMapping("/edit")
    public Result edit(@RequestBody EventItem checkItem){
        try{
            eventItemService.edit(checkItem);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.EDIT_CHECKITEM_FAIL);
        }
        return  new Result(true, MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try{
            EventItem checkItem = eventItemService.findById(id);
            return  new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }
    @RequestMapping("/findAll")
    public Result findAll(){
        try{
            List<EventItem> list = eventItemService.findAll();
            return  new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,list);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }
}
