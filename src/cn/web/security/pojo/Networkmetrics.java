package cn.web.security.pojo;

import java.io.Serializable;

/**
 * networkmetrics
 * @author 
 */
public class Networkmetrics implements Serializable {
    private Integer id;

    /**
     * 节点数
     */
    private Integer vertexnum;

    /**
     * 网络边数
     */
    private Integer edgenum;

    /**
     * 网络直径
     */
    private Integer networkdiameter;

    /**
     * 网络核数
     */
    private Integer networkcoreness;

    /**
     * 网络节点平均度
     */
    private Double nodeaveragedegree;

    /**
     * 网络平均最短路径长度
     */
    private Double averageshortestpathlength;

    /**
     * 网络效率
     */
    private Double networkefficiency;

    /**
     * 聚集系数
     */
    private Double networkclusteringcoefficient;

    private Integer projectid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVertexnum() {
        return vertexnum;
    }

    public void setVertexnum(Integer vertexnum) {
        this.vertexnum = vertexnum;
    }

    public Integer getEdgenum() {
        return edgenum;
    }

    public void setEdgenum(Integer edgenum) {
        this.edgenum = edgenum;
    }

    public Integer getNetworkdiameter() {
        return networkdiameter;
    }

    public void setNetworkdiameter(Integer networkdiameter) {
        this.networkdiameter = networkdiameter;
    }

    public Integer getNetworkcoreness() {
        return networkcoreness;
    }

    public void setNetworkcoreness(Integer networkcoreness) {
        this.networkcoreness = networkcoreness;
    }

    public Double getNodeaveragedegree() {
        return nodeaveragedegree;
    }

    public void setNodeaveragedegree(Double nodeaveragedegree) {
        this.nodeaveragedegree = nodeaveragedegree;
    }

    public Double getAverageshortestpathlength() {
        return averageshortestpathlength;
    }

    public void setAverageshortestpathlength(Double averageshortestpathlength) {
        this.averageshortestpathlength = averageshortestpathlength;
    }

    public Double getNetworkefficiency() {
        return networkefficiency;
    }

    public void setNetworkefficiency(Double networkefficiency) {
        this.networkefficiency = networkefficiency;
    }

    public Double getNetworkclusteringcoefficient() {
        return networkclusteringcoefficient;
    }

    public void setNetworkclusteringcoefficient(Double networkclusteringcoefficient) {
        this.networkclusteringcoefficient = networkclusteringcoefficient;
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
        Networkmetrics other = (Networkmetrics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVertexnum() == null ? other.getVertexnum() == null : this.getVertexnum().equals(other.getVertexnum()))
            && (this.getEdgenum() == null ? other.getEdgenum() == null : this.getEdgenum().equals(other.getEdgenum()))
            && (this.getNetworkdiameter() == null ? other.getNetworkdiameter() == null : this.getNetworkdiameter().equals(other.getNetworkdiameter()))
            && (this.getNetworkcoreness() == null ? other.getNetworkcoreness() == null : this.getNetworkcoreness().equals(other.getNetworkcoreness()))
            && (this.getNodeaveragedegree() == null ? other.getNodeaveragedegree() == null : this.getNodeaveragedegree().equals(other.getNodeaveragedegree()))
            && (this.getAverageshortestpathlength() == null ? other.getAverageshortestpathlength() == null : this.getAverageshortestpathlength().equals(other.getAverageshortestpathlength()))
            && (this.getNetworkefficiency() == null ? other.getNetworkefficiency() == null : this.getNetworkefficiency().equals(other.getNetworkefficiency()))
            && (this.getNetworkclusteringcoefficient() == null ? other.getNetworkclusteringcoefficient() == null : this.getNetworkclusteringcoefficient().equals(other.getNetworkclusteringcoefficient()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVertexnum() == null) ? 0 : getVertexnum().hashCode());
        result = prime * result + ((getEdgenum() == null) ? 0 : getEdgenum().hashCode());
        result = prime * result + ((getNetworkdiameter() == null) ? 0 : getNetworkdiameter().hashCode());
        result = prime * result + ((getNetworkcoreness() == null) ? 0 : getNetworkcoreness().hashCode());
        result = prime * result + ((getNodeaveragedegree() == null) ? 0 : getNodeaveragedegree().hashCode());
        result = prime * result + ((getAverageshortestpathlength() == null) ? 0 : getAverageshortestpathlength().hashCode());
        result = prime * result + ((getNetworkefficiency() == null) ? 0 : getNetworkefficiency().hashCode());
        result = prime * result + ((getNetworkclusteringcoefficient() == null) ? 0 : getNetworkclusteringcoefficient().hashCode());
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
        sb.append(", vertexnum=").append(vertexnum);
        sb.append(", edgenum=").append(edgenum);
        sb.append(", networkdiameter=").append(networkdiameter);
        sb.append(", networkcoreness=").append(networkcoreness);
        sb.append(", nodeaveragedegree=").append(nodeaveragedegree);
        sb.append(", averageshortestpathlength=").append(averageshortestpathlength);
        sb.append(", networkefficiency=").append(networkefficiency);
        sb.append(", networkclusteringcoefficient=").append(networkclusteringcoefficient);
        sb.append(", projectid=").append(projectid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}