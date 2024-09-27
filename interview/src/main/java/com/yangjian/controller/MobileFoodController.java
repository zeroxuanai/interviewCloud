package com.yangjian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangjian.entities.MobileFoodFacilityPermit;
import com.yangjian.request.SearchCondition;
import com.yangjian.resp.ResultData;
import com.yangjian.service.mobileFood.MobileFoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ClassName : MobileFoodController
 * Package : com.yangjian.controller
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
@RestController
@Slf4j
@Tag(name = "移动餐车查询服务", description = "支持CURD")
public class MobileFoodController {
    @Resource
    private MobileFoodService mobileFoodService;

    @PostMapping(value = "/interview/add")
    @Operation(summary = "新增", description = "新增数据，参数类型json")
    public ResultData<String> add(@RequestBody MobileFoodFacilityPermit mobileFoodFacilityPermit) {
        int i = mobileFoodService.add(mobileFoodFacilityPermit);
        return ResultData.success("正确插入 " + i + " 条数据");
    }

    @Operation(summary = "删除", description = "按照 locationId 删除")
    @DeleteMapping(value = "/interview/del/{locationId}")
    public ResultData<String> delete(@PathVariable("locationId") Integer locationId) {
        int i = mobileFoodService.delete(locationId);
        return ResultData.success("正确删除 " + i + " 条数据");
    }

    @Operation(summary = "更新", description = "参数类型，json对象")
    @PutMapping(value = "/interview/update")
    public ResultData<String> update(@RequestBody MobileFoodFacilityPermit mobileFoodFacilityPermit) {
        int i = mobileFoodService.update(mobileFoodFacilityPermit);
        return ResultData.success("正确修改 " + i + " 条数据");
    }

    @GetMapping(value = "/interview/get/{locationId}")
    @Operation(summary = "查询", description = "根据LocationId查询餐车信息")
    public ResultData<MobileFoodFacilityPermit> getById(@PathVariable("locationId") Integer locationId) {
        MobileFoodFacilityPermit permit = mobileFoodService.getById(locationId);
        return ResultData.success(permit);
    }

    @GetMapping(value = "/interview/get/all")
    @Operation(summary = "查询所有餐车信息", description = "查询所有餐车信息")
    public ResultData<PageInfo<MobileFoodFacilityPermit>> getAll(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MobileFoodFacilityPermit> foodServiceAll = mobileFoodService.getAll();
        PageInfo<MobileFoodFacilityPermit> pageInfo = new PageInfo<>(foodServiceAll);
        return ResultData.success(pageInfo);
    }

    @Operation(summary = "条件查询", description = "查询条件为status、facilitytype、fooditems ，其中fooditems为关键字模糊匹配")
    @PostMapping(value = "/interview/get")
    public ResultData<PageInfo<MobileFoodFacilityPermit>> getAllByCondition(@RequestBody SearchCondition searchCondition) {

        Example example = new Example(MobileFoodFacilityPermit.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", searchCondition.getStatus())
                .andLike("fooditems", "%" + searchCondition.getKeyword() + "%")
                .andEqualTo("facilitytype", searchCondition.getFacilityType());

        PageInfo<MobileFoodFacilityPermit> pageInfo = null;
        PageHelper.startPage(searchCondition.getPageNum(), searchCondition.getPageSize());
        List<MobileFoodFacilityPermit> foodFacilityPermits = mobileFoodService.getAllForCondition(example);
        pageInfo = new PageInfo<>(foodFacilityPermits);
        return ResultData.success(pageInfo);
    }

}
