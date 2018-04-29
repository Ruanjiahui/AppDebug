package com.ruan.debug.Presenter;

import com.ruan.debug.Controller.BasePresenter;
import com.ruan.debug.bean.BugBean;
import com.ruan.debug.bean.Req.BugCommitReq;
import com.ruan.debug.bean.Req.BugGetReq;
import com.ruan.debug.bean.Req.BugPageGetReq;
import com.ruan.debug.bean.Resp.BugPageResp;
import com.ruan.debug.bean.Resp.BugResp;
import com.ruan.debug.service.BugCommitService;
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
public class DebugPresenter extends BasePresenter {


    @Autowired
    private IBugCommit iBugCommit;

    /**
     * 保存错误日志
     *
     * @param req
     */
    public String BugCommit(BugCommitReq req) {
        try {
            //将请求的错误日志添加到数据库
            int code = iBugCommit.BugCommit(req);
            //返回 1  插入成功   0  插入失败
            if (code == 1)
                return success();
            else
                return fail();

        } catch (Exception e) {
            log.info("BugCommit_E:" + e.toString());
            return server_error();
        }
    }


    /**
     * 分页获取bug
     *
     * @param req
     */
    public String BugPageGet(BugPageGetReq req) {
        try {
            //页数小于等于0 返回非法参数
            if (req.getPage() <= 0)
                return illegal_parameter();
            // 数据库 标识开始是 0 开始   页数 开始 是 1
            req.setStartFlag(req.getPage() - 1);

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

        } catch (Exception e) {
            log.info("BugPageGet_E:" + e.toString());
            return server_error();
        }
    }


    /**
     * 分页获取bug
     *
     * @param req
     */
    public String BugGet(BugGetReq req) {
        try {
            //ID不传就是默认为0 返回非法参数
            if (req.getDebugID() == 0)
                return illegal_parameter();

            //分页获取bug数据
            BugBean bugBean = iBugCommit.BugGet(req);

            //获取数据不为空
            if (bugBean != null) {
                log.info("BugGet:" + bugBean.toString());

                return setBeanResp(bugBean);
            } else
                return empty();

        } catch (Exception e) {
            log.info("BugPageGet_E:" + e.toString());
            return server_error();
        }
    }

}
