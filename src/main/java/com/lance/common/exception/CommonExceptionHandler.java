package com.lance.common.exception;

import com.lance.common.base.model.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class CommonExceptionHandler
{

    /**
     * 拦截Exception类的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult exceptionHandler(Exception e)
    {
        return new JsonResult(false, e.getMessage());
    }
}
