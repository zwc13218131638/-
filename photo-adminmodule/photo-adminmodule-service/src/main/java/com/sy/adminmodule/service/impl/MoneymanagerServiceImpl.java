package com.sy.adminmodule.service.impl;

import com.sy.adminmodule.dao.OutlayDao;
import com.sy.entity.Moneymanager;
import com.sy.entity.Outlay;
import com.sy.vo.JsonResult;
import com.sy.adminmodule.dao.MoneymanagerDao;
import com.sy.adminmodule.dao.OrderDao;
import com.sy.adminmodule.service.MoneymanagerService;
import com.sy.vo.MonaymanagerInfo;
import com.sy.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class MoneymanagerServiceImpl implements MoneymanagerService {

    @Autowired
    private MoneymanagerDao moneymanagerDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OutlayDao outlaydao;

    /**
     * 根据订单编号保存收银信息
     *
     * @param moneymanager
     */
    @Override
    public JsonResult saveMoneymanagerByorderid(Moneymanager moneymanager) {
        if (moneymanager.getOrderid() == null) {
            return JsonResult.buildFailure(400, "订单号不能为空");
        }

        if (moneymanager.getPrice().signum() == -1) {
            return JsonResult.buildFailure(400, "价格不能为负数");
        }

        if (moneymanager.getFrontmoney().signum() == -1) {
            return JsonResult.buildFailure(400, "定金不能为负数");
        }

        try {
            moneymanagerDao.save(moneymanager);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }

        return JsonResult.buildSuccess(200, null);
    }

    /**
     * 根据订单编号修改收银信息
     *
     * @param moneymanager
     */
    @Override
    public JsonResult updateMoneymanagerByorderid(Moneymanager moneymanager) {

        if (moneymanager.getOrderid() == null) {
            return JsonResult.buildFailure(400, "订单号不能为空");
        }

        if (moneymanager.getLatermoney() != null) {
            if (moneymanager.getLatermoney().signum() == -1) {
                return JsonResult.buildFailure(400, "后期消费不能为负数");
            }
        }

        try {
            moneymanagerDao.save(moneymanager);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, moneymanager);
    }

    /**
     * 根据id删除对应的收银信息
     *
     * @param id
     */
    @Override
    public JsonResult deleteMoneymanagerByorderid(Integer id) {
        if (id == null) {
            return JsonResult.buildFailure(400, "id不能为空");
        }
        try {
            moneymanagerDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, null);
    }


    /**
     * 获取所有的收银记录
     *
     * @return
     */
    @Override
    public PageResult getAllMoneymanager(Integer orderid, Integer type, Integer page, Integer limit) {
        List<Moneymanager> moneymanagerList = new ArrayList<>();
        Integer totalcount = null;
        page = (page - 1) * limit;
        StringBuffer sql = new StringBuffer("select * from moneymanager where 1 = 1 ");
        try {
            if (orderid != null) {
                sql.append(" and orderid = " + orderid);
            }
            if (type != null) {
                sql.append(" and type = " + type);
            }
            if (page != null) {
                sql.append(" limit " + page);
            }
            if (limit != null) {
                sql.append("," + limit);
            }
            moneymanagerList = moneymanagerDao.queryBeanList(sql.toString(), Moneymanager.class);
            totalcount = moneymanagerDao.findAll().size();
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.buildFailure(500, "服务器错误");
        }

        return PageResult.buildSuccess(200, moneymanagerList, totalcount);
    }

    @Override
    public JsonResult getNewMoneymanagerId() {
        List<Moneymanager> moneymanagerList = new ArrayList<>();
        Integer id = null;
        try {
            moneymanagerList = moneymanagerDao.findAll();
            List<Integer> ids = new ArrayList<>();
            moneymanagerList.forEach(e -> ids.add(e.getId()));
            id = Collections.max(ids) + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, id);
    }

    @Override
    public JsonResult getMoneymanagerByOrderidAndType(Integer orderid, Integer type) {
        Moneymanager moneymanager = null;
        if (orderid == null) {
            return JsonResult.buildFailure(400, "id不能为空");
        }
        if (type == null) {
            return JsonResult.buildFailure(400, "类型不能为空");
        }
        try {
            moneymanager = moneymanagerDao.queryBean("select * from moneymanager where orderid = ? and type = ?", Moneymanager.class, orderid, type);
            if (moneymanager == null) {
                return JsonResult.buildFailure(400, "该单尚未收款，不能操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, moneymanager);
    }

    @Override
    public JsonResult getMoneymanagerByType(Integer type) {
        List<Moneymanager> moneymanagerList = new ArrayList<>();
        List<Integer> orderidList = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        if (type != null) {
            try {
                moneymanagerList = moneymanagerDao.queryBeanList("select * from moneymanager where type = ?", Moneymanager.class, type);
                moneymanagerList.forEach(e -> orderidList.add(e.getOrderid()));
                List<Integer> finalIds = ids;
                orderDao.findAll().forEach(e -> finalIds.add(e.getOrderid()));
                ids = finalIds;
                if (type == 1) {
                    ids.removeAll(orderidList);
                }
                if (type == 2) {
                    ids.clear();
                    List<Integer> finalIds1 = ids;
                    moneymanagerDao.queryBeanList("select * from moneymanager where type = 1 and balancemoney !=0 and orderId not in(SELECT orderId from moneymanager where type = 2 or type = 4)", Moneymanager.class).forEach(e -> finalIds1.add(e.getOrderid()));
                    ids = finalIds1;
                    System.out.println(ids);
                    System.out.println(finalIds);
                }
                if (type == 3) {
                    ids.clear();
                    List<Integer> finalIds1 = ids;
                    moneymanagerDao.queryBeanList("select * from moneymanager where type = 1 and orderId not in(SELECT orderId from moneymanager where type = 4)", Moneymanager.class).forEach(e -> finalIds1.add(e.getOrderid()));
                    ids = finalIds1;
                }
                if (type == 4) {
                    ids.clear();
                    List<Integer> finalIds1 = ids;
                    moneymanagerDao.queryBeanList("select * from moneymanager where type = 1 and orderId not in (SELECT orderId from moneymanager where type = 4)", Moneymanager.class).forEach(e -> finalIds1.add(e.getOrderid()));
                    ids = finalIds1;
                }

            } catch (Exception e) {
                e.printStackTrace();
                return JsonResult.buildFailure(500, "服务器错误");
            }
        }
        return JsonResult.buildSuccess(200, ids);
    }

    /**
     * 根据店面，月份，年份，统计收入，支出，利润，订单数
     *
     * @param shopname
     * @param month
     * @param year
     * @return
     */
    @Override
    public JsonResult getMoneymanagersByshopnameAndMonthorYear(String shopname, Integer month, Integer year) {
        MonaymanagerInfo info = new MonaymanagerInfo();
        List<Moneymanager> moneymanagerList = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT * FROM moneymanager where 1=1 ");
        BigDecimal realprice = new BigDecimal(0);//销售额
        BigDecimal frontmoney = new BigDecimal(0);//已收
        BigDecimal balancemoney = new BigDecimal(0);//未收余款
        BigDecimal latermoney = new BigDecimal(0);//后期消费
        BigDecimal refund = new BigDecimal(0);//退款
        BigDecimal profit = new BigDecimal(0);//利润

        Set<Integer> set = new HashSet<>();//订单数
        try {
            if (shopname != null) {
                sql.append("and orderId in (SELECT orderid FROM orderform where shopname = '" + shopname + "') ");
            }
            if (month != null) {
                sql.append(" and (month(frontTime) = " + month + " or MONTH(laterTime) = " + month + ")");
            }
            if (year != null) {
                sql.append(" (YEAR(frontTime) = " + year + " or YEAR(laterTime) = " + year + ")");
            }
            System.out.println(sql);
            moneymanagerList = moneymanagerDao.queryBeanList(sql.toString(), Moneymanager.class);
            info.setMoneymanagerList(moneymanagerList);
            for (Moneymanager moneymanager : moneymanagerList) {
                if (moneymanager.getOrderid() != null) {
                    set.add(moneymanager.getOrderid());
                }
                if (moneymanager.getRealprice() != null) {
                    realprice.add(moneymanager.getRealprice());//销售额
                }
                if (moneymanager.getLatermoney() != null) {
                    latermoney.add(moneymanager.getLatermoney());//销售额+后期消费=总额
                }

                if (moneymanager.getFrontmoney() != null) {
                    frontmoney.add(moneymanager.getFrontmoney());//实收总额
                }

                if (moneymanager.getBalancemoney() != null) {
                    balancemoney.add(moneymanager.getBalancemoney());//余款总额
                }

                if (moneymanager.getRefund() != null) {
                    refund.add(moneymanager.getRefund());//退款总额
                }
            }
            if (frontmoney != null && refund != null) {
                frontmoney.subtract(refund);//销售额-退款总额，实际收入总额度
            }
            realprice.add(latermoney);

            Integer ordernum = set.size();//订单数

            info.setIncome(realprice);
            info.setReceivables(frontmoney);
            info.setBalance(balancemoney);

            StringBuffer outlaySql = new StringBuffer("SELECT * from outlay where 1=1");

            if (shopname != null) {
                outlaySql.append(" and shopid = (SELECT id  from shop where name = '" + shopname + "')");
            }
            if (month != null) {
                outlaySql.append(" and (MONTH(date)=" + month);
            }
            if (month == null && year != null) {
                outlaySql.append(" and (YEAR(date)=" + year);
            }
            if (month != null && year != null) {
                outlaySql.append(" and (MONTH(date)=" + month + " or YEAR(date) = " + year + ")");
            }
            System.out.println(outlaySql);

            BigDecimal expenditure = new BigDecimal(0);
            List<Outlay> outlays = outlaydao.queryBeanList(sql.toString(), Outlay.class);
            System.out.println(outlays);
            if (outlays.size() > 0) {
                for (Outlay outlay : outlays) {
                    expenditure.add(outlay.getOutlayprice());
                }
            }
            System.out.println(expenditure);
            info.setExpenditure(expenditure);//所有支出
            profit = frontmoney.subtract(expenditure);
            info.setProfit(profit);

        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.buildFailure(500, "服务器错误");
        }
        return JsonResult.buildSuccess(200, info);
    }
}
