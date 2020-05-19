package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId(value = "Id", type = IdType.ID_WORKER_STR)
    private String Id;

    /**
     * 用户名
     */
    @TableField("User_Name")
    private String userName;

    /**
     * 密码
     */
    @TableField("Password")
    private String Password;

    /**
     * 姓名
     */
    @TableField("Real_Name")
    private String realName;

    /**
     * 身份证
     */
    @TableField("Id_Card")
    private String idCard;

    /**
     * 邮箱
     */
    @TableField("E_Mail")
    private String eMail;

    /**
     * 联系电话
     */
    @TableField("Tel_Phone")
    private String telPhone;

    /**
     * 入职日期
     */
    @TableField("Entry_Time")
    private String entryTime;

    /**
     * 离职日期
     */
    @TableField("Resignation_Time")
    private String resignationTime;

    /**
     * 职务Id
     */
    @TableField("Position_Id")
    private String positionId;

    /**
     * 性别，1、男，2、女
     */
    @TableField("Sex")
    private Integer Sex;

    /**
     * 出生日期
     */
    @TableField("Birthday")
    private String Birthday;

    /**
     * 操作人
     */
    @TableField("Operator")
    private String Operator;

    /**
     * 部门Id
     */
    @TableField("Dept_Id")
    private String deptId;

    /**
     * 登录时间
     */
    @TableField("Login_Time")
    private String loginTime;

    /**
     * 过期时间
     */
    @TableField("Expire_Time")
    private String expireTime;

    /**
     * 过期状态，1、永不过期，2、限时过期
     */
    @TableField("Expire_Status")
    private Integer expireStatus;

    /**
     * 用户状态，1、启用，2、禁用
     */
    @TableField("Status")
    private Integer Status;

    /**
     * 是否是超级管理员，0、不是，1、是
     */
    @TableField("Is_Admin")
    private Integer isAdmin;

    /**
     * 创建时间
     */
    @TableField("Create_Time")
    private String createTime;

    /**
     * 修改时间
     */
    @TableField("Update_Time")
    private String updateTime;


    @Override
    protected Serializable pkVal() {
        return this.Id;
    }

}
