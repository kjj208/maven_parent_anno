package cn.cj.domain;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author kjj208
 * @since 2020-03-27 23:06:50
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 270997989057171654L;
    
    private Integer id;
    
    private String name;
    
    private Double money;

        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}