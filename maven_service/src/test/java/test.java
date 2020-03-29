import cn.cj.config.SpringConfiguration_service;
import cn.cj.domain.Account;
import cn.cj.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kjj208
 * @create 2020-03-28 11:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfiguration_service.class)
public class test {

    @Autowired
    private AccountService as;

    @Test
    public  void test1(){
        Account account = as.findById(123);
        System.out.println(account);
    }
}
