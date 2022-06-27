package io.renren.modules.spider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "任务详情信息视图对象")
public class JobDetailVo {
    @ApiModelProperty(name = "任务id")
    String jobId;
    @ApiModelProperty(name = "任务开始时间")
    Date startTime;
    @ApiModelProperty(name = "任务结束时间")
    Date endTime;
    @ApiModelProperty(value = "指标集合，格式是json串")
    String metrics;
}
