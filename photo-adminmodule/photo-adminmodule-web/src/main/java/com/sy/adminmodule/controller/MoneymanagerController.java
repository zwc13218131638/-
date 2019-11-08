package com.sy.adminmodule.controller;

import com.sy.entity.Moneymanager;
import com.sy.entity.Orderform;
import com.sy.vo.JsonResult;
import com.sy.adminmodule.service.MoneymanagerService;
import com.sy.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Api(tags = "收银接口功能")
@RestController
public class MoneymanagerController {

    @Autowired
    private MoneymanagerService service;

    @ApiOperation(value = "收款", notes = "新增收银信息")
    @PostMapping(value = "moneymanager")
    public JsonResult addMoneymanager(@RequestBody Moneymanager moneymanager, HttpServletResponse res) {
        System.out.println(moneymanager);
        JsonResult result = service.saveMoneymanagerByorderid(moneymanager);
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "补款/后期消费/退单", notes = "收银信息操作")
    @PutMapping(value = "moneymanager")
    public JsonResult updateMoneymanager(@RequestBody Moneymanager moneymanager, HttpServletResponse res) {
        JsonResult result = service.updateMoneymanagerByorderid(moneymanager);
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "删除收银信息", notes = "根据单号删除收银信息")
    @DeleteMapping(value = "moneymanager")
    public JsonResult deleteMoneymanager(Integer id, HttpServletResponse res) {
        JsonResult result = service.deleteMoneymanagerByorderid(id);
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "获取所有收银信息", notes = "获取所有收银信息")
    @GetMapping(value = "moneymanagers")
    public PageResult moneymanagerList(Integer orderid,Integer type, Integer page,Integer limit,HttpServletResponse res) {
        PageResult result = service.getAllMoneymanager(orderid,type,page,limit);
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "获取最新单号", notes = "获取最新单号")
    @GetMapping(value = "moneymanagerid")
    public JsonResult getmoneymanagerid(HttpServletResponse res) {
        JsonResult result = service.getNewMoneymanagerId();
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "根据编号和类型查询", notes = "根据编号和类型查询")
    @GetMapping(value = "moneymanager/{orderid}/{type}")
    public JsonResult getmoneymanagerByorderidAndType(@PathVariable(value = "orderid") Integer orderid, @PathVariable(value = "type") Integer type, HttpServletResponse res) {
        JsonResult result = service.getMoneymanagerByOrderidAndType(orderid, type);
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "根据类型查询收银信息", notes = "根据类型查询收银信息")
    @GetMapping(value = "moneymanager/type/{type}")
    public JsonResult getmoneymanagerBytype(@PathVariable(value = "type") Integer type, HttpServletResponse res) {
        JsonResult result = service.getMoneymanagerByType(type);
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "统计信息", notes = "统计信息")
    @GetMapping(value = "moneymanagerinfo")
    public JsonResult getMoneymanagersByshopnameAndMonthorYear(String shopname, Integer month, Integer year, HttpServletResponse res){
        JsonResult result = service.getMoneymanagersByshopnameAndMonthorYear(shopname,month,year);
        res.setStatus(result.getCode());
        return  result;
    }
}
