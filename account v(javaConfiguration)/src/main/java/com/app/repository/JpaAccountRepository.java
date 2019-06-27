package com.app.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.app.model.Account;


@Repository("JpaAccountRepository")
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {
	
	
	

	@Override
	public Account load(String accNum) {
		return null;
	}

	@Override
	public Account update(String accNum, double balance) {
		return null;
	}

}