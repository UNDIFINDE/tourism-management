package com.yq.travelmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yq.travelmanagement.domain.TouristGroups;

import java.util.List;

/**
 * @author 夜倾
 * @version 1.0
 *      旅游团相关service
 */
public interface TouristGroupsService {

    int addTouristGroups(TouristGroups touristGroups);

    int deleteByName(String name);

    /**
     * 根据名字获取旅游团
     *
     * @param name 旅游团名称
     * @return 返回旅游团类对象
     */
    IPage<TouristGroups> selByName(Integer currentPage, Integer pageSize, String name);

    IPage<TouristGroups> selByAddress(Integer currentPage, Integer pageSize, String address);

    IPage<TouristGroups> selAll(Integer currentPage,Integer pageSize);

    /**
     * 根据id更新
     * @param touristGroups 旅游团对象
     * @return 返回影响的行数
     */
    int updateById(TouristGroups touristGroups);
}
