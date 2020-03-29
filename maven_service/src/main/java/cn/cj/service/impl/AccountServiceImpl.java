package cn.cj.service.impl;

import cn.cj.dao.AccountDao;
import cn.cj.domain.Account;
import cn.cj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kjj208
 * @create 2020-03-28 0:08
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Account findById(Integer id) {
        Account byId = accountDao.findById(id);
        return byId;
    }

}
