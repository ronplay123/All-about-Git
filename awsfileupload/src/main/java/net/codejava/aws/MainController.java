package net.codejava.aws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	
	@GetMapping("")
    public String showHomePage() {
        return "upload";
}
	 @PostMapping("/upload")
	    public String uploadFile (String description, @RequestParam("file") MultipartFile multipart,
	    							Model model) {
	        String c = multipart.getOriginalFilename();
	        System.out.println("Description: " + description);
	        System.out.println("fileName: " + c);
	        String message = "";
	        try {
	            S3Util.uploadFile(c, multipart.getInputStream());
	            message = "Your file has been uploaded successfully!";
	        } catch (Exception ex) {
	            message = "Error uploading file: " + ex.getMessage();
	        }
	        model.addAttribute("message, message");
	        return "message";
	    }
}