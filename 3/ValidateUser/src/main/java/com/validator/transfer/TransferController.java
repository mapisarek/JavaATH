package com.validator.transfer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class TransferController implements WebMvcConfigurer {

	@Autowired
	private ITransferService transferService;
	
	private static String UPLOADED_FOLDER = "D://tempJAVA//";
	
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/upload").setViewName("upload");
    }

    @GetMapping("/")
    public String showTransferForm(Transfer transfer) {
        return "transfer";
    }
    
    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }
    
    
    @PostMapping("/upload")
    public String uploadFileFromForm(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes){
    	if(file.getSize() > 300000)
    	{
    		 redirectAttributes.addFlashAttribute("message", "File too big. Upload <300 Kb");
             return "redirect:upload";	
    	}
    	 if (file.isEmpty()) {
             redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
             return "redirect:upload";
         }
         try {
        	 String validExtension = "xlsx";
        	 String extensionFromFile = FilenameUtils.getExtension(file.getOriginalFilename());
        	 
             byte[] bytes = file.getBytes();
             Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
             
        	 if(!extensionFromFile.equals(validExtension))
        	 {
        		 redirectAttributes.addFlashAttribute("message",
                         "Wrong file extension (only .xlsx)");
        		 return "redirect:upload";
        	 }else {
                 Files.write(path, bytes);
                 redirectAttributes.addFlashAttribute("message",
                         "You successfully uploaded '" + file.getOriginalFilename() + "'"); 
        	 }
         } catch (IOException e) {
             e.printStackTrace();
         }
         return "redirect:/upload";
    }
    

    @PostMapping("/")
    public String checkPersonInfo(@Valid @ModelAttribute Transfer transfer, BindingResult bindingResult,
    		RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "transfer";
        }
        else {
        	transferService.addTransfer(transfer);
        	redirectAttributes.addFlashAttribute("message",
                    "You successfully added Transfer to " + transfer.getFirstName() + " " +
        	transfer.getLastName() + " !");
        	System.out.println("Status powodzenia");
        	return "redirect:/upload";
        	
        }
        }
}