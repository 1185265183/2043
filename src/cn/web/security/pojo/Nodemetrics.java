package cn.web.security.pojo;

import java.io.Serializable;

/**
 * nodemetrics
 * @author 
 */
public class Nodemetrics implements Serializable {
    private Integer id;

    /**
     * 度
     */
    private Integer degree;

    /**
     * 入度
     */
    private Integer indegree;

    /**
     * 出度
     */
    private Integer outdegree;

    /**
     * 影响范围
     */
    private Double nodeinfluenceregion;

    /**
     * 最大邻居连通度
     */
    private Double nodemnc;

    /**
     * 最大邻居连通密度
     */
    private Double nodedmnc;

    /**
     * 接近度
     */
    private Double proximity;

    /**
     * 节点聚类系数
     */
    private Double nodecc;

    /**
     * 节点中介中心性
     */
    private Double nodebc;

    /**
     * node core
     */
    private Integer nodecore;

    /**
     * 度中心性
     */
    private Double degreecentrality;

    /**
     * 所属项目ID
     */
    private Integer projectid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getIndegree() {
        return indegree;
    }

    public void setIndegree(Integer indegree) {
        this.indegree = indegree;
    }

    public Integer getOutdegree() {
        return outdegree;
    }

    public void setOutdegree(Integer outdegree) {
        this.outdegree = outdegree;
    }

    public Double getNodeinfluenceregion() {
        return nodeinfluenceregion;
    }

    public void setNodeinfluenceregion(Double nodeinfluenceregion) {
        this.nodeinfluenceregion = nodeinfluenceregion;
    }

    public Double getNodemnc() {
        return nodemnc;
    }

    public void setNodemnc(Double nodemnc) {
        this.nodemnc = nodemnc;
    }

    public Double getNodedmnc() {
        return nodedmnc;
    }

    public void setNodedmnc(Double nodedmnc) {
        this.nodedmnc = nodedmnc;
    }

    public Double getProximity() {
        return proximity;
    }

    public void setProximity(Double proximity) {
        this.proximity = proximity;
    }

    public Double getNodecc() {
        return nodecc;
    }

    public void setNodecc(Double nodecc) {
        this.nodecc = nodecc;
    }

    public Double getNodebc() {
        return nodebc;
    }

    public void setNodebc(Double nodebc) {
        this.nodebc = nodebc;
    }

    public Integer getNodecore() {
        return nodecore;
    }

    public void setNodecore(Integer nodecore) {
        this.nodecore = nodecore;
    }

    public Double getDegreecentrality() {
        return degreecentrality;
    }

    public void setDegreecentrality(Double degreecentrality) {
        this.degreecentrality = degreecentrality;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
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
        Nodemetrics other = (Nodemetrics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDegree() == null ? other.getDegree() == null : this.getDegree().equals(other.getDegree()))
            && (this.getIndegree() == null ? other.getIndegree() == null : this.getIndegree().equals(other.getIndegree()))
            && (this.getOutdegree() == null ? other.getOutdegree() == null : this.getOutdegree().equals(other.getOutdegree()))
            && (this.getNodeinfluenceregion() == null ? other.getNodeinfluenceregion() == null : this.getNodeinfluenceregion().equals(other.getNodeinfluenceregion()))
            && (this.getNodemnc() == null ? other.getNodemnc() == null : this.getNodemnc().equals(other.getNodemnc()))
            && (this.getNodedmnc() == null ? other.getNodedmnc() == null : this.getNodedmnc().equals(other.getNodedmnc()))
            && (this.getProximity() == null ? other.getProximity() == null : this.getProximity().equals(other.getProximity()))
            && (this.getNodecc() == null ? other.getNodecc() == null : this.getNodecc().equals(other.getNodecc()))
            && (this.getNodebc() == null ? other.getNodebc() == null : this.getNodebc().equals(other.getNodebc()))
            && (this.getNodecore() == null ? other.getNodecore() == null : this.getNodecore().equals(other.getNodecore()))
            && (this.getDegreecentrality() == null ? other.getDegreecentrality() == null : this.getDegreecentrality().equals(other.getDegreecentrality()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDegree() == null) ? 0 : getDegree().hashCode());
        result = prime * result + ((getIndegree() == null) ? 0 : getIndegree().hashCode());
        result = prime * result + ((getOutdegree() == null) ? 0 : getOutdegree().hashCode());
        result = prime * result + ((getNodeinfluenceregion() == null) ? 0 : getNodeinfluenceregion().hashCode());
        result = prime * result + ((getNodemnc() == null) ? 0 : getNodemnc().hashCode());
        result = prime * result + ((getNodedmnc() == null) ? 0 : getNodedmnc().hashCode());
        result = prime * result + ((getProximity() == null) ? 0 : getProximity().hashCode());
        result = prime * result + ((getNodecc() == null) ? 0 : getNodecc().hashCode());
        result = prime * result + ((getNodebc() == null) ? 0 : getNodebc().hashCode());
        result = prime * result + ((getNodecore() == null) ? 0 : getNodecore().hashCode());
        result = prime * result + ((getDegreecentrality() == null) ? 0 : getDegreecentrality().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", degree=").append(degree);
        sb.append(", indegree=").append(indegree);
        sb.append(", outdegree=").append(outdegree);
        sb.append(", nodeinfluenceregion=").append(nodeinfluenceregion);
        sb.append(", nodemnc=").append(nodemnc);
        sb.append(", nodedmnc=").append(nodedmnc);
        sb.append(", proximity=").append(proximity);
        sb.append(", nodecc=").append(nodecc);
        sb.append(", nodebc=").append(nodebc);
        sb.append(", nodecore=").append(nodecore);
        sb.append(", degreecentrality=").append(degreecentrality);
        sb.append(", projectid=").append(projectid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}