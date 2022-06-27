package io.renren.modules.spider.service.impl;


import io.renren.modules.spider.dao.JobDetailDao;
import io.renren.modules.spider.entity.JobDetailVo;
import io.renren.modules.spider.service.JobDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JobDetailServiceImpl implements JobDetailService {
    @Resource
    private JobDetailDao jobDetailDao;

    @Override
    public JobDetailVo getJobDetail(String jobId) {
        if (jobId != null && jobId.length() > 0) {
            JobDetailVo jobDetail = jobDetailDao.getJobDetail(jobId);
            return jobDetail;
        } else {
            return null;
        }
    }
}
