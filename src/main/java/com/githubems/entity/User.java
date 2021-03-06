package com.githubems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable{
    @Id
    private String id;
    private String username;
    private String realname;
    private String password;
    private String salt;
    private String sex;
}
