package com.shine.forum.service;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

public class BaseService {


    public void rollBack() {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    /**
     * 判断是否更新、修改是否真实成功，不成功回归
     * @param updateCount
     * @throws Exception
     */
    public void rollBack(int updateCount) throws Exception{
        if(updateCount<=0){
            this.rollBack();
            throw new Exception("无效的参数");
        }
    }
}
