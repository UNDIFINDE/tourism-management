package com.yq.travelmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.travelmanagement.dao.GuideDao;
import com.yq.travelmanagement.domain.Guide;
import com.yq.travelmanagement.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author 夜倾
 * @version 1.0
 */
@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    private GuideDao dao;
    @Override
    public int addGuide(Guide guide) {
        if (guide.getGid()==null){
            guide.setGid(0);
        }
        return dao.insert(guide);
    }

    @Override
    public int delById(Serializable gid) {
        LambdaQueryWrapper<Guide> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Guide::getGid,gid);
        return dao.delete(lqw);
    }

    @Override
    public Guide selById(Serializable id) {
        return dao.selectById(id);
    }

    /**
     * 根据名字查询   分页查询
     * @param currentPage 当前页码
     * @param pageSize    每页显示的个数
     * @param name        导游名称
     * @return  分页对象
     */
    @Override
    public IPage<Guide> selByName(Integer currentPage, Integer pageSize,String name) {
        LambdaQueryWrapper<Guide> lqw = new LambdaQueryWrapper<>();
        lqw.like(Guide::getName,name);
        IPage<Guide> guidePage = new Page<>(currentPage,pageSize);

        return dao.selectPage(guidePage,lqw);
    }

    @Override
    public IPage<Guide> selByAddress(Integer currentPage, Integer pageSize, String address) {
        LambdaQueryWrapper<Guide> lqw = new LambdaQueryWrapper<>();
        lqw.like(Guide::getAddress,address);
        IPage<Guide> guidePage = new Page<>(currentPage,pageSize);

        return dao.selectPage(guidePage,lqw);
    }

    /**
     * 无条件查询 分页查询
     * @param currentPage 当前页码
     * @param pageSize    显示条数
     * @return  分页对象
     */
    @Override
    public IPage<Guide> selAll(Integer currentPage, Integer pageSize) {
        IPage<Guide> guidePage = new Page<>(currentPage,pageSize);

        return dao.selectPage(guidePage,null);
    }

    @Override
    public int updateById(Guide guide) {
        return dao.updateById(guide);
    }
}
