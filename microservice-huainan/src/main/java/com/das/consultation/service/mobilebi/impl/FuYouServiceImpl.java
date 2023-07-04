package com.das.consultation.service.mobilebi.impl;

import com.das.consultation.entities.vo.mobilebi.FuYouZyzdVO;
import com.das.consultation.mapper.mobilebi.FuYouZyzdMapper;
import com.das.consultation.service.mobilebi.FuYouService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/1/26 16:12
 */
@Service
public class FuYouServiceImpl implements FuYouService {

    @Resource
    private FuYouZyzdMapper fuYouZyzdMapper;

    @Override
    public List<FuYouZyzdVO> queryZyzdList() {
        return fuYouZyzdMapper.queryZyzdList();
    }

    @Override
    public int insertList(List<FuYouZyzdVO> fuYouZyzdVOList) {
        return fuYouZyzdMapper.insertList(fuYouZyzdVOList);
    }
}
