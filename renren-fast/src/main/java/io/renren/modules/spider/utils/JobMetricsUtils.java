package io.renren.modules.spider.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.modules.spider.dao.MetricsDao;
import io.renren.modules.spider.entity.MetricsEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobMetricsUtils {
    @Resource
    private MetricsDao metricsDao;

    public String metricsResult(String metricsOrigin) {
        List<MetricsEntity> metricsEntities = metricsDao.selectList(new QueryWrapper<>());
        Map<String, String> nameMap = getNameMap(metricsEntities);
        for (Map.Entry<String,String> entry : nameMap.entrySet()) {
            metricsOrigin = metricsOrigin.replace(entry.getKey(),entry.getValue());
        }
        return metricsOrigin;
    }

    public Map<String, String> getNameMap(List<MetricsEntity> metricsEntities) {
        if (metricsEntities == null || metricsEntities.size() == 0) {
            return null;
        }
        Map<String, String> resultMap = new HashMap<>();
        for (MetricsEntity metricsEntity : metricsEntities) {
            String cnName = metricsEntity.getName();
            String enName = metricsEntity.getEnName();
            if (enName != null && enName.length() > 0) {
                resultMap.put(enName, cnName);
            }
        }
        return resultMap;
    }
}
