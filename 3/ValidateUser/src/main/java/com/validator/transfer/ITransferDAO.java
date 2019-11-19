package com.validator.transfer;

import java.util.List;
import javax.sql.DataSource;

public interface ITransferDAO {
   
   public void addTransfer(Transfer transfer);
     
   public List<Transfer> listOfTransfers();
   
}
