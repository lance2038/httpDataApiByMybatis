package com.lance.business.service;

import com.lance.business.pojo.EntryPoJo;
import com.lance.common.base.model.JsonResult;

/**
 * @author lance
 * @version v0.0.1
 * @describe 业务类接口类
 * @since 2018/8/29
 **/
public interface ApiService
{
    /**
     * 请求-同步
     *
     * @param entryPoJo
     * @return
     * @throws Exception
     */
    JsonResult sampleRequest(EntryPoJo entryPoJo) throws Exception;

}
