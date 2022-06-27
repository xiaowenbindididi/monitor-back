package io.renren.modules.spider.utils;

import io.renren.modules.spider.entity.JobInfoEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class SortUtils {
    public List<JobInfoEntity> sortJobInfoList(List<JobInfoEntity> jobInfoEntityList) {
        JobInfoEntity[] jobInfoEntities = jobInfoEntityList.toArray(new JobInfoEntity[0]);
        Arrays.sort(jobInfoEntities, new JobInfoComparator());
        return Arrays.asList(jobInfoEntities);
    }
}

/**
 * 定义一个排序规则就在这定义
 */
class JobInfoComparator implements Comparator<JobInfoEntity> {
    @Override
    public int compare(JobInfoEntity o1, JobInfoEntity o2) {
        return o2.getStatus() - o1.getStatus();
    }
}
