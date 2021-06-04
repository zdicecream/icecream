package com.zdinit.icecream.common;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseController {
    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    @ModelAttribute
    public void setBaseBizController(HttpServletRequest request, HttpServletResponse response){
        this.request=request;
        this.response=response;
        this.session=request.getSession();
    }
    public Page page(){
        //获取请求参数
        Page page = new Page();
        String pageNoS = request.getParameter("pageNo");
        Long pageNo = StringUtils.isBlank(pageNoS) ? 1l :Long.parseLong(pageNoS);
        String pageSizeS = request.getParameter("pageSize");
        Long pageSize = StringUtils.isBlank(pageSizeS) ? 10L : Long.parseLong(pageSizeS);
        String sortFieldS = request.getParameter("sortField");
        String sortOrderS = request.getParameter("sortOrder");
        if (StringUtils.isNotBlank(sortFieldS)){
            List<OrderItem> OrderItemList = new ArrayList<>();
            String[] sortField = sortFieldS.split(",");
            String[] sortOrder = sortOrderS!=null ? sortOrderS.split(",") : null;
            OrderItem orderItem = null;
            for (int i=0;i<sortField.length;i++) {
                orderItem = new OrderItem();
                orderItem.setColumn(sortField[i]);
                if (sortOrder!=null &&"ascend".equals(sortOrder[i])) {
                    orderItem.setAsc(true);
                }else {
                    orderItem.setAsc(false);
                }
                OrderItemList.add(orderItem);
            }
            page.setOrders(OrderItemList);
        }
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        return page;
    }

}
