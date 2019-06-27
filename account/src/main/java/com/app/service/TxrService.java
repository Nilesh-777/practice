package com.app.service;

public interface TxrService {
	public boolean transfer(String fromAccNum, String toAccNum, double balance);
}