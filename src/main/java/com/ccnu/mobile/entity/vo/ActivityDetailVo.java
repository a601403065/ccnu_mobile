package com.ccnu.mobile.entity.vo;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ActivityDetailVo {

    @ApiModelProperty(value = "主键")
    private Integer pkid;
    
    @ApiModelProperty(value = "活动ID")
    private Integer activityId;

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "活动地点")
    private String activityAddress;

    @ApiModelProperty(value = "活动开始时间")
    private Date activityBeginTime;

    @ApiModelProperty(value = "活动结束时间")
    private Date activityEndTime;
    
    @ApiModelProperty(value = "报名开始时间")
    private Date registerBeginTime;

    @ApiModelProperty(value = "报名结束时间")
    private Date registerEndTime;

    @ApiModelProperty(value = "报名人数")
    private Integer registerAmount;

    @ApiModelProperty(value = "最大报名人数")
    private Integer registerMaxAmount;
    
    @ApiModelProperty(value = "活动内容")
    private String activityContent;

    @ApiModelProperty(value = "签到人数")
    private Integer signAmount;

    @ApiModelProperty(value = "报名方式")
    private Integer registerType;
    
    @ApiModelProperty(value = "活动链接")
    private String activityUrl;
    
    @ApiModelProperty(value = "二维码")
    private String qrCode;

    @ApiModelProperty(value = "逻辑删除（1:有效,0:无效）")
    private Integer valid;

	public Integer getPkid() {
		return pkid;
	}

	public void setPkid(Integer pkid) {
		this.pkid = pkid;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
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

	public Date getRegisterBeginTime() {
		return registerBeginTime;
	}

	public void setRegisterBeginTime(Date registerBeginTime) {
		this.registerBeginTime = registerBeginTime;
	}

	public Date getRegisterEndTime() {
		return registerEndTime;
	}

	public void setRegisterEndTime(Date registerEndTime) {
		this.registerEndTime = registerEndTime;
	}

	public Integer getRegisterAmount() {
		return registerAmount;
	}

	public void setRegisterAmount(Integer registerAmount) {
		this.registerAmount = registerAmount;
	}

	public Integer getRegisterMaxAmount() {
		return registerMaxAmount;
	}

	public void setRegisterMaxAmount(Integer registerMaxAmount) {
		this.registerMaxAmount = registerMaxAmount;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public Integer getSignAmount() {
		return signAmount;
	}

	public void setSignAmount(Integer signAmount) {
		this.signAmount = signAmount;
	}

	public Integer getRegisterType() {
		return registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}
    
}
