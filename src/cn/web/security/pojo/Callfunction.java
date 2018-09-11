package cn.web.security.pojo;

public class Callfunction {
    private Integer id;

    private Integer nodeid;

    private Integer befunctionid;

    private String statement;

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

    public Integer getNodeid() {
        return nodeid;
    }

    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
    }

    public Integer getBefunctionid() {
        return befunctionid;
    }

    public void setBefunctionid(Integer befunctionid) {
        this.befunctionid = befunctionid;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
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