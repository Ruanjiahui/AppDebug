package com.ruan.debug.Controller;

import com.ruan.debug.bean.Req.BugCommitReq;
import com.ruan.debug.service.BugCommitService;
import com.ruan.debug.service.IBugCommit;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private IBugCommit iBugCommit;

    /**
     * 提交bug的接口
     * @param req       传输数据
     * @return
     */
    @RequestMapping("/commitBug")
    public @ResponseBody String getDebug(@ModelAttribute BugCommitReq req){
        log.info("getDebug:" + req.toString());
        //将错误日志写入数据库
        int count = iBugCommit.commitBug(req);

        return null;
    }

}
