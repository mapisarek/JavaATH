package com.validator.transfer;

import javax.validation.constraints.NotNull;

public class Transfer {
	
	@NotNull
	private String FirstName;
	@NotNull
	private String LastName;
	@NotNull
	private String DestinationAccount;
	@NotNull
	private String TransferAmount;
	@NotNull
	private String TransferTitle;
	
	public String getTransferAmount() {
		return TransferAmount;
	}
	public void setTransferAmount(String transferAmount) {
		try {
			Double.parseDouble(transferAmount.replaceAll(",","."));
			if(Integer.parseInt(transferAmount.substring(transferAmount.indexOf(".")+1) )> 99)
				transferAmount = null;
		}catch(Exception exception) {
			transferAmount = null;
		}
		TransferAmount = transferAmount;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		if(!lastName.matches("^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ\\s]*$") || lastName.length() == 0) {
			lastName = null;
		}else
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		if(!firstName.matches("^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ\\s]*$") || firstName.length() == 0) {
		firstName = null;
		}else
		FirstName = firstName;
	}
	public String getDestinationAccount() {
		return DestinationAccount;
	}
	
	public void setDestinationAccount(String destinationAccount) {
		if(destinationAccount.length() != 16 || !destinationAccount.matches("^[0-9]*$") || destinationAccount.length() == 0){
		destinationAccount = null;
		}else
		DestinationAccount = destinationAccount;
	}
	
	public String getTransferTitle() {
		return TransferTitle;
	}
	public void setTransferTitle(String transferTitle) {
		if(transferTitle.length() > 40 || transferTitle.length() == 0) {
		transferTitle = null;
		}else
		TransferTitle = transferTitle;
	}
	
}
