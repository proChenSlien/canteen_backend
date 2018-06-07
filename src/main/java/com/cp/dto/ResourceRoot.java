package com.cp.dto;

import java.io.Serializable;
import java.util.List;

/**
 * TODO Reousrce 门面，Resource对象过滤parent，防止循环
 * @author : lf
 * @Date : 2017/6/24 14:44
 */

public class ResourceRoot implements Serializable {

    private String id;
    private String resource;    //对应url
    private String path;        //对应前台路径
    private String name;
    private String description;

    private List<ResourceRoot> children;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ResourceRoot> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceRoot> children) {
        this.children = children;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
