package com.lance.business.dao;

import com.lance.business.pojo.BusinessPoJo;
import com.lance.business.pojo.BillTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lance
 */
@Mapper
@Repository
public interface ApiMapper
{
    /**
     * 查询信息(返回自定义对象)
     *
     * @param houseCode
     * @return
     */
    BusinessPoJo selectInfo(String houseCode);

    /**
     * 根据主键获取收费记录信息
     *
     * @param map
     * @return
     */
    List<BillTable> getBillInfoByBillCode(@Param("param") Map map);

    /**
     * 查询返回map
     *
     * @param billCode
     * @return
     */
    Map getBillMap(String billCode);

    /**
     * 查询返回list
     *
     * @param billCode0
     * @param billCode1
     * @return
     */
    List getBillList(@Param("billCode0") String billCode0, @Param("billCode1") String billCode1);

    /**
     * 程序包调用测试
     *
     * @param map
     * @return
     */
    void callMbTest(Map map);
}
