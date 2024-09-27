package com.yangjian.enu;

import lombok.Getter;

import java.util.Arrays;

/**
 * ClassName : FacilityTypeEnum
 * Package : com.yangjian.enu
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
@Getter
public enum FacilityTypeEnum {

    Truck("Truck"),
    Unknown("unknown"),
    ALL("all"),
    PushCart("PushCart");

    private final String type;

    FacilityTypeEnum(String type) {
        this.type = type;
    }

    public static FacilityTypeEnum getFacilityTypeEnum(String type) {

        return Arrays.stream(FacilityTypeEnum.values())
                .filter(t -> t.getType().equalsIgnoreCase(type))
                .findFirst()
                .orElse(null);

    }

}
