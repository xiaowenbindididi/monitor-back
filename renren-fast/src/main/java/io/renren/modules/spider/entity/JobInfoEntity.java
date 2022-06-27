package io.renren.modules.spider.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@ApiModel(value = "job对象",description = "描述任务信息")
public class JobInfoEntity {
    @ApiModelProperty(name = "任务的id")
    String jobId;
    @ApiModelProperty(name = "任务名称")
    String jobName;
    @ApiModelProperty(name = "任务状态",value = "0正常,1不正常")
    int status;
    @ApiModelProperty(name = "创建时间",value = "Date时间格式")
    Date createTime;
    @ApiModelProperty(name = "关联项目",value = "一个或多个")
    String relatedProject;
    @ApiModelProperty(name = "产品负责人",value = "一个或多个")
    List<String> productOwner;
    @ApiModelProperty(name = "开发负责人",value = "一个或多个")
    String developer;
    @ApiModelProperty(name = "运维负责人",value = "一个或多个")
    String maintainer;
    @ApiModelProperty(name = "任务类型",value = "0:代表一次性，1代表周期性")
    int jobType;
    @ApiModelProperty(name = "cron配置信息")
    String config;
    @ApiModelProperty(name = "下次运行时间",value = "Date时间格式")
    Date nextStartTime;
    @ApiModelProperty(name = "描述信息")
    String desc;
}
