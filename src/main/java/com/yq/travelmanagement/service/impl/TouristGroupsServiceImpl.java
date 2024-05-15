package com.yq.travelmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.travelmanagement.dao.TouristGroupsDao;
import com.yq.travelmanagement.domain.TouristGroups;
import com.yq.travelmanagement.service.TouristGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 夜倾
 * @version 1.0
 */
@Service
public class TouristGroupsServiceImpl implements TouristGroupsService {
    @Autowired
    private TouristGroupsDao dao;


    @Override
    public int addTouristGroups(TouristGroups touristGroups) {
        int i=0;
        if (touristGroups.getTgId()==null){
            touristGroups.setTgId(0);
        }
        try{
         i = dao.insert(touristGroups);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
        return i;
    }

    @Override
    public int deleteByName(String name) {
        LambdaQueryWrapper<TouristGroups> lqw = new LambdaQueryWrapper<>();
        lqw.eq(TouristGroups::getTgName,name);
        return dao.delete(lqw);
    }

    @Override
    public IPage<TouristGroups> selByName(Integer currentPage, Integer pageSize, String name) {
        //创建条件对象
        LambdaQueryWrapper<TouristGroups> lqw = new LambdaQueryWrapper<TouristGroups>();
        //封装查询条件
        lqw.like(TouristGroups::getTgName,name);

        Page<TouristGroups> tg = new Page<>(currentPage,pageSize);
        return dao.selectPage(tg,lqw);
    }

    @Override
    public IPage<TouristGroups> selByAddress(Integer currentPage, Integer pageSize, String address) {
        LambdaQueryWrapper<TouristGroups> lqw = new LambdaQueryWrapper<>();
        lqw.like(TouristGroups::getAddress,address);
        Page<TouristGroups> tg = new Page<>(currentPage,pageSize);
        return dao.selectPage(tg,lqw);
    }

    @Override
    public IPage<TouristGroups> selAll(Integer currentPage, Integer pageSize) {
        Page<TouristGroups> tg = new Page<>(currentPage,pageSize);
        return dao.selectPage(tg,null);
    }

    @Override
    public int updateById(TouristGroups touristGroups) {

        LambdaQueryWrapper<TouristGroups> lqw = new LambdaQueryWrapper<>();
        //使用乐观锁此处必须封装查询条件
        lqw.eq(TouristGroups::getTgId,touristGroups.getTgId());

        return dao.update(touristGroups,lqw);
    }
}
