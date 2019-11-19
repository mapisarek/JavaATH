package com.validator.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService implements ITransferService {

	@Autowired
	private ITransferDAO transferDAO;
	
	@Override
	public synchronized boolean addTransfer(Transfer transfer) {
		transferDAO.addTransfer(transfer);
		return true;
	}

	
}
