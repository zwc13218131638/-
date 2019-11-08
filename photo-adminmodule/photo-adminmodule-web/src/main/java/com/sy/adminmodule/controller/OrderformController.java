package com.sy.adminmodule.controller;

import com.sy.adminmodule.service.OrderService;
import com.sy.vo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "订单查询功能")
@RestController
public class OrderformController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "根据id查询订单", notes = "根据id查询订单")
    @GetMapping(value = "orderform/{orderid}")
    public JsonResult getOrderformbyId(@PathVariable(value = "orderid") Integer orderid, HttpServletResponse res) {
        JsonResult result = orderService.getOrderByorderid(orderid);
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "查询所有订单编号", notes = "查询所有订单编号")
    @GetMapping(value = "orderformids")
    public JsonResult getOrderforids(HttpServletResponse res) {
        JsonResult result = orderService.getOrderIds();
        res.setStatus(result.getCode());
        return result;
    }

}
