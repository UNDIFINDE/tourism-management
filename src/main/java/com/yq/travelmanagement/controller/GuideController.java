package com.yq.travelmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yq.travelmanagement.comment.Code;
import com.yq.travelmanagement.comment.Result;
import com.yq.travelmanagement.domain.Guide;
import com.yq.travelmanagement.service.GuideService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @author 夜倾
 * @version 1.0
 */
@RestController
@RequestMapping("/guide")
public class GuideController {
    @Autowired
    private GuideService service;

    @PostMapping("/addGuide")
    public Result addGuide(@RequestBody Guide guide){
        int i = service.addGuide(guide);
        boolean flag = i>0;
        return ((flag)?(new Result(Code.SAVE_OK,"新增成功",i))
                      :(new Result(Code.SAVE_ERR,"新增失败",i)));
    }

    @GetMapping("/delById/{gid}")
    public Result delById(@PathVariable Serializable gid){
        int i = service.delById(gid);
        boolean flag = i>0;
        return ((flag)?(new Result(Code.DELETE_OK,"删除成功",i))
                :(new Result(Code.DELETE_ERR,"删除失败",i)));
    }

    @GetMapping("/selById/{id}")
    public Result selById(@PathVariable Serializable id){
        Guide guide = service.selById(id);
        boolean flag = guide!=null;
        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",guide))
                :(new Result(Code.SELECT_ERR,"查询失败",guide)));
    }

    @GetMapping("/selByName/{currentPage}/{pageSize}/{name}")
    public Result selByName(@PathVariable Integer currentPage
                            ,@PathVariable Integer pageSize
                            ,@PathVariable String name){
        IPage<Guide> guideIPage = service.selByName(currentPage, pageSize, name);
        boolean flag = guideIPage.getTotal()>0;

        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",guideIPage))
                :(new Result(Code.SELECT_ERR,"查询失败",guideIPage)));
    }

    @GetMapping("/selByAddress/{currentPage}/{pageSize}/{address}")
    public Result selByAddress(@PathVariable Integer currentPage
            ,@PathVariable Integer pageSize
            ,@PathVariable String address){
        IPage<Guide> guideIPage = service.selByAddress(currentPage, pageSize, address);
        boolean flag = guideIPage.getTotal()>0;

        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",guideIPage))
                :(new Result(Code.SELECT_ERR,"查询失败",guideIPage)));
    }

    @GetMapping("/selAll/{currentPage}/{pageSize}")
    public Result selAll(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Guide> guideIPage = service.selAll(currentPage, pageSize);
        boolean flag = guideIPage.getTotal()>0;

        return ((flag)?(new Result(Code.SELECT_OK,"查询成功",guideIPage))
                :(new Result(Code.SELECT_ERR,"查询失败",guideIPage)));
    }

    @PostMapping("/update")
    public Result updateById(@RequestBody Guide guide){
        int i = service.updateById(guide);
        boolean flag = i>0;
        return ((flag)?(new Result(Code.UPDATE_OK,"修改成功",i))
                :(new Result(Code.UPDATE_ERR,"修改失败",i)));
    }


}
