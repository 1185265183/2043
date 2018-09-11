package cn.web.security.pojo;

public class Assign {
    private Integer id;

    private Integer nodeid;

    private Integer bevarid;

    private Integer functionid;

    private String statement;

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

    public Integer getBevarid() {
        return bevarid;
    }

    public void setBevarid(Integer bevarid) {
        this.bevarid = bevarid;
    }

    public Integer getFunctionid() {
        return functionid;
    }

    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
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