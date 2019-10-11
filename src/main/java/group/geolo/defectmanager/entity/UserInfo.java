package group.geolo.defectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息
 *
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private char sex;
    private Date birthday;
    private String address;
    private String avatarUrl;
    private String intro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
