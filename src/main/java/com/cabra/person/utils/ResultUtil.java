package com.cabra.person.utils;

import com.cabra.person.domain.Result;
import com.cabra.person.enums.ResultEnum;

public class ResultUtil {
    public static Result success(Object o) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(o);
        return result;


    }

    public static Result success() {

        return success(null);
    }

    public static Result error(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;

    }
    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;


    }
}
