package io.renren.modules.spider.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.spider.entity.JobDetailVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobDetailDao extends BaseMapper<JobDetailVo> {
    JobDetailVo getJobDetail(String jobId);
}
