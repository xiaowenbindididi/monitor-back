package io.renren.modules.spider.service;


import io.renren.modules.spider.entity.JobDetailPojo;
import io.renren.modules.spider.entity.JobDetailVo;

public interface JobDetailService {
    JobDetailPojo getJobDetail(String jobId);
}
