package com.shine.common.vo.queryutil;

import java.io.Serializable;
import java.util.Map;

/**
 * 封装查询对象,主要用于查询对象.
 *
 */
public class QueryDO extends ParamDO implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public QueryDO(){

    }

    public QueryDO(Map<String, Object> param){
        super(param);
    }

}
