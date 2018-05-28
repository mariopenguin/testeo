package com.example.demo.servicios;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.clases.Empleado;
import com.example.demo.interfaces.EmpleadoService;
import com.example.demo.interfaces.ExcelService;
import com.example.demo.repositorios.EmpleadoRepository;

@Service
public class ExcelServiceImpl implements ExcelService {
	@Autowired
	public EmpleadoService employeeRepository;

	@Override
	public void getExcel(HttpServletResponse response) {
		String[] columns = { "NOMBRE", "PRIMER APELLIDO", "SEGUNDO APELLIDO", "DNI", "EMAIL", "DIRECCIÓN",
				"PUESTO ACTUAL", "TELÉFONO", "DEPARTAMENTO" };
		Iterable<Empleado> employees = employeeRepository.getAll();

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=employees.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Employee");
		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.BLUE_GREY.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Creating cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (Empleado employee : employees) {
			Row row = sheet.createRow(rowNum++);
			int numCell = 0;
			System.out.println(employee.getDireccion().toString());
			row.createCell(numCell++).setCellValue(employee.getNombre());
			row.createCell(numCell++).setCellValue(employee.getPrimerApellido());
			row.createCell(numCell++).setCellValue(employee.getSegundoApellido());
			row.createCell(numCell++).setCellValue(employee.getDni());
			row.createCell(numCell++).setCellValue(employee.getEmail());
			row.createCell(numCell++).setCellValue(employee.getDireccion());
			row.createCell(numCell++).setCellValue(employee.getPuestoActual());
			row.createCell(numCell++).setCellValue(employee.getTelefono());
			row.createCell(numCell++).setCellValue(employee.getDepartamento().getNombreDepartamento());
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		// FileOutputStream fileOut = new FileOutputStream("employees.xlsx");
		try {
			workbook.write(response.getOutputStream());
			response.getOutputStream().close();

			// Closing the workbook
			workbook.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
