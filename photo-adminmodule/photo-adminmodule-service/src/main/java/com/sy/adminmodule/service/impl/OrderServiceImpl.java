package com.sy.adminmodule.service.impl;

import com.sy.entity.Orderform;
import com.sy.adminmodule.dao.OrderDao;
import com.sy.adminmodule.service.OrderService;
import com.sy.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public JsonResult getOrderByorderid(Integer orderid) {
        Orderform orderform = null;
        if (orderid == null) {
            return JsonResult.buildFailure(400, "id不能为空");
        }
        try {
            orderform = orderDao.findOne(orderid);
            if (orderform == null) {
                return JsonResult.buildFailure(400, "该订单号不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, orderform);
    }

    @Override
    public JsonResult getOrderIds() {
        List<Integer> ids = new ArrayList<>();
        try {
            orderDao.findAll().forEach(e -> ids.add(e.getOrderid()));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, ids);
    }
}
