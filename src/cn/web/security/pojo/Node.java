package cn.web.security.pojo;

public class Node {
    private Integer id;

    private Integer fatherid;

    private String name;

    private String nodecondition;

    private Integer functionid;

    private Integer position;

    private String casecondition;

    private Integer projectid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNodecondition() {
        return nodecondition;
    }

    public void setNodecondition(String nodecondition) {
        this.nodecondition = nodecondition == null ? null : nodecondition.trim();
    }

    public Integer getFunctionid() {
        return functionid;
    }

    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getCasecondition() {
        return casecondition;
    }

    public void setCasecondition(String casecondition) {
        this.casecondition = casecondition == null ? null : casecondition.trim();
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
}