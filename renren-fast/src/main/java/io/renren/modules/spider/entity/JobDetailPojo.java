package io.renren.modules.spider.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "任务详情类对象")
public class JobDetailPojo {
    @ApiModelProperty(name = "任务id")
    String jobId;
    @ApiModelProperty(name = "任务开始时间")
    Date startTime;
    @ApiModelProperty(name = "任务结束时间")
    Date endTime;
    @ApiModelProperty(value = "指标集合，格式是json串,在这是string格式")
    String metrics;
    @ApiModelProperty(value = "关键采集成功数")
    @TableField("key_parse_suc")
    Integer keyParseSuc;
    @ApiModelProperty(value = "写入kafka成功数")
    @TableField("write_to_kafka_suc")
    Integer writeToKafkaSuc;
}
