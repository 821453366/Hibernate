package com.study.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 马欢欢 on 2017/12/12.
 */
public class Role {
    private Integer ro_id;
    private String ro_name;
    /**
     *角色描述
     */
    private String ro_memo;

    /**
     * 一个角色多个用户
     * @retu     */
    private Set<User> users = new HashSet<User>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getRo_id() {
        return ro_id;
    }

    public void setRo_id(Integer ro_id) {
        this.ro_id = ro_id;
    }

    public String getRo_name() {
        return ro_name;
    }

    public void setRo_name(String ro_name) {
        this.ro_name = ro_name;
    }

    public String getRo_memo() {
        return ro_memo;
    }

    public void setRo_memo(String ro_memo) {
        this.ro_memo = ro_memo;
    }

}
