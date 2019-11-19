package com.validator.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TransferDAO implements ITransferDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addTransfer(Transfer transfer) {
		String sql = "INSERT INTO transfer (firstname, lastname, account, amount, description) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, transfer.getFirstName(), transfer.getLastName(), transfer.getDestinationAccount(),transfer.getTransferAmount(),transfer.getTransferTitle());
	}

	@Override
	public List<Transfer> listOfTransfers() {

		return null;
	}

	
}
