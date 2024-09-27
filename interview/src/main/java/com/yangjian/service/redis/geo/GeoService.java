package com.yangjian.service.redis.geo;

import org.springframework.data.geo.*;

import java.util.Map;

/**
 * ClassName : GeoService
 * Package : com.yangjian.service.redis.geo
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
public interface GeoService {

    /**
     * 删除geo数据
     * @return
     */
    boolean delete();

    /**
     * 存储经纬度坐标
     * @param map pointName:Point
     * @return
     */
    String geoAdd(Map<String, Point> map);

    /**
     * 根据名称获取经纬度
     * @param member pointName
     * @return
     */
    Point position(String member);

    /**
     * 通过名称，获取hash表示经纬度
     * @param member pointName
     * @return
     */
    String hash(String member);

    /**
     * 获取两个点位之间的距离
     * @param member1 pointName
     * @param member2 pointName
     * @return
     */
    Distance distance(String member1, String member2);

    /**
     * 根据指定的Point，获取附近的 memberInfo
     * @param longitude 精度
     * @param latitude 维度
     * @param count 返回个数
     * @return GeoResults
     */
    GeoResults radiusByxy(double longitude, double latitude, int count);

    /**
     * 通过成员查找附件 PointInfo
     * @param member member
     * @param distance
     * @param count  返回 限制个数
     * @return GeoResults
     */
     GeoResults radiusByMember(String member, double distance, int count);
}
