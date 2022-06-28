package io.renren.modules.spider.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.spider.entity.JobDetailPojo;
import io.renren.modules.spider.entity.JobDetailVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobDetailDao extends BaseMapper<JobDetailPojo> {
    JobDetailPojo getJobDetail(String jobId);
}
