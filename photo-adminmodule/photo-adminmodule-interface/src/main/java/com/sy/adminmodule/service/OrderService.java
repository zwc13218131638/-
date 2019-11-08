package com.sy.adminmodule.service;

import com.sy.entity.Orderform;
import com.sy.vo.JsonResult;

public interface OrderService {
    /**
     * 根据id查询订单信息
     * @param orderid
     * @return
     */
    JsonResult getOrderByorderid(Integer orderid);

    /**
     * 查询所有的订单id
     * @return
     */
    JsonResult getOrderIds();
}
