package com.cp.controller;

import com.google.common.collect.Maps;
import com.cp.utils.Result;
import com.cp.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * TODO 按需使用，无需所有controller都继承此类。     基础crud功能，覆盖时override 时，需要和路径一起复写
 * @author : lf
 * @Date : 2017/6/26 15:11
 */
public abstract class BaseController<T, ID> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取T
     * @return
     */
    public Class getTClazz(){
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class[] clazzs = (Class[]) type.getActualTypeArguments();
        return clazzs[0];
    }

    /**
     * create and update
     * @param entity
     * @return
     */
    @PostMapping("/merge")
    public Result saveOrUpdate(@ModelAttribute T entity) {
        try {
            getService().save(entity);
        } catch (Exception e) {
            log.error("BaseController saveOrUpdate: ",e);
            return Result.createByError();
        }
        return Result.createBySuccess();
    }




    /**
     * get one by id
     * @param id
     * @return
     */
    @GetMapping("/one/{id}")
    public T read(@PathVariable ID id) {
        return getService().getOne(id);
    }

    /**
     * delete one by id
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable ID id) {
        try {
            getService().deleteById(id);
        } catch (Exception e) {
            log.error("baseController delete id " + id,e);
            return Result.createByError();
        }
        return Result.createBySuccess();
    }

    /**
     * 通用查询方法
     * @param size
     * @param page
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public Result<Map> list(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page, @ModelAttribute T entity) {
        Page<T> current = this.getService().findAll(page -1 ,size,entity);
        Map map = Maps.newHashMap();
        map.put("page", current);
        return Result.createBySuccess(map);
    }


    /**
     * service for T
     * @return
     */
    protected abstract BaseService<T, ID> getService();
}
