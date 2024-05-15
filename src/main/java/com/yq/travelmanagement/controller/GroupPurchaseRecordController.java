package com.yq.travelmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yq.travelmanagement.comment.Code;
import com.yq.travelmanagement.comment.Result;
import com.yq.travelmanagement.domain.GroupPurchaseRecord;
import com.yq.travelmanagement.service.GroupPurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @author 夜倾
 * @version 1.0
 */
@RestController
@RequestMapping("/gpr")
public class GroupPurchaseRecordController {
    @Autowired
    private GroupPurchaseRecordService service;

    @PostMapping("/addGpr")
    public Result addGpr(@RequestBody GroupPurchaseRecord gpr){
        int i = service.addOrder(gpr);
        boolean flag = i>0;
        return ((flag)?(new Result(Code.SAVE_OK,"新增成功",i))
                :(new Result(Code.SAVE_ERR,"新增失败",i)));
    }

    @GetMapping("/deletedOrder/{id}")
    public  Result deletedOrder(@PathVariable Serializable id){
        int i = service.deleteOrder(id);
        boolean flag = i>0;
        return ((flag)?(new Result(Code.DELETE_OK,"删除成功",i))
                :(new Result(Code.DELETE_ERR,"删除失败",i)));
    }


    @GetMapping("/getGprById/{id}")
    public Result getGprById(@PathVariable Serializable id){
        GroupPurchaseRecord gpr = service.getGprById(id);
        boolean flag = gpr!=null;
        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",gpr))
                :(new Result(Code.SELECT_ERR,"查询失败",gpr)));
    }

    @GetMapping("/getOrderAll/{currentPage}/{pageSize}")
    public Result getAll(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<GroupPurchaseRecord> orders = service.getOrderAll(currentPage, pageSize);
        boolean flag = orders!=null;
        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",orders))
                :(new Result(Code.SELECT_ERR,"查询失败",orders)));
    }

    @PostMapping("/update")
    public Result updateById(@RequestBody GroupPurchaseRecord gpr){
        int i = service.updateOrder(gpr);
        boolean flag = i>0;
        return ((flag)?(new Result(Code.UPDATE_OK,"修改成功",i))
                :(new Result(Code.UPDATE_ERR,"修改失败",i)));
    }

}
