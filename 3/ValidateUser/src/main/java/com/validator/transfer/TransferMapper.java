package com.validator.transfer;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class TransferMapper implements RowMapper<Transfer> {

	@Override
	public Transfer mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Transfer transfer = new Transfer();
		 transfer.setFirstName(rs.getString("firstname"));
		 transfer.setLastName(rs.getString("lastname"));
		 transfer.setDestinationAccount(rs.getString("account"));
		 transfer.setTransferAmount(rs.getString("amount"));
		 transfer.setTransferTitle(rs.getString("description"));
		return transfer;
	}

}
