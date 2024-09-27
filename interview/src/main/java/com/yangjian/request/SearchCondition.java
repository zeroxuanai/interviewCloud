package com.yangjian.request;

import com.yangjian.enu.FacilityTypeEnum;
import com.yangjian.enu.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

/**
 * ClassName : SearchContiditon
 * Package : com.yangjian.request
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
@Data
@NoArgsConstructor
@Schema(title = "查询参数")
public class SearchCondition {
    private Integer pageNum;
    private Integer pageSize;
    @NonNull
    @Schema(title = "查询关键字，FoodItems")
    private String keyword;
    @NonNull
    private FacilityTypeEnum facilityType;
    @NonNull
    private StatusEnum status;
}
