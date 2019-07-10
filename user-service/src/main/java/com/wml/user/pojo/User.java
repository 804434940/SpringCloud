package com.wml.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Data
@Table(name = "user_db")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer uid;

    private String username;
    private String password;
    private String sex;
    private String address;

}
