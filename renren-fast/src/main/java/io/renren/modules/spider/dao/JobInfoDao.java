package io.renren.modules.spider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.spider.entity.JobInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobInfoDao extends BaseMapper<JobInfoEntity> {
//    List<JobInfoEntity> selectAllJobs();
}
