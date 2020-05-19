package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 人员配置
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PeopleConfig extends Model<PeopleConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId(value = "Id", type = IdType.ID_WORKER_STR)
    private String Id;

    /**
     * 职员Id
     */
    @TableField("Empl_Id")
    private String emplId;

    /**
     * 手机号
     */
    @TableField("Phone")
    private String Phone;

    /**
     * 姓名
     */
    @TableField("Name")
    private String Name;

    /**
     * 区域Id
     */
    @TableField("Area_Id")
    private String areaId;

    /**
     * 区域名称
     */
    @TableField("Area_Name")
    private String areaName;

    /**
     * 部门Id
     */
    @TableField("Dept_Id")
    private String deptId;

    /**
     * 部门名称
     */
    @TableField("Dept_Name")
    private String deptName;

    /**
     * 提交时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建人Id
     */
    private String createId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改人_id
     */
    private String updateId;

    /**
     * 是否删除
     */
    private Integer isDelete;


    @Override
    protected Serializable pkVal() {
        return this.Id;
    }

}
