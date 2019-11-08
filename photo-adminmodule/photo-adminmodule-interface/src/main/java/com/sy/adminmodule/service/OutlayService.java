package com.sy.adminmodule.service;

import com.sy.entity.Outlay;
import com.sy.vo.JsonResult;
import com.sy.vo.PageResult;

public interface OutlayService {

    /**
     * 新增一个收费项目/项目名称
     *
     * @param outlay
     */
    JsonResult addOutlay(Outlay outlay);

    /**
     * 查询所有不重复的项目名
     *
     * @return
     */
    JsonResult getAllOutlayNames();


    /**
     * 查询时间内的所有支出记录
     *
     * @return
     */
    PageResult getAllOutlay(String starttime, String endtime,Integer page,Integer limit);

    JsonResult updateOutlay(Outlay outlay);

    JsonResult deleteOutlayByid(Integer id);

}
