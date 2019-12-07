package com.githubems.service;

import com.githubems.entity.Department;

import java.util.List;

/**
 * Created by 康得辉 on 2019/12/7.
 */
public interface DepartService {
    //添加部门
    void addDepart(Department department);
    //删除部门
    void deleteDepart(String id);
    //修改部门
    void updateDepart(Department department);
    //查询部门
    List<Department> quryDepart();
}
