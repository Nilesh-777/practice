package com.app.repository;

import com.app.model.Account;

public interface AccountRepository {
          Account load(String accNum);
          Account update(String accNum,double balance);
          
}
