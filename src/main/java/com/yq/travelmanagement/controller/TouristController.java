package com.yq.travelmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yq.travelmanagement.comment.Code;
import com.yq.travelmanagement.comment.Result;
import com.yq.travelmanagement.domain.Tourist;
import com.yq.travelmanagement.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @author 夜倾
 * @version 1.0
 */
@RestController
@RequestMapping("/tourist")
public class TouristController {
    @Autowired
    private TouristService service;

    @PostMapping("/addTourist")
    public Result addTourist(@RequestBody Tourist tourist){
        int i = service.addTourist(tourist);
        boolean flag = i>0;

        return ((flag)?(new Result(Code.SAVE_OK,"新增成功",i))
                :(new Result(Code.SAVE_ERR,"新增失败",i)));
    }

    @GetMapping("/delete/{id}")
    public Result deleteById(@PathVariable Serializable id){
        int i = service.deleteById(id);
        boolean flag = i>0;

        return ((flag)?(new Result(Code.DELETE_OK,"删除成功",i))
                :(new Result(Code.DELETE_ERR,"删除失败",i)));
    }

    @GetMapping("/selById/{id}")
    public Result selById(@PathVariable Serializable id){
        Tourist tourist = service.selById(id);
        boolean flag = tourist!=null;
        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",tourist))
                :(new Result(Code.SELECT_ERR,"查询失败",tourist)));
    }

    @GetMapping("selByCard/{currentPage}/{pageSize}/{card}")
    public Result selByCard(@PathVariable Integer currentPage
            ,@PathVariable Integer pageSize
            ,@PathVariable String card){
        IPage<Tourist> touristIPage = service.selByCard(currentPage, pageSize, card);
        boolean flag = touristIPage.getTotal()>0;
        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",touristIPage))
                :(new Result(Code.SELECT_ERR,"查询失败",touristIPage)));
    }


    @GetMapping("selAll/{currentPage}/{pageSize}")
    public Result selAll(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Tourist> touristIPage = service.selAll(currentPage, pageSize);
        boolean flag = touristIPage.getTotal()>0;
        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",touristIPage))
                :(new Result(Code.SELECT_ERR,"查询失败",touristIPage)));
    }

    @PostMapping("/update")
    public Result updateById(@RequestBody Tourist tourist){
        int i = service.updateById(tourist);
        boolean flag = i>0;
        return ((flag)?(new Result(Code.UPDATE_OK,"更新成功",i))
                :(new Result(Code.UPDATE_ERR,"更新失败",i)));
    }
}
