package com.yangjian.service.mobileFood;

import com.yangjian.entities.MobileFoodFacilityPermit;

import java.util.List;

/**
 * ClassName : MobileFoodService
 * Package : com.yangjian.service
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
public interface MobileFoodService {
    int add(MobileFoodFacilityPermit mobileFoodFacilityPermit);
    int delete(Integer locationId);
    int update(MobileFoodFacilityPermit mobileFoodFacilityPermit);
    MobileFoodFacilityPermit getById(Integer locationId);

    List<MobileFoodFacilityPermit> getAll();


    List<MobileFoodFacilityPermit> getAllForCondition(Object condition);

}
