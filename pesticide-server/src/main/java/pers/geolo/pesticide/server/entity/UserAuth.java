package pers.geolo.pesticide.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户认证
 *
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@Entity
public class UserAuth {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userInfoId;
    private UserAuthType authType;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public UserAuthType getAuthType() {
        return authType;
    }

    public void setAuthType(UserAuthType authType) {
        this.authType = authType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
