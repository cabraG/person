package com.cabra.person.handle;

import com.cabra.person.domain.Result;
import com.cabra.person.enums.ResultEnum;
import com.cabra.person.exception.PersonException;
import com.cabra.person.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger LOGGER= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof PersonException) {
            PersonException personException = (PersonException) e;
            return ResultUtil.error(personException.getCode(), personException.getMessage());
        } else {
            LOGGER.info("system error",e);
            return ResultUtil.error(ResultEnum.UNKOWN_ERROR);
        }

    }
}
