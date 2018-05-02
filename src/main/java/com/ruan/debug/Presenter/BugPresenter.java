package com.ruan.debug.Presenter;

import com.ruan.debug.Controller.BaseController;
import com.ruan.debug.bean.BugBean;
import com.ruan.debug.bean.Req.BugCommitReq;
import com.ruan.debug.bean.Req.BugGetReq;
import com.ruan.debug.bean.Req.BugPageGetReq;
import com.ruan.debug.bean.Resp.BugPageResp;
import com.ruan.debug.service.IBugCommit;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.ruan.debug.Utils.RespCode.*;

/**
 * Created by 19820 on 2018/4/30.
 */
@Log4j
@Service
public class BugPresenter extends BasePresenter {


    @Autowired
    private IBugCommit iBugCommit;

    /**
     * 保存错误日志
     *
     * @param req
     */
    public String BugCommit(BugCommitReq req) {
        //将请求的错误日志添加到数据库
        int code = iBugCommit.BugCommit(req);
        //返回 1  插入成功   0  插入失败
        if (code == 1)
            return success();
        else
            return fail();
    }


    /**
     * 分页获取bug
     *
     * @param req
     */
    public String BugPageGet(BugPageGetReq req) {
        //分页获取bug数据
        ArrayList<BugBean> arrayList = iBugCommit.BugPageGet(req);

        //获取数据不为空 获取总页数 和  总数量
        if (arrayList != null && arrayList.size() > 0) {
            log.info("BugPageGet:" + arrayList.toString());

            BugPageResp bugPageResp = new BugPageResp();
            bugPageResp.setList(arrayList);
            bugPageResp.setPage(req.getPage());
            bugPageResp.setPagecount(req.getPagecount());
            //获取bug 总数量
            long total = iBugCommit.BugGetTotal();
            bugPageResp.setCount(total);
            //将数量量换取 总页数
            bugPageResp.setPagetotal((int) (total / req.getPagecount()));
            if (total % req.getPagecount() != 0)
                bugPageResp.setPagetotal(bugPageResp.getPagetotal() + 1);

            bugPageResp.setCode(success);
            bugPageResp.setMsg(success_msg);

            log.info("BugPageGet:" + bugPageResp.toString());
            return bugPageResp.toString();
        } else
            return empty();

    }


    /**
     * 分页获取bug
     *
     * @param req
     */
    public String BugGet(BugGetReq req) {
        //分页获取bug数据
        BugBean bugBean = iBugCommit.BugGet(req);

        //获取数据不为空
        if (bugBean != null) {
            log.info("BugGet:" + bugBean.toString());

            return setBeanResp(bugBean);
        } else
            return empty();
    }

}
