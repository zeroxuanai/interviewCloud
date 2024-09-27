package com.yangjian.resp;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * ClassName : ResultData
 * Package : com.yangjian.resp
 * Description :
 *
 * @author : zeroXuan
 * @version : V1.0.0
 */
@Data
@Getter
@Accessors(chain = true)
public class ResultData<T> {
    private String code;//结果状态，具体状态码参见枚举类 ReturnCodeEnum.java
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp=System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData =new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return  resultData;
    }

    public static <T> ResultData<T> fail(String code,String message){
        ResultData<T> resultData =new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        resultData.setData(null);
        return  resultData;
    }
}

