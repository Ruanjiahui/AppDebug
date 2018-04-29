package com.ruan.debug.Controller;

import com.ruan.debug.Presenter.DebugPresenter;
import com.ruan.debug.bean.Req.BugCommitReq;
import com.ruan.debug.bean.Req.BugGetReq;
import com.ruan.debug.bean.Req.BugPageGetReq;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Log4j
@Controller
public class DebugController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DebugPresenter debugPresenter;

    /**
     * 提交bug的接口
     * @param req       传输数据
     * @return
     */
    @RequestMapping("/BugCommit")
    public @ResponseBody String BugCommit(@ModelAttribute BugCommitReq req){
        log.info("commitBug:" + req.toString());
        //将错误日志写入数据库
        return debugPresenter.BugCommit(req);
    }


    /**
     * 分页获取bug接口
     * @param req       传输数据
     * @return
     */
    @RequestMapping("/BugPageGet")
    public @ResponseBody String BugPageGet(@ModelAttribute BugPageGetReq req){
        log.info("BugPageGet:" + req.toString());
        //分页获取bug
        return debugPresenter.BugPageGet(req);
    }


    /**
     * 获取指定bug接口
     * @param req       传输数据
     * @return
     */
    @RequestMapping("/BugGet")
    public @ResponseBody String BugGet(@ModelAttribute BugGetReq req){
        log.info("BugGet:" + req.toString());
        //获取指定bug
        return debugPresenter.BugGet(req);
    }

}
