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

    //新增检查项
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
