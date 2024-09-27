package com.yangjian.controller;

import com.yangjian.entities.MobileFoodFacilityPermit;
import com.yangjian.resp.ResultData;
import com.yangjian.service.mobileFood.MobileFoodService;
import com.yangjian.service.redis.geo.GeoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName : GeoController
 * Package : com.yangjian.controller
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
@RestController
@Slf4j
@Tag(name = "位置服务模块", description = "位置查询相关")
public class GeoController {

    @Resource
    private GeoService geoService;

    @Resource
    private MobileFoodService mobileFoodService;

    @DeleteMapping(value = "geo/delAll")
    @Operation(summary = "删除点位信息", description = "删除已存储的所有点位")
    public ResultData<String> del() {
        boolean delete = geoService.delete();
        return ResultData.success(delete ? "delete success!" : "delete fail!");
    }

    @PostMapping(value = "/geo/init")
    @Operation(summary = "初始化点位信息", description = "用于数据初始化，已存在的点位删除，重新添加新的点位")
    public ResultData<String> initPoint() {
        List<MobileFoodFacilityPermit> foodServiceAll = mobileFoodService.getAll();

        Map<String, Point> map = new HashMap<>();
        for (MobileFoodFacilityPermit permit : foodServiceAll) {
            map.put(permit.getLocationid() + "", new Point(permit.getLongitude(), permit.getLatitude()));
        }

        String s = geoService.geoAdd(map);
        return ResultData.success("初始化数据成功！" + s);
    }

    @PostMapping(value = "/geo/add")
    @Operation(summary = "新增点位", description = "按照点位ID，经纬度一次添加一个或者多个")
    @Parameters(value = {@Parameter(name = "map", description = "点位信息", required = true)})
    public ResultData<String> addPoint(@RequestBody Map<String, Point> map) {
        String s = geoService.geoAdd(map);
        return ResultData.success(s);
    }

    @GetMapping(value = "/geo/distance")
    @Operation(summary = "计算点位距离", description = "计算两个点位之间的距离")
    @Parameters(value = {@Parameter(name = "locationId", description = "locationId"), @Parameter(name = "locationId2", description = "locationId")})
    public ResultData<Distance> getDistance(@RequestParam(name = "locationId") String locationId, @RequestParam(name = "locationId2") String locationId2) {
        Distance distance = geoService.distance(locationId, locationId2 + "");
        return ResultData.success(distance);
    }

    @GetMapping(value = "/geo/peopleNearByDistance")
    @Operation(summary = "查找附近点位", description = "按照距离查找附近点位")
    @Parameters(value = {@Parameter(name = "member", description = "locationId"), @Parameter(name = "distance", description = "距离范围(M)"), @Parameter(name = "count", description = "返回的数据条数，默认10"),})
    public ResultData<GeoResults> findPeopleByDistance(@RequestParam(name = "member") String member, @RequestParam(name = "distance") double distance, @RequestParam(name = "count", required = false, defaultValue = "10") int count) {
        GeoResults geoResults = geoService.radiusByMember(member, distance, count);
        return ResultData.success(geoResults);
    }

    @GetMapping(value = "/geo/peopleNear")
    @Parameters(value = {@Parameter(name = "longitude", description = "经度"), @Parameter(name = "latitude", description = "纬度"), @Parameter(name = "count", description = "返回的数据条数，默认10"),})
    @Operation(summary = "查找附近点位", description = "按照经纬度查找附近点位，默认返回10个点位信息")
    public ResultData<GeoResults> findPeople(@RequestParam(name = "longitude") double longitude, @RequestParam(name = "latitude") double latitude, @RequestParam(name = "count", required = false, defaultValue = "10") int count) {
        GeoResults geoResults = geoService.radiusByxy(longitude, latitude, count);
        return ResultData.success(geoResults);
    }


}
