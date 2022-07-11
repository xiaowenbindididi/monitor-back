package io.renren.modules.spider.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import io.renren.modules.spider.dao.JobDetailDao;
import io.renren.modules.spider.entity.JobDetailPojo;
import io.renren.modules.spider.entity.JobDetailVo;
import io.renren.modules.spider.service.JobDetailService;
import io.renren.modules.spider.utils.JobMetricsUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class JobDetailServiceImpl implements JobDetailService {
    @Resource
    private JobDetailDao jobDetailDao;
    @Resource
    private JobMetricsUtils jobMetricsUtils;

    @Override
    public JobDetailPojo getJobDetail(String jobId) {
        if (jobId == null || jobId.length() == 0) {
            return null;
        }
        JobDetailPojo jobDetailPojo = jobDetailDao.getJobDetail(jobId);
        if (jobDetailPojo == null) {
            return null;
        }
        String metrics = jobDetailPojo.getMetrics();
        if (metrics != null && metrics.length() > 0) {
            StringBuilder stringBuilder = new StringBuilder(metrics);
            stringBuilder.deleteCharAt(0);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            jobDetailPojo.setMetrics(jobMetricsUtils.metricsResult(stringBuilder.toString()));
        }
        return jobDetailPojo;
    }
}
