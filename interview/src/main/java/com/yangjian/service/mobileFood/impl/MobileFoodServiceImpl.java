package com.yangjian.service.mobileFood.impl;

import com.yangjian.entities.MobileFoodFacilityPermit;
import com.yangjian.mapper.MobileFoodFacilityPermitMapper;
import com.yangjian.service.mobileFood.MobileFoodService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName : MobileFoodServiceImpl
 * Package : com.yangjian.service.impl
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
@Service
public class MobileFoodServiceImpl implements MobileFoodService {

    @Resource
    private MobileFoodFacilityPermitMapper mobileFoodFacilityPermitMapper;
    @Override
    public int add(MobileFoodFacilityPermit mobileFoodFacilityPermit) {
        return mobileFoodFacilityPermitMapper.insert(mobileFoodFacilityPermit);
    }

    @Override
    public int delete(Integer locationId) {
        return mobileFoodFacilityPermitMapper.deleteByPrimaryKey(locationId);
    }

    @Override
    public int update(MobileFoodFacilityPermit mobileFoodFacilityPermit) {
        return mobileFoodFacilityPermitMapper.updateByPrimaryKeySelective(mobileFoodFacilityPermit);
    }

    @Override
    public MobileFoodFacilityPermit getById(Integer locationId) {
        return mobileFoodFacilityPermitMapper.selectByPrimaryKey(locationId);
    }

    @Override
    public List<MobileFoodFacilityPermit> getAll() {
        return mobileFoodFacilityPermitMapper.selectAll();
    }

    @Override
    public List<MobileFoodFacilityPermit> getAllForCondition(Object condition) {
        return mobileFoodFacilityPermitMapper.selectByExample(condition);
    }
}
