package com.ccnu.mobile.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 活动表
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@ApiModel(value="Activity对象", description="活动表")
public class Activity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "pkid", type = IdType.AUTO)
    private Integer pkid;

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "活动地点")
    private String activityAddress;

    @ApiModelProperty(value = "活动开始时间")
    private Date activityBeginTime;

    @ApiModelProperty(value = "活动结束时间")
    private Date activityEndTime;

    @ApiModelProperty(value = "活动类型（）")
    private Integer activityType;

    @ApiModelProperty(value = "置顶状态（1:是,0:否）")
    private Integer topStatus;

    @ApiModelProperty(value = "添加时间")
    private Date addedTime;

    @ApiModelProperty(value = "发布人姓名")
    private String publisher;
    
    @ApiModelProperty(value = "发布人ID")
    private Integer publisherId;

    @ApiModelProperty(value = "逻辑删除（1:有效,0:无效）")
    private Integer valid;


    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public Date getActivityBeginTime() {
        return activityBeginTime;
    }

    public void setActivityBeginTime(Date activityBeginTime) {
        this.activityBeginTime = activityBeginTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(Integer topStatus) {
        this.topStatus = topStatus;
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    

    public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Activity{" +
        "pkid=" + pkid +
        ", activityName=" + activityName +
        ", activityAddress=" + activityAddress +
        ", activityBeginTime=" + activityBeginTime +
        ", activityEndTime=" + activityEndTime +
        ", activityType=" + activityType +
        ", topStatus=" + topStatus +
        ", addedTime=" + addedTime +
        ", publisher=" + publisher +
        ", publisherId=" + publisherId +
        ", valid=" + valid +
        "}";
    }
}
