package com.shine.common.vo.queryutil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装参数对象,主要用于添加，修改，删除等参数的封装 .
 */
public class ParamDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Object> param = new HashMap<String, Object>();

    public ParamDO(){
    }

    public ParamDO(Map<String, Object> param){
        this.param = param;
    }

    /**
     * 添加一个参数.
     * @param key
     * @param param
     * @return
     */
    public ParamDO addParam(String key, Object param){
        this.param.put(key, param);
        return this;
    }

    /**
     * 添加一批参数.
     *
     * @param param
     * @return
     */
    public ParamDO addParams(Map<String, Object> param){
        this.param.putAll(param);
        return this;
    }

    public Map<String, Object> getParam(){
        return param;
    }

}
