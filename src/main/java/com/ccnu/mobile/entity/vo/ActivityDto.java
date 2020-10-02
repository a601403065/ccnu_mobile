package com.ccnu.mobile.entity.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

public class ActivityDto {

	@JsonIgnore
    @ApiModelProperty(hidden=true)
    private Integer activityId;	

    @ApiModelProperty(value = "活动名称" , required = true)
    private String activityName;

    @ApiModelProperty(value = "活动地点" , required = true)
    private String activityAddress;

    @ApiModelProperty(value = "活动开始时间" , required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityBeginTime;

    @ApiModelProperty(value = "活动结束时间" , required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityEndTime;

    @ApiModelProperty(value = "活动类型（）" , required = true)
    private Integer activityType;

	@JsonIgnore
    @ApiModelProperty(hidden=true)
    private Integer topStatus;
	
	@JsonIgnore
    @ApiModelProperty(hidden=true)
    private Date addedTime;
	
	@JsonIgnore
    @ApiModelProperty(hidden=true)
    private String publisher;

	@ApiModelProperty(value = "发布者ID" , required = true)
    private Integer publisherId;
    
    @ApiModelProperty(value = "报名开始时间" , required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerBeginTime;

    @ApiModelProperty(value = "报名结束时间" , required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerEndTime;

    @ApiModelProperty(value = "签到方式（1:二维码签到,）" , required = true)
    private Integer registerType;

	@JsonIgnore
    @ApiModelProperty(hidden=true)
    private Integer registerAmount;

    @ApiModelProperty(value = "最大报名人数" , required = true)
    private Integer registerMaxAmount;

	@JsonIgnore
    @ApiModelProperty(hidden=true)
    private Integer signAmount;

    @ApiModelProperty(value = "活动内容" , required = true)
    private String activityContent;

    @ApiModelProperty(value = "活动链接" , required = true)
    private String activityUrl;

    @ApiModelProperty(value = "二维码" , required = true)
    private String qrCode;
    
	@JsonIgnore
    @ApiModelProperty(hidden=true)
    private Integer valid;

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

	public Integer getRegisterType() {
		return registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
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

	public Integer getSignAmount() {
		return signAmount;
	}

	public void setSignAmount(Integer signAmount) {
		this.signAmount = signAmount;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
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
