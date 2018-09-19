package cn.web.security.pojo;

import java.io.Serializable;

/**
 * classment_info_view
 * @author 
 */
public class ClassmentInfoView implements Serializable {
    /**
     * 类的id
     */
    private Integer cId;

    /**
     * 类的名字
     */
    private String cName;

    /**
     * 类的父类集合，包括权限修饰符和对应的类名
     */
    private String cFather;

    /**
     * 项目id
     */
    private Integer pId;

    /**
     * 项目名称
     */
    private String pName;

    private static final long serialVersionUID = 1L;

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

    public String getcFather() {
        return cFather;
    }

    public void setcFather(String cFather) {
        this.cFather = cFather;
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
        ClassmentInfoView other = (ClassmentInfoView) that;
        return (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getcName() == null ? other.getcName() == null : this.getcName().equals(other.getcName()))
            && (this.getcFather() == null ? other.getcFather() == null : this.getcFather().equals(other.getcFather()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getcName() == null) ? 0 : getcName().hashCode());
        result = prime * result + ((getcFather() == null) ? 0 : getcFather().hashCode());
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
        sb.append(", cId=").append(cId);
        sb.append(", cName=").append(cName);
        sb.append(", cFather=").append(cFather);
        sb.append(", pId=").append(pId);
        sb.append(", pName=").append(pName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}