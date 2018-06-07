package com.cp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;
import com.cp.domain.Resource;
import com.cp.dto.AuthorityDto;
import com.cp.dto.ResourceRoot;
import com.cp.service.BaseService;
import com.cp.service.ResourceService;
import com.cp.utils.BeanMapper;
import com.cp.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author : lf
 * @Date : 2017/6/26 15:11
 */
@RestController
@RequestMapping("/manage/resource")
public class ResourceController extends BaseController<Resource, String> {

    @Autowired
    private ResourceService resourceService;


    @ApiOperation("同步权限信息")
    @PostMapping("/sync")
    public Result syncResource(@RequestBody List<AuthorityDto> beanList){
        resourceService.updateOrInsert(beanList);
        return Result.createBySuccess();
    }

    @ApiOperation("获取资源树")
    @GetMapping("/root")
    public Result root() throws JsonProcessingException {
        List<Resource> resources = resourceService.getRoot();
        List<ResourceRoot> root = BeanMapper.mapList(resources, ResourceRoot.class);
        Map map = Maps.newHashMap();
        map.put("root", root);
        return Result.createBySuccess(map);
    }


    @Override
    protected BaseService getService() {
        return resourceService;
    }
}
