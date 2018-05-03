package com.vicente.light.dto;

import com.vicente.light.validate.FlagValidator;

import javax.validation.constraints.NotNull;

/**
 * @author shiweisen
 * @since 2018-01-29
 */
public class UserDto {

    @NotNull(message = "用户Id不能为空")
    private String id;

    @NotNull(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "event.trigger.save.dto.eventType.null")
    private String password;

    @FlagValidator(values = "1,2,3",message = "flag只能是1,2，3")
    private String isFlag;

    public UserDto() {
    }

    public UserDto(String id, String userName, String password, String isFlag) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.isFlag = isFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }

}
