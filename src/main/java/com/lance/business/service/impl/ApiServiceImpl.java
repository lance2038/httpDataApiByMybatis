package com.lance.business.service.impl;

import com.lance.business.dao.ApiMapper;
import com.lance.business.pojo.EntryPoJo;
import com.lance.business.service.ApiService;
import com.lance.common.base.model.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lance
 * @version v0.0.1
 * @describe 业务类接口实现类
 * @since 2018/8/29
 **/
@Service
@Slf4j
public class ApiServiceImpl implements ApiService
{

    @Resource
    private ApiMapper apiMapper;

    /**
     * 请求-同步
     *
     * @param entryPoJo
     * @return
     * @throws Exception
     */
    @Override
    public JsonResult sampleRequest(EntryPoJo entryPoJo) throws Exception
    {
        System.out.println(apiMapper.selectInfo("1"));

        return new JsonResult(true, "请求-同步:成功");
    }
}