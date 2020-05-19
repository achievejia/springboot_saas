package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TenantInfo extends Model<TenantInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户id
     */
    @TableField("TENANT_ID")
    private String tenantId;

    /**
     * 租户名称
     */
    @TableField("TENANT_NAME")
    private String tenantName;

    /**
     * 数据源url
     */
    @TableField("DATASOURCE_URL")
    private String datasourceUrl;

    /**
     * 数据源用户名
     */
    @TableField("DATASOURCE_USERNAME")
    private String datasourceUsername;

    /**
     * 数据源密码
     */
    @TableField("DATASOURCE_PASSWORD")
    private String datasourcePassword;

    /**
     * 数据源驱动
     */
    @TableField("DATASOURCE_DRIVER")
    private String datasourceDriver;

    /**
     * 系统账号
     */
    @TableField("SYSTEM_ACCOUNT")
    private String systemAccount;

    /**
     * 账号密码
     */
    @TableField("SYSTEM_PASSWORD")
    private String systemPassword;

    /**
     * 系统PROJECT
     */
    @TableField("SYSTEM_PROJECT")
    private String systemProject;

    /**
     * 是否启用（1是0否）
     */
    @TableField("STATUS")
    private Boolean status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
