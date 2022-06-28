package io.renren.modules.spider.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import io.renren.modules.spider.dao.JobDetailDao;
import io.renren.modules.spider.entity.JobDetailPojo;
import io.renren.modules.spider.entity.JobDetailVo;
import io.renren.modules.spider.service.JobDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class JobDetailServiceImpl implements JobDetailService {
    @Resource
    private JobDetailDao jobDetailDao;

    @Override
    public JobDetailVo getJobDetail(String jobId) {
        if (jobId == null || jobId.length() == 0) {
            return null;
        }
        JobDetailPojo jobDetailPojo = jobDetailDao.getJobDetail(jobId);
        if (jobDetailPojo == null) {
            return null;
        }
        JobDetailVo jobDetailVo = new JobDetailVo();
        BeanUtils.copyProperties(jobDetailPojo,jobDetailVo,"metrics");
        jobDetailVo.setMetrics(JSON.parseObject(jobDetailPojo.getMetrics(), Map.class));
        return jobDetailVo;
    }
}
