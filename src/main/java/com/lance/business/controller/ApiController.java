package com.lance.business.controller;

import com.lance.business.pojo.EntryPoJo;
import com.lance.business.service.ApiService;
import com.lance.common.base.model.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author lance
 * @version v0.0.1
 * @describe 控制层
 * @since 2018/8/29
 **/
@Controller
@RequestMapping(value = "handler")
@Slf4j
public class ApiController
{
    @Resource
    private ApiService apiService;

    /**
     * 示例请求
     */
    @RequestMapping(value = "/sampleRequest")
    @ResponseBody
    public JsonResult sampleRequest(@RequestBody EntryPoJo entryPoJo)
    {
        try
        {
            return apiService.sampleRequest(entryPoJo);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new JsonResult(false, "请求失败,系统发生异常");
        }
    }
}
