package com.ruan.debug.service;

import com.ruan.debug.bean.BugBean;
import com.ruan.debug.bean.Req.BugCommitReq;
import com.ruan.debug.bean.Req.BugGetReq;
import com.ruan.debug.bean.Req.BugPageGetReq;
import com.ruan.debug.mapper.BugCommitMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Log4j
@Service
public class BugCommitService implements IBugCommit {

    @Autowired
    private BugCommitMapper bugCommitMapper;
    /**
     * 将bug数据写入数据库
     *
     * @param req
     * @return
     */
    @Override
    public int BugCommit(BugCommitReq req) {
        log.info("BugCommit:" + req.toString());
        return bugCommitMapper.BugCommit(req);
    }

    /**
     * 分页获取 bug数据
     *
     * @param req
     * @return
     */
    @Override
    public ArrayList<BugBean> BugPageGet(BugPageGetReq req) {
        log.info("BugPageGet:" + req.toString());
        return bugCommitMapper.BugPageGet(req);
    }

    /**
     * 获取bug 总数量
     *
     * @return
     */
    @Override
    public long BugGetTotal() {
        return bugCommitMapper.BugGetTotal();
    }

    /**
     * 获取指定bug
     *
     * @param req
     * @return
     */
    @Override
    public BugBean BugGet(BugGetReq req) {
        log.info("BugGet:" + req.toString());
        return bugCommitMapper.BugGet(req);
    }
}
