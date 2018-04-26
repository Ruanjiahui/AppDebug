package com.ruan.debug.service;

import com.ruan.debug.bean.Req.BugCommitReq;
import com.ruan.debug.mapper.BugCommitMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int commitBug(BugCommitReq req) {
        log.info("commitBug:" + req.toString());
        return bugCommitMapper.commitBug(req);
    }
}
