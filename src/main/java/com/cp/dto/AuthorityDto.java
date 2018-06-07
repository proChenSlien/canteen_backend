package com.cp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * TODO  权限资源
 *
 * @author liufeng
 * @create 2017/8/7 18:58
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AuthorityDto {

    private String path;
    private String name;
    private Boolean hidden;
    private String resource;
    private List<AuthorityDto> children;

    public AuthorityDto() {
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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<AuthorityDto> getChildren() {
        return children;
    }

    public void setChildren(List<AuthorityDto> children) {
        this.children = children;
    }
}
