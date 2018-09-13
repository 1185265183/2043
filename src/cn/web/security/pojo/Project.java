package cn.web.security.pojo;

public class Project {
    private Integer id;

    private String name;

    private String type;

    private String description;

    private Float versionid;

    private String path;

    private Integer ownerid;

    private Integer flagbit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Float getVersionid() {
        return versionid;
    }

    public void setVersionid(Float versionid) {
        this.versionid = versionid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Integer getFlagbit() {
        return flagbit;
    }

    public void setFlagbit(Integer flagbit) {
        this.flagbit = flagbit;
    }
}