package com.yq.travelmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.travelmanagement.dao.TouristDao;
import com.yq.travelmanagement.domain.Guide;
import com.yq.travelmanagement.domain.Tourist;
import com.yq.travelmanagement.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author 夜倾
 * @version 1.0
 */
@Service
public class TouristServiceImpl implements TouristService {
    @Autowired
    private TouristDao dao;
    @Override
    public int addTourist(Tourist tourist) {
        if (tourist.getTid()==null){
            tourist.setTid(0);
        }
        return dao.insert(tourist);
    }

    @Override
    public int deleteById(Serializable id) {
        return dao.deleteById(id);
    }

    @Override
    public Tourist selById(Serializable id) {
        LambdaQueryWrapper<Tourist> lqw = new LambdaQueryWrapper<Tourist>();
        lqw.eq(Tourist::getTid,id);
        return dao.selectOne(lqw);
    }

    @Override
    public IPage<Tourist> selByCard(Integer currentPage,Integer pageSize,String card) {
        LambdaQueryWrapper<Tourist> lqw = new LambdaQueryWrapper<>();
//        lqw.like(Tourist::getCard,card);
//        此处的左右表示模糊查询的%的位置
        lqw.likeRight(Tourist::getCard,card);

        IPage<Tourist> touristPage = new Page<>(currentPage,pageSize);
        return dao.selectPage(touristPage,lqw);
    }

    @Override
    public IPage<Tourist> selAll(Integer currentPage, Integer pageSize) {
        Page<Tourist> touristPage = new Page<>(currentPage,pageSize);

        return dao.selectPage(touristPage,null);
    }

    @Override
    public int updateById(Tourist tourist) {
        return dao.updateById(tourist);
    }
}
