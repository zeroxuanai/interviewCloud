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
public enum StatusEnum {

    REQUESTED("requested"),
    APPROVED("approve"),
    ISSUED("issued"),
    ONLINE("online"),
    SUSPEND("suspend"),
    EXPIRED("expired"),
    ALL("all");

    private final String status;

    StatusEnum(String type) {
        this.status = type;
    }

    public static StatusEnum getFacilityTypeEnum(String status) {

        return Arrays.stream(StatusEnum.values())
                .filter(t -> t.getStatus().equalsIgnoreCase(status))
                .findFirst()
                .orElse(null);

    }

}
