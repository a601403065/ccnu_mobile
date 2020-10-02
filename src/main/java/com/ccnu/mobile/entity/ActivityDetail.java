package com.ccnu.mobile.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 活动详情表
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@ApiModel(value="ActivityDetail对象", description="活动详情表")
public class ActivityDetail implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "pkid", type = IdType.AUTO)
    private Integer pkid;

    @ApiModelProperty(value = "活动ID")
    private Integer activityId;

    @ApiModelProperty(value = "报名开始时间")
    private Date registerBeginTime;

    @ApiModelProperty(value = "报名结束时间")
    private Date registerEndTime;

    @ApiModelProperty(value = "签到方式（1:二维码签到,）")
    private Integer registerType;

    @ApiModelProperty(value = "报名人数")
    private Integer registerAmount;

    @ApiModelProperty(value = "最大报名人数")
    private Integer registerMaxAmount;

    @ApiModelProperty(value = "签到人数")
    private Integer signAmount;

    @ApiModelProperty(value = "活动内容")
    private String activityContent;

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

    @Override
    public String toString() {
        return "ActivityDetail{" +
        "pkid=" + pkid +
        ", activityId=" + activityId +
        ", registerBeginTime=" + registerBeginTime +
        ", registerEndTime=" + registerEndTime +
        ", registerType=" + registerType +
        ", registerAmount=" + registerAmount +
        ", registerMaxAmount=" + registerMaxAmount +
        ", signAmount=" + signAmount +
        ", activityContent=" + activityContent +
        ", activityUrl=" + activityUrl +
        ", qrCode=" + qrCode +
        ", valid=" + valid +
        "}";
    }
}
