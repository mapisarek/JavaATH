package com.validator.transfer;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {

	void store(MultipartFile file);
	
}
