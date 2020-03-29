package cn.cj.controller;

import cn.cj.domain.Account;
import cn.cj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kjj208
 * @create 2020-03-28 17:58
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/accountDetail")
    public String accountDetail(Model model){
        Account account = accountService.findById(123);
        model.addAttribute("account", account);
        return "accountDetail";
    }
}
