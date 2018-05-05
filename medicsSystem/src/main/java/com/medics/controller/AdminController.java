package com.medics.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.medics.domain.PatientCommand;
import com.medics.domain.PersonJsonObject;
import com.medics.services.PatitentService;



@Controller
@EnableWebMvc
public class AdminController {
	
	@Autowired
	PatitentService patitentService;
	
	@RequestMapping(value="/PaginationValue")
	public void  adminShowPage(Model model,HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		System.out.println("admin show controler started");
		
		
		/*if(list!=null && list.size()>0)
		{
			model.addAttribute("CLIST",list);
		}*/
		
		
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		
		List<PatientCommand> retrieveRoomInstance=patitentService.getAllPatitentDetail();
	        
		PersonJsonObject personJsonObject=new PersonJsonObject();
		personJsonObject.setiTotalDisplayRecords(retrieveRoomInstance.size());
		personJsonObject.setiTotalRecords(retrieveRoomInstance.size());
		personJsonObject.setAaData(retrieveRoomInstance);
  
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(personJsonObject);
		out.print(json2);
		
		
		
	}

	
	@RequestMapping(value="/myservlet",method=RequestMethod.POST)
	public String generateReport(Model model,HttpServletRequest req)throws Exception
	{
		System.out.println("genrate report controller");
		
		int hospitalIdByUser=Integer.parseInt(req.getParameter("hospitalId"));
		if(req.getParameter("View")!=null)
		{
			PatientCommand patitentUserValue=patitentService.getPatitentDetailById(hospitalIdByUser);
			String patitentName=patitentUserValue.getPatitentName();
			String patitentAddress=patitentUserValue.getPatitentAddress();
			String pdfname=".pdf";
			File file=new File(patitentName+""+pdfname);
			 Document document = new Document();
		      try
		      {
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
		         document.open();
		         document.add(new Paragraph("Welcome To my hospital. You Are:-"+patitentName+"Your Address Is:-"+patitentAddress));
		         document.close();
		         writer.close();
		      } catch (DocumentException e)
		      {
		         e.printStackTrace();
		      } catch (FileNotFoundException e)
		      {
		         e.printStackTrace();
		      }
			
		}
		
		
		
		//System.out.println(patitentId+""+name+""+address);
		return "admin/patitentReport";
	}
	
	@RequestMapping(value="/addadmin" , method=RequestMethod.GET)
	public String showPaginationPage(Model model)
	{
		System.out.println("showing page controller started");
		
		return "admin/admin";
	}

}
