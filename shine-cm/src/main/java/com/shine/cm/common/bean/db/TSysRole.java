package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表sys_role数据库Bean .</p>
 */
public class TSysRole implements Serializable {
    /**
     * <p>角色ID .</p>
     */
    private Long roleId;

    /**
     * <p>角色名称 .</p>
     */
    private String roleName;

    /**
     * <p>角色说明 .</p>
     */
    private String roleDesc;

    /**
     * <p>角色类型 .</p>
     */
    private Byte roleType;

    /**
     * <p>修改人账号 .</p>
     */
    private String modifierUserName;

    /**
     * <p>修改时间 .</p>
     */
    private Date modifyTime;

    /**
     * <p>创建人账号 .</p>
     */
    private String creatorUserName;

    /**
     * <p>创建时间 .</p>
     */
    private Date createTime;

    /**
     * <p>删除标识 (1-正常；2-删除) .</p>
     */
    private Byte delFlag;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Byte getRoleType() {
        return roleType;
    }

    public void setRoleType(Byte roleType) {
        this.roleType = roleType;
    }

    public String getModifierUserName() {
        return modifierUserName;
    }

    public void setModifierUserName(String modifierUserName) {
        this.modifierUserName = modifierUserName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleDesc=").append(roleDesc);
        sb.append(", roleType=").append(roleType);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}