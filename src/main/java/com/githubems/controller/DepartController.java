package com.githubems.controller;

import com.githubems.entity.Department;
import com.githubems.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 康得辉 on 2019/12/7.
 */
@RestController
@RequestMapping("depart")
public class DepartController {
    @Autowired
    private DepartService departService;
    @RequestMapping("queryAll")
    public Map<String,Object> queryAll(){
        Map<String, Object> map = new HashMap<>();
        List<Department> list = departService.quryDepart();
        map.put("status",200);
        map.put("list",list);
        return map;
    }
    @RequestMapping("addDepart")
    public Map<String,Object> add(Department department){
        Map<String, Object> map = new HashMap<>();
        departService.addDepart(department);
        map.put("status", "添加成功");
        return map;
    }
    @RequestMapping("updateDepart")
    public Map<String,Object> update(Department department){
        Map<String, Object> map = new HashMap<>();
        departService.updateDepart(department);
        map.put("status", "更新成功");
        return map;
    }
    @RequestMapping("deleteDepart")
    public Map<String,Object> delete(String id){
        Map<String, Object> map = new HashMap<>();
        departService.deleteDepart(id);
        map.put("status", "删除成功");
        return map;
    }


}
