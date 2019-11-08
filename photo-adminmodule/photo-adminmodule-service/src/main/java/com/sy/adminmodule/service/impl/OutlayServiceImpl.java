package com.sy.adminmodule.service.impl;

import com.sy.entity.Outlay;
import com.sy.vo.JsonResult;
import com.sy.adminmodule.dao.OutlayDao;
import com.sy.adminmodule.service.OutlayService;
import com.sy.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OutlayServiceImpl implements OutlayService {

    @Autowired
    private OutlayDao outlayDao;

    @Override
    public JsonResult addOutlay(Outlay outlay) {
        if (outlay.getOutlayname().equals("")) {
            return JsonResult.buildFailure(400, "请输入项目名");
        }
        try {
            outlayDao.save(outlay);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, null);
    }

    @Override
    public JsonResult getAllOutlayNames() {
        List<Outlay> outlays = new ArrayList<>();
        try {
            outlays = outlayDao.queryBeanList("select * from outlay where outlayprice is null", Outlay.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, outlays);
    }


    @Override
    public PageResult getAllOutlay(String starttime, String endtime, Integer page, Integer limit) {
        List<Outlay> outlays = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from outlay where 1=1 and estimate is null ");
        Integer totalcount = null;
        try {
            if (!starttime.equals("") && starttime != null) {
                sql.append(" and date between '" + starttime + "' ");
            }
            if (!endtime.equals("") && endtime != null) {
                sql.append(" and '" + endtime + "' ");
            }
            if (page != null) {
                sql.append(" limit " + (page - 1));
            }
            if (limit != null) {
                sql.append("," + limit);
            }
            System.out.println(sql);
            outlays = outlayDao.queryBeanList(sql.toString(), Outlay.class);
            totalcount = outlays.size();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.buildFailure(500, "服务器错误");
        }
        return PageResult.buildSuccess(200, outlays, totalcount);
    }

    @Override
    public JsonResult updateOutlay(Outlay outlay) {
        if (outlay.getOutlayname().equals("") || outlay.getOutlayname() == null) {
            return JsonResult.buildFailure(400, "请输入项目名");
        }
        try {
            outlayDao.save(outlay);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, null);
    }

    @Override
    public JsonResult deleteOutlayByid(Integer id) {
        if (id == null) {
            return JsonResult.buildFailure(400, "id不可为空");
        }
        try {
            outlayDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, null);
    }
}
