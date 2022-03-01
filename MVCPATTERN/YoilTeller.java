package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//년월일을 입력하면 요일을 알려주는 프로그램
//This program will let you know date

@Controller
public class YoilTellerMVC {	//http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1
	
	@RequestMapping("/getYoilMVC")
	
	//	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException{	
		public String main(int year, int month, int day, Model model) throws IOException {
		
		
		//1. CHECK VALIDATION (유효성 검사)
		
		if(isValid(year, month, day)) {
			return "yoilError";
		}
		
		//2.  Calculate the yoil (요일계산)
		String yoil = getYoil(year, month, day);
		
		//3. save the result into the model
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil";	//This will return /WEB-INF/views/yoil.jsp
	}

	
	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return false;
	}

	private String getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		String[] dayOfWeek2 = {"", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
		
		return dayOfWeek2[dayOfWeek];
	}
}
