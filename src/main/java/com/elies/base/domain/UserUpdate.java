package com.elies.base.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 修改用户POST实体类
 *
 * @author 牟雪
 * @since 2018/4/3
 */
@ApiModel("修改用户POST实体类")
public class UserUpdate {

    @ApiModelProperty("用户ID")
    @NotNull
    private Long userId;

    @ApiModelProperty("登录名")
    @NotNull
    private String loginName;

    @ApiModelProperty("登录密码")
    @NotNull
    private String loginPassword;

    @ApiModelProperty("姓名")
    @NotNull
    private String userName;

    @ApiModelProperty("性别")
    @NotNull
    private Integer userSex;

    @ApiModelProperty("年龄")
    @NotNull
    private Integer userAge;

    @ApiModelProperty("地址")
    private String userAddress;

    @ApiModelProperty("账户")
    private String userAccount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
