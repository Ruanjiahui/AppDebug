package com.ruan.debug.mapper;

import com.ruan.debug.bean.BugBean;
import com.ruan.debug.bean.Req.BugCommitReq;
import com.ruan.debug.bean.Req.BugGetReq;
import com.ruan.debug.bean.Req.BugPageGetReq;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface BugCommitMapper {

    /**
     * 将bug数据写入数据库
     * @param req
     * @return
     */
    public int BugCommit(BugCommitReq req);

    /**
     * 分页获取 bug 数据
     * @param req
     * @return
     */
    public ArrayList<BugBean> BugPageGet(BugPageGetReq req);


    /**
     * 获取bug 总数量
     * @return
     */
    public long BugGetTotal();


    /**
     * 获取指定bug
     * @param req
     * @return
     */
    public BugBean BugGet(BugGetReq req);

}
