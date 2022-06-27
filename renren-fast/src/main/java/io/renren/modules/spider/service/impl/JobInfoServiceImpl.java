package io.renren.modules.spider.service.impl;


import io.renren.modules.spider.dao.JobInfoDao;
import io.renren.modules.spider.entity.JobInfoEntity;
import io.renren.modules.spider.service.JobInfoService;
import io.renren.modules.spider.utils.SortUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobInfoServiceImpl implements JobInfoService {
    @Resource
    private JobInfoDao jobInfoDao;
    @Resource
    private SortUtils sortUtils;

    @Override
    public List<JobInfoEntity> getAllJob() {
        List<JobInfoEntity> jobInfoList = jobInfoDao.selectAllJobs();
        if (jobInfoList != null && jobInfoList.size() > 0) {
            jobInfoList = sortUtils.sortJobInfoList(jobInfoList);
        }
        return jobInfoList;
    }
}
