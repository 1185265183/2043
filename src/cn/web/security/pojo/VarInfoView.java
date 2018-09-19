package cn.web.security.pojo;

import java.io.Serializable;

/**
 * var_info_view
 * @author 
 */
public class VarInfoView implements Serializable {
    /**
     * 变量的id
     */
    private Integer vId;

    /**
     * 变量的名字
     */
    private String vName;

    /**
     * 变量的作用域修饰符
     */
    private String vModifier;

    /**
     * 变量的类型
     */
    private String vType;

    /**
     * 变量的初值（如果有的话），用字符串表示
     */
    private String vValue;

    /**
     * 函数id
     */
    private Integer fId;

    /**
     * 函数名
     */
    private String fName;

    /**
     * 类的id
     */
    private Integer cId;

    /**
     * 类的名字
     */
    private String cName;

    /**
     * 项目id
     */
    private Integer pId;

    /**
     * 项目名称
     */
    private String pName;

    private static final long serialVersionUID = 1L;

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvModifier() {
        return vModifier;
    }

    public void setvModifier(String vModifier) {
        this.vModifier = vModifier;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getvValue() {
        return vValue;
    }

    public void setvValue(String vValue) {
        this.vValue = vValue;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        VarInfoView other = (VarInfoView) that;
        return (this.getvId() == null ? other.getvId() == null : this.getvId().equals(other.getvId()))
            && (this.getvName() == null ? other.getvName() == null : this.getvName().equals(other.getvName()))
            && (this.getvModifier() == null ? other.getvModifier() == null : this.getvModifier().equals(other.getvModifier()))
            && (this.getvType() == null ? other.getvType() == null : this.getvType().equals(other.getvType()))
            && (this.getvValue() == null ? other.getvValue() == null : this.getvValue().equals(other.getvValue()))
            && (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfName() == null ? other.getfName() == null : this.getfName().equals(other.getfName()))
            && (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getcName() == null ? other.getcName() == null : this.getcName().equals(other.getcName()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getvId() == null) ? 0 : getvId().hashCode());
        result = prime * result + ((getvName() == null) ? 0 : getvName().hashCode());
        result = prime * result + ((getvModifier() == null) ? 0 : getvModifier().hashCode());
        result = prime * result + ((getvType() == null) ? 0 : getvType().hashCode());
        result = prime * result + ((getvValue() == null) ? 0 : getvValue().hashCode());
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfName() == null) ? 0 : getfName().hashCode());
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getcName() == null) ? 0 : getcName().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getpName() == null) ? 0 : getpName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vId=").append(vId);
        sb.append(", vName=").append(vName);
        sb.append(", vModifier=").append(vModifier);
        sb.append(", vType=").append(vType);
        sb.append(", vValue=").append(vValue);
        sb.append(", fId=").append(fId);
        sb.append(", fName=").append(fName);
        sb.append(", cId=").append(cId);
        sb.append(", cName=").append(cName);
        sb.append(", pId=").append(pId);
        sb.append(", pName=").append(pName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}