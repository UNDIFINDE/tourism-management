package com.yq.travelmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yq.travelmanagement.domain.Guide;

import java.io.Serializable;
import java.util.List;

/**
 * @author 夜倾
 * @version 1.0
 *      导游相关service
 */
public interface GuideService {
    /**
     * 新增
     * @param guide 导游对象
     * @return 影响的行数
     */
    int addGuide(Guide guide);

    /**
     * 逻辑删除
     * @param id 导游id
     * @return 影响的行数
     */
    int delById(Serializable id);

    /**
     * 查询
     * @param id id
     * @return 导游对象
     */
    Guide selById(Serializable id);

    IPage<Guide> selByName(Integer currentPage,Integer pageSize,String name);
    IPage<Guide> selByAddress(Integer currentPage,Integer pageSize,String address);
    IPage<Guide> selAll(Integer currentPage,Integer pageSize);


    int updateById(Guide guide);


}
