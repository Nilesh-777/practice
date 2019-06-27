package com.app.service;

import static com.app.factory.Factory.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.repository.AccountRepository;

//@Service("UPItxrService")
public class UPITxrService implements TxrService {

//	@Autowired
	// @Qualifier(value="jdbc")
	private AccountRepository accRepo;

	public AccountRepository getAccRepo() {
		return accRepo;
	}

	public void setAccRepo(AccountRepository accRepo) {
		this.accRepo = accRepo;
	}

	public UPITxrService() {
	}

	public boolean transfer(String fromAccNum, String toAccNum, double balance) {
		logger.info("Transfer initiated");
		Account fromAcc = accRepo.load(fromAccNum);
		Account toAcc = accRepo.load(toAccNum);

		accRepo.update(fromAccNum, fromAcc.getBalance() - balance);
		accRepo.update(toAccNum, toAcc.getBalance() + balance);

		return true;
	}
}
