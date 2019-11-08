package com.sy.adminmodule.controller;

import com.sy.entity.Outlay;
import com.sy.vo.JsonResult;
import com.sy.adminmodule.service.OutlayService;
import com.sy.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Api(tags = "财务信息管理模块")
@RestController
public class OutlayController {

    @Autowired
    private OutlayService outlayService;

    /**
     * 获取全部的费用名称
     *
     * @return
     */
    @ApiOperation(value = "获取所有的费用名称", notes = "获取所有的费用名称")
    @GetMapping(value = "outlaynames")
    public JsonResult getAllOutlay(HttpServletResponse res) {
        JsonResult result = outlayService.getAllOutlayNames();
        res.setStatus(result.getCode());
        return result;
    }

    /**
     * 新增费用信息
     *
     * @param outlay
     * @return
     */
    @ApiOperation(value = "新增费用", notes = "新增费用")
    @PostMapping(value = "outlay")
    public JsonResult insertOutlay(@RequestBody Outlay outlay, HttpServletResponse res) {
        JsonResult result = outlayService.addOutlay(outlay);
        res.setStatus(result.getCode());
        System.out.println(outlay);
        return result;
    }

    @ApiOperation(value = "修改费用", notes = "修改费用")
    @PutMapping(value = "outlay")
    public JsonResult updateOutlay(@RequestBody Outlay outlay,HttpServletResponse res) {
        JsonResult result = outlayService.updateOutlay(outlay);
        res.setStatus(result.getCode());
        return result;
    }


    /**
     * 根据时间查询费用信息
     *
     * @return
     */
    @ApiOperation(value = "根据时间查询费用信息", notes = "根据时间查询费用信息")
    @GetMapping(value = "outlay")
    public PageResult getOutlayByTime(String starttime, String endtime,Integer page,Integer limit,HttpServletResponse res) {
        PageResult result = outlayService.getAllOutlay(starttime,endtime,page,limit);
        res.setStatus(result.getCode());
        return result;
    }

    @ApiOperation(value = "根据id删除项目", notes = "根据id删除项目")
    @DeleteMapping(value = "outlay/{id}")
    public JsonResult deleteOutlayByid(@PathVariable(value = "id")Integer id,HttpServletResponse res) {
        JsonResult result = outlayService.deleteOutlayByid(id);
        res.setStatus(result.getCode());
        return result;
    }

}
