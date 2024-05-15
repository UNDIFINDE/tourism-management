package com.yq.travelmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.travelmanagement.domain.Tourist;
import com.yq.travelmanagement.domain.TouristGroups;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 夜倾
 * @version 1.0
 */
@Mapper
public interface TouristDao extends BaseMapper<Tourist> {
}
