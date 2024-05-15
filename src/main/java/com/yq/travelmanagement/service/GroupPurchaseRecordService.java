package com.yq.travelmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yq.travelmanagement.domain.GroupPurchaseRecord;

import java.io.Serializable;

/**
 * @author 夜倾
 * @version 1.0
 *          团购记录service
 */
public interface GroupPurchaseRecordService {

    /**
     * 游客订购旅游团
     * @param gpr 团购记录对象
     * @return 影响的行数
     */
    int addOrder(GroupPurchaseRecord gpr);

    /**
     *   取消订单-----根据id删除订单
     * @param id 订单id
     * @return  影响的行数
     */
    int deleteOrder(Serializable id);


    /**
     *  根据id查询订单
     * @param id 订单id
     * @return  订单记录
     */
    GroupPurchaseRecord getGprById(Serializable id);


    IPage<GroupPurchaseRecord> getOrderAll(Integer currentPage,Integer pageSize);


    int updateOrder(GroupPurchaseRecord gpr);
}
