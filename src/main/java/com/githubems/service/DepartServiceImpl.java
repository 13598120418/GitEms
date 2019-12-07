package com.githubems.service;

import com.githubems.dao.DepartDao;
import com.githubems.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by 康得辉 on 2019/12/7.
 */
@Service
@Transactional
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartDao departDao;
    @Override
    public void addDepart(Department department) {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        department.setId(s);
        departDao.insert(department);
    }

    @Override
    public void deleteDepart(String id) {
        departDao.delete(new Department().setId(id));
    }

    @Override
    public void updateDepart(Department department) {
        departDao.updateByPrimaryKeySelective(department);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Department> quryDepart() {
        return departDao.selectAll();
    }
}
