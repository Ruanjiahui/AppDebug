package com.ruan.debug.service;

import com.ruan.debug.bean.Req.BugCommitReq;
import org.springframework.stereotype.Service;

@Service
public interface IBugCommit {

    /**
     * 将bug数据写入数据库
     * @param req
     * @return
     */
    public int commitBug(BugCommitReq req);

}
