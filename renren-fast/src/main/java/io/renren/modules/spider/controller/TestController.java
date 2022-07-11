package io.renren.modules.spider.controller;


import io.renren.common.utils.Constant;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.spider.entity.JobDetailPojo;
import io.renren.modules.spider.entity.JobDetailVo;
import io.renren.modules.spider.entity.JobInfoEntity;
import io.renren.modules.spider.service.JobDetailService;
import io.renren.modules.spider.service.JobInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author xwb
 */
@Api("接口")
@Controller
@RequestMapping("/spider")
public class TestController {
    @Resource
    private JobInfoService jobInfoService;
    @Resource
    private JobDetailService jobDetailService;

    @ApiOperation(value = "返回所有任务信息")
    @PostMapping("/getJobs")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = jobInfoService.queryPage(params);
        return R.ok().put("page", page);
    }

    @ApiOperation("给出任务id，查找对应任务的开始时间，结束时间，指标,没查到返回null")
    @PostMapping("/getJD")
    @ResponseBody
    @ApiParam(name = "jobId", value = "形如：standard或者jp_umin_daily")
    public R getJobDetail(@ApiParam(name = "jobId", value = "形如：standard或者jp_umin_daily")
                          @RequestParam(value = "jobId", required = true) String jobId) {
        JobDetailPojo jobDetail = jobDetailService.getJobDetail(jobId);
        if (jobDetail == null) {
            return R.ok("没取到数据");
        }
        return R.ok().put("detail", jobDetail);
    }
}
