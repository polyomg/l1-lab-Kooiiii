package Lab8.service.impl;

import Lab8.dao.AccountDAO;
import Lab8.entity.Account;
import Lab8.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    public Account findById(String username) {
        return accountDAO.findById(username).orElse(null);
    }
}
