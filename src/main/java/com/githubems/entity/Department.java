package com.githubems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Created by 康得辉 on 2019/12/7.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "department")
public class Department implements Serializable{
    @Id
    private String id;
    private String departname;
}
