package com.lance.business.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lance
 */
@Mapper
@Repository
public interface SysMapper
{
    /**
     * 获取当前系统时间
     *
     * @return
     */
    String getDBCurrentTime();

    /**
     * 获取当前系统日期
     *
     * @return
     */
    String getDBCurrentDate();
}
