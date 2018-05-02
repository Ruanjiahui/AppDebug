package com.ruan.debug.Controller;

import com.ruan.debug.Presenter.BugPresenter;
import com.ruan.debug.Utils.TextUtils;
import com.ruan.debug.bean.Req.BugCommitReq;
import com.ruan.debug.bean.Req.BugGetReq;
import com.ruan.debug.bean.Req.BugPageGetReq;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Log4j
@Controller
public class DebugController extends BaseController{

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private BugPresenter debugPresenter;

    /**
     * 提交bug的接口
     * @param req       传输数据
     * @return
     */
    @RequestMapping(value = "/BugCommit" , method = {RequestMethod.POST})
    public @ResponseBody String BugCommit(@RequestBody BugCommitReq req){
        log.info("commitBug:" + req.toString());

        //写入错误日志不能为空
        if (TextUtils.isEmpty(req.getBugData()))
            return illegal_parameter();

        try {
            //将错误日志写入数据库
            return debugPresenter.BugCommit(req);
        } catch (Exception e){
            log.info("BugCommit_E:" + e.toString());
            return server_error();
        }
    }


    /**
     * 分页获取bug接口
     * @param req       传输数据
     * @return
     */
    @RequestMapping("/BugPageGet")
    public @ResponseBody String BugPageGet(@ModelAttribute BugPageGetReq req){
        log.info("BugPageGet:" + req.toString());

        try {
            //页数小于等于0 返回非法参数
            if (req.getPage() <= 0)
                return illegal_parameter();
            // 数据库 标识开始是 0 开始   页数 开始 是 1
            req.setStartFlag((req.getPage() - 1) * req.getPagecount());

            //分页获取bug
            return debugPresenter.BugPageGet(req);

        } catch (Exception e) {
            log.info("BugPageGet_E:" + e.toString());
            return server_error();
        }
    }


    /**
     * 获取指定bug接口
     * @param req       传输数据
     * @return
     */
    @RequestMapping("/BugGet")
    public @ResponseBody String BugGet(@ModelAttribute BugGetReq req){
        log.info("BugGet:" + req.toString());

        try {
            //ID不传就是默认为0 返回非法参数
            if (req.getDebugID() == 0)
                return illegal_parameter();

            //获取指定bug
            return debugPresenter.BugGet(req);

        } catch (Exception e) {
            log.info("BugPageGet_E:" + e.toString());
            return server_error();
        }
    }

}
