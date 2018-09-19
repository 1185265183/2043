package cn.web.security.pojo;

import java.io.Serializable;

/**
 * functions_info_view
 * @author 
 */
public class FunctionsInfoView implements Serializable {
    /**
     * 函数id
     */
    private Integer fId;

    /**
     * 函数名
     */
    private String fName;

    /**
     * 函数的修饰符，比如静态方法之类的
     */
    private String fModifiter;

    /**
     * 函数的返回值类型
     */
    private String fReturntype;

    /**
     * 函数的形参列表
     */
    private String fParameter;

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

    public String getfModifiter() {
        return fModifiter;
    }

    public void setfModifiter(String fModifiter) {
        this.fModifiter = fModifiter;
    }

    public String getfReturntype() {
        return fReturntype;
    }

    public void setfReturntype(String fReturntype) {
        this.fReturntype = fReturntype;
    }

    public String getfParameter() {
        return fParameter;
    }

    public void setfParameter(String fParameter) {
        this.fParameter = fParameter;
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
        FunctionsInfoView other = (FunctionsInfoView) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfName() == null ? other.getfName() == null : this.getfName().equals(other.getfName()))
            && (this.getfModifiter() == null ? other.getfModifiter() == null : this.getfModifiter().equals(other.getfModifiter()))
            && (this.getfReturntype() == null ? other.getfReturntype() == null : this.getfReturntype().equals(other.getfReturntype()))
            && (this.getfParameter() == null ? other.getfParameter() == null : this.getfParameter().equals(other.getfParameter()))
            && (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getcName() == null ? other.getcName() == null : this.getcName().equals(other.getcName()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfName() == null) ? 0 : getfName().hashCode());
        result = prime * result + ((getfModifiter() == null) ? 0 : getfModifiter().hashCode());
        result = prime * result + ((getfReturntype() == null) ? 0 : getfReturntype().hashCode());
        result = prime * result + ((getfParameter() == null) ? 0 : getfParameter().hashCode());
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
        sb.append(", fId=").append(fId);
        sb.append(", fName=").append(fName);
        sb.append(", fModifiter=").append(fModifiter);
        sb.append(", fReturntype=").append(fReturntype);
        sb.append(", fParameter=").append(fParameter);
        sb.append(", cId=").append(cId);
        sb.append(", cName=").append(cName);
        sb.append(", pId=").append(pId);
        sb.append(", pName=").append(pName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}