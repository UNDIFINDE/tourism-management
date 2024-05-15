package com.yq.travelmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.travelmanagement.dao.GroupPurchaseDao;
import com.yq.travelmanagement.dao.TouristGroupsDao;
import com.yq.travelmanagement.domain.GroupPurchaseRecord;
import com.yq.travelmanagement.domain.TouristGroups;
import com.yq.travelmanagement.service.GroupPurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author 夜倾
 * @version 1.0
 */
@Service
public class GroupPurchaseRecordServiceImpl implements GroupPurchaseRecordService {

    @Autowired
    private GroupPurchaseDao dao;
    @Autowired
    private TouristGroupsDao tgDao;

    /**
     *  游客团购下单
     * @param gpr 团购记录对象
     * @return  影响的行数
     */
    @Override
    public int addOrder(GroupPurchaseRecord gpr) {
        //封装条件查询旅游团的价格
        LambdaQueryWrapper<TouristGroups> lqw = new LambdaQueryWrapper<>();
        //得到旅游团对象
        TouristGroups tg = tgDao.selectById(gpr.getTgId());
        System.out.println("tg对象........"+gpr.getTgId());
        //把旅游团的价格给到当前记录中
        gpr.setCost(tg.getPrice());

        return dao.insert(gpr);
    }

    @Override
    public int deleteOrder(Serializable id) {
        return dao.deleteById(id);
    }

    @Override
    public GroupPurchaseRecord getGprById(Serializable id) {
        return dao.selectById(id);
    }

    @Override
    public IPage<GroupPurchaseRecord> getOrderAll(Integer currentPage,Integer pageSize) {
        IPage<GroupPurchaseRecord> gpr = new Page<>(currentPage,pageSize);

        return dao.selectPage(gpr,null);
    }

    @Override
    public int updateOrder(GroupPurchaseRecord gpr) {
        return dao.updateById(gpr);
    }
}
