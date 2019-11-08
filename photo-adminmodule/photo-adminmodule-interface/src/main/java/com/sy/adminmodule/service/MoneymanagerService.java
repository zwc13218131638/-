package com.sy.adminmodule.service;

import com.sy.entity.Moneymanager;
import com.sy.vo.JsonResult;
import com.sy.vo.PageResult;

public interface MoneymanagerService {

    /**
     * 根据订单编号保存收银信息
     * @param moneymanager
     */
    JsonResult saveMoneymanagerByorderid(Moneymanager moneymanager);

    /**
     * 根据原单号查询信息并补款&后期消费&退款
     * @param
     */
    JsonResult updateMoneymanagerByorderid(Moneymanager moneymanager);

    /**
     * 根据单号删除
     * @param id
     */
    JsonResult deleteMoneymanagerByorderid(Integer id);

    /**
     * 查询所有记录-》收银记录
     * @return
     */
    PageResult getAllMoneymanager(Integer orderid, Integer type, Integer page, Integer limit);

    /**
     * 获取最新的id
     * @return
     */
    JsonResult getNewMoneymanagerId();

    /**
     * 根据订单号和类型查询信息
     * @param orderid
     * @param type
     * @return
     */
    JsonResult getMoneymanagerByOrderidAndType(Integer orderid, Integer type);

    /**
     * 根据状态查询所有的消费信息
     * @param type
     * @return
     */
    JsonResult getMoneymanagerByType(Integer type);

    JsonResult getMoneymanagersByshopnameAndMonthorYear(String shopname,Integer month,Integer year);
}
