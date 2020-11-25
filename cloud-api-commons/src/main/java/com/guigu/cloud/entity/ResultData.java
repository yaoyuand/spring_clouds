package com.guigu.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultData {
    private String code;

    private String message;

    private Object data;

    public static ResultData success(Object data){
        return new ResultData("200","操作成功",data);
    }

    public static ResultData success(){
        return new ResultData("200","操作成功",null);
    }

    public static ResultData error(){
        return new ResultData("500","操作失败!",null);
    }

    public static ResultData error(String message){
        return new ResultData("500",message,null);
    }

}
