package com.das.consultation.mapper.mobilebi;

import com.das.consultation.entities.vo.mobilebi.FuYouZyzdVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:45
 */
@Mapper
public interface FuYouZyzdMapper {

    List<FuYouZyzdVO> queryZyzdList();

    int insertList(@Param("fuYouZyzdVOList") List<FuYouZyzdVO> fuYouZyzdVOList);

}
