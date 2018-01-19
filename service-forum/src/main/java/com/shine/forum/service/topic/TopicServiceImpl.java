package com.shine.forum.service.topic;

import com.github.pagehelper.PageHelper;
import com.shine.cm.common.bean.db.TForumTopicInfo;
import com.shine.cm.service.forum.topic.TopicService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

import com.shine.forum.mapper.business.topic.BForumTopicInfoMapper;
import com.shine.forum.mapper.db.TForumTopicInfoMapper;
import com.shine.forum.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopicServiceImpl extends BaseService implements TopicService{

    @Resource
    private TForumTopicInfoMapper tForumTopicInfoMapper;

    @Resource
    private BForumTopicInfoMapper bForumTopicInfoMapper;

    @Override
    public ResultDO<PageBean<TForumTopicInfo>> topics(Integer limit, Integer page) {
        PageHelper.startPage(page, limit);
        List<TForumTopicInfo> topicList = bForumTopicInfoMapper.selectAll();
        return new ResultDO<PageBean<TForumTopicInfo>>(new PageBean(topicList));
    }

    @Override
    public ResultDO<TForumTopicInfo> topic(Long topicId) {
        TForumTopicInfo topicInfo = tForumTopicInfoMapper.selectByPrimaryKey(topicId);
        return new ResultDO<>(topicInfo);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT, rollbackFor = { Exception.class })
    public ResultDO<Boolean> setTopic(TForumTopicInfo bean){

        int i = tForumTopicInfoMapper.updateByPrimaryKeySelective(bean);
        if(i !=  1) {
            rollBack();
            return new ResultDO<>(false);
        } else {
            return new ResultDO<>();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT, rollbackFor = { Exception.class })
    public ResultDO<Boolean> delTopic(TForumTopicInfo bean){

        int i = tForumTopicInfoMapper.logicDelete(bean);
        if(i !=  1) {
            rollBack();
            return new ResultDO<>(false);
        } else {
            return new ResultDO<>();
        }
    }
    @Override
    public ResultDO<Boolean> createTopic(TForumTopicInfo bean){
        int i = tForumTopicInfoMapper.insertSelective(bean);
        if(i !=  1) {
            return new ResultDO<>(false);
        } else {
            return new ResultDO<>();
        }
    }

}
