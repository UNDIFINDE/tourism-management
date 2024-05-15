package com.yq.travelmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yq.travelmanagement.comment.Code;
import com.yq.travelmanagement.comment.Result;
import com.yq.travelmanagement.domain.TouristGroups;
import com.yq.travelmanagement.service.TouristGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 夜倾
 * @version 1.0
 */
@RestController
@RequestMapping("/touristGroup")
public class TouristGroupsController {
    @Autowired
    private TouristGroupsService service;

    /**
     *  旅游团新增功能
     * @param touristGroups 旅游团对象
     * @return  封装好的结果信息
     */
    @PostMapping("/add")
    public Result addTouristGroups(@RequestBody TouristGroups touristGroups){
        int i = service.addTouristGroups(touristGroups);
        boolean flag=i>0;
        return (flag? (new Result(Code.SAVE_OK,"新增成功",i) )
                     :(new Result(Code.SAVE_ERR,"新增失败",i)));
    }


    @GetMapping("/deleteByName/{name}")
    public Result deleteByName(@PathVariable String name){
        int i = service.deleteByName(name);
        boolean flag=i>0;
        return (flag? (new Result(Code.DELETE_OK,"删除成功",i) )
                :(new Result(Code.DELETE_ERR,"删除失败",i)));
    }

    /**
     * 根据名字获取旅游团
     * @param name 旅游团名称
     * @return 返回旅游团类对象
     */
    @GetMapping("/getByName/{currentPage}/{pageSize}/{name}")
    public Result selByName(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@PathVariable String name){
        IPage<TouristGroups> tgp = service.selByName(currentPage, pageSize, name);
        boolean flag= tgp.getTotal()>0;
        return (flag? (new Result(Code.SELECT_OK,"查询成功",tgp) )
                :(new Result(Code.SELECT_ERR,"查询失败",tgp)));
    }

    /**
     * 根据地址查询
     * @param address 地址值
     * @return  返回结果集
     */
    @GetMapping("/getByAddress/{currentPage}/{pageSize}/{address}")
    public Result selByAddress(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@PathVariable String address){
        IPage<TouristGroups> tgp = service.selByAddress(currentPage, pageSize, address);

        boolean flag= tgp.getTotal()>0;
        return (flag? (new Result(Code.SELECT_OK,"查询成功",tgp) )
                :(new Result(Code.SELECT_ERR,"查询失败",tgp)));
    }

    @GetMapping("/getAll/{currentPage}/{pageSize}")
    public Result selAll(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<TouristGroups> tgp = service.selAll(currentPage, pageSize);
        boolean flag= tgp.getTotal()>0;
        return (flag? (new Result(Code.SELECT_OK,"查询成功",tgp) )
                :(new Result(Code.SELECT_ERR,"查询失败",tgp)));
    }

    @PostMapping("/update")
    public Result updateById(@RequestBody TouristGroups touristGroups){
        int i = service.updateById(touristGroups);
        boolean flag=i>0;
        return (flag? (new Result(Code.UPDATE_OK,"更新成功",i) )
                :(new Result(Code.UPDATE_ERR,"更新失败",i)));
    }
}
