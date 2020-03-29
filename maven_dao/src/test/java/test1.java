import cn.cj.config.SpringConfiguration_dao;
import cn.cj.dao.AccountDao;
import cn.cj.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author kjj208
 * @create 2020-03-28 11:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfiguration_dao.class)
public class test1 {
   /* @Test
    // 纯Java方法使用c3p0
    public void C3p0Demo() throws PropertyVetoException, SQLException {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setUser("root");// 用户姓名
        pool.setPassword("kjj208");// 用户密码
        pool.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/ssm?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8");// MySQL数据库连接url
        pool.setDriverClass("com.mysql.cj.jdbc.Driver");

        // pool可以调用set方法进行Connection池的配置

        // 连接关闭之后，内存会被释放，下次取时会重新开(内存地址不共用)
        for (int i = 0; i < 20; i++) {
            Connection con = pool.getConnection();
            System.out.println(i + ":" + con);
            if (i % 2 == 0) {
                con.close();
            }
        }
    }*/

    @Autowired
    private AccountDao dao;

    @Test
    public  void test1(){
        Account account = dao.findById(123);
        System.out.println(account);
    }


}
