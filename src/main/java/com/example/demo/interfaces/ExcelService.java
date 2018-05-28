package com.example.demo.interfaces;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;


public interface ExcelService {
	public void getExcel(HttpServletResponse response);
}
