package com.yangjian.service.redis.geo.impl;

import com.yangjian.resp.ResultData;
import com.yangjian.service.redis.geo.GeoService;
import jakarta.annotation.Resource;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName : GeoService
 * Package : com.yangjian.service.redis.geo
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
@Service
public class GeoServiceImpl implements GeoService {
    public static final String MOBILE_POINT_NAME = "mobilePos";

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String  geoAdd(Map<String, Point> map) {
        redisTemplate.opsForGeo().add(MOBILE_POINT_NAME, map);
        return  map.toString() ;
    }

    @Override
    public Point position(String member) {
        List<Point> position = redisTemplate.opsForGeo().position(MOBILE_POINT_NAME, member);

        if (position != null) {
            return position.get(0);
        }
        return null;
    }

    @Override
    public String hash(String member) {
        List<String> list = redisTemplate.opsForGeo().hash(MOBILE_POINT_NAME, member);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Distance distance(String member1, String member2) {
        return redisTemplate.opsForGeo().distance(MOBILE_POINT_NAME,
                member1,
                member2,
                RedisGeoCommands.DistanceUnit.KILOMETERS);
    }

    @Override
    public GeoResults radiusByxy(double longitude, double latitude, int count) {
        Circle circle = new Circle(longitude, latitude, Metrics.KILOMETERS.getMultiplier());
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands
                .GeoRadiusCommandArgs
                .newGeoRadiusArgs()
                .includeDistance()
                .includeCoordinates()
                .sortDescending()
                .limit(count);
        return redisTemplate.opsForGeo().radius(MOBILE_POINT_NAME, circle, args);
    }

    @Override
    public GeoResults radiusByMember(String member, double distance, int count) {
        Distance distance1 = new Distance(distance, Metrics.MILES);
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending().limit(count);
        return redisTemplate.opsForGeo().radius(MOBILE_POINT_NAME, member, distance1, args);
    }

    @Override
    public boolean delete() {
        return redisTemplate.delete(MOBILE_POINT_NAME);
    }
}
