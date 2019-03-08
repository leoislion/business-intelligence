package com.isoftstone.bi.userserver.vo;

import lombok.Data;

/**
 * @package: com.isoftstone.cem.vo
 * @author: leo
 * @desc:
 * @date :  2018/12/26
 **/
@Data
public class ResponseVo<M> {
    //0-成功；1-业务异常；999-系统异常
    private int status;

    private String msg;

    private M data;

    private Integer total;

    public static<M> ResponseVo success(M m){
        ResponseVo responseVo=new ResponseVo();
        responseVo.setStatus(0);
        responseVo.setData(m);
        return responseVo;
    }


    public static<M> ResponseVo success(M m,Integer total){
        ResponseVo responseVo=new ResponseVo();
        responseVo.setStatus(0);
        responseVo.setData(m);
        responseVo.setTotal(total);
        return responseVo;
    }
    public static<M> ResponseVo success(M m,String string){
        ResponseVo responseVo=new ResponseVo();
        responseVo.setStatus(0);
        responseVo.setData(m);
        responseVo.setMsg(string);
        return responseVo;
    }
    public static<M> ResponseVo serviceFail(String msg){
        ResponseVo responseVo=new ResponseVo();
        responseVo.setStatus(1);
        responseVo.setMsg(msg);
        return responseVo;
    }

    public static<M> ResponseVo appFail(String msg){
        ResponseVo responseVo=new ResponseVo();
        responseVo.setStatus(999);
        responseVo.setMsg(msg);
        return responseVo;
    }
}
