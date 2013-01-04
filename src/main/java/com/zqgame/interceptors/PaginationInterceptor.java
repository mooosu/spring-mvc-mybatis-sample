package com.zqgame.interceptors;

import com.zqgame.common.ParsePagination;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.noo.pagination.page.PageContext;
import org.noo.pagination.page.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PaginationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(PaginationInterceptor.class);
    private int pageSize;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {

        Pagination pager = PageContext.getPageContext();
        ParsePagination pp = new ParsePagination(request);
        int ps = this.pageSize;
        int p = 1;
        if (pp.getPageSize() != 0) {
            ps = pp.getPageSize();
        }
        if (pp.getPage() != 1) {
            p = pp.getPage();
        }
        pager.setCurrentPage(p);
        pager.setPageSize(ps);
        LOG.info("pageSize:{},page: {}", ps, p);
        return true;
    }
}
