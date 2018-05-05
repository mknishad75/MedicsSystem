package com.medics.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.medics.domain.PatientCommand;
import com.medics.services.PatitentService;

@EnableWebMvc
@Controller
public class UploadController {
	
	@Autowired
	PatitentService patitentService;
	
	private String fileLocation;
	 	
	public String uploadFile(MultipartFile file) throws IOException {
	    InputStream in = file.getInputStream();
	    File currDir = new File(".");
	    String path = currDir.getAbsolutePath();
	    fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
	    FileOutputStream f = new FileOutputStream(fileLocation);
	    int ch = 0;
	    while ((ch = in.read()) != -1) {
	        f.write(ch);
	    }
	    f.flush();
	    f.close();
	   
	    return fileLocation;
	}
	
	@RequestMapping(value="/processExcel" ,method=RequestMethod.POST)
	public String UploadExcelFile(Model model, @RequestParam("excelfile")MultipartFile excelfile)throws IOException, Exception
	{    
			System.out.println("uploding controller is started");
			fileLocation = uploadFile(excelfile);
			
			List<PatientCommand> lstUser = new ArrayList<PatientCommand>();
			int i = 0;
			// Creates a workbook object from the uploaded excelfile
			
	        
	        if (fileLocation != null) {
	            if (fileLocation.endsWith(".xlsx") || fileLocation.endsWith(".xls")) {
	    			
	    	        FileInputStream inputStream = new FileInputStream(new File(fileLocation));
	    	         
	    	        Workbook workbook = new XSSFWorkbook(inputStream);
	    	        Sheet worksheet = workbook.getSheetAt(0);
	    	        
	    	        while (i <= worksheet.getLastRowNum()) {
	    				// Creates an object for the UserInfo Model
	    				PatientCommand patitentvalue=new PatientCommand();
	    				// Creates an object representing a single row in excel
	    				XSSFRow row = (XSSFRow) worksheet.getRow(i++);
	    				// Sets the Read data to the model class
	    				
	    				patitentvalue.setPatientId((int) row.getCell(0).getNumericCellValue());
	    				patitentvalue.setPatitentName(row.getCell(1).getStringCellValue());
	    				patitentvalue.setPatitentAddress(row.getCell(2).getStringCellValue());
	    				// persist data into database in here
	    				boolean b=patitentService.addPatitentDetail(patitentvalue);
	    				//lstUser.add(patitentvalue);
	    				System.out.println(b);
	    			}			
	    			//workbook.close();
	    			model.addAttribute("lstUser", lstUser);
	    	        
	            } else {
	                model.addAttribute("message", "Not a valid excel file!");
	            }
	        } else {
	            model.addAttribute("message", "File missing! Please upload an excel file.");
	        }
			
			/*System.out.println("file Name "+ excelfile.getOriginalFilename());
			Workbook workbook = WorkbookFactory.create(new File(excelfile.getOriginalFilename()));
			//XSSFWorkbook workbook = new XSSFWorkbook(pkg);
			//HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(excelfile.getOriginalFilename()));
			// Creates a worksheet object representing the first sheet
			Sheet worksheet = workbook.getSheetAt(0);*/
			// Reads the data in excel file until last row is encountered
			
		 
 
		return "home";	
	    	
	
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String requestUploadFile()throws Exception
	{
		System.out.println("User Rquested for upload file");
		
		return "/uploadfile";
	}
	

}
