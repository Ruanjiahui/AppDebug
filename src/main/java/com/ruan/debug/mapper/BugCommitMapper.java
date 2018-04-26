package com.ruan.debug.mapper;

import com.ruan.debug.bean.Req.BugCommitReq;

public interface BugCommitMapper {

    /**
     * 将bug数据写入数据库
     * @param req
     * @return
     */
    public int commitBug(BugCommitReq req);

}
