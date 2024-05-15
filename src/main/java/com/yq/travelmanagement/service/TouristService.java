package com.yq.travelmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yq.travelmanagement.domain.Guide;
import com.yq.travelmanagement.domain.Tourist;

import java.io.Serializable;

/**
 * @author 夜倾
 * @version 1.0
 *      游客service
 */
public interface TouristService {
    int addTourist(Tourist tourist);

    int deleteById(Serializable id);

    Tourist selById(Serializable id);

    IPage<Tourist> selByCard(Integer currentPage,Integer pageSize,String card);
    IPage<Tourist> selAll(Integer currentPage,Integer pageSize);

    int updateById(Tourist tourist);


}
