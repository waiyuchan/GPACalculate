package gpa.utill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gpa.data.GradeData;

public class FileRead {

	public ArrayList<GradeData> txtRead(String filepath) {

		ArrayList<GradeData> gradeDatas = new ArrayList<GradeData>();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			
			String line = "";

			while ((line= br.readLine()) != null) {
				
				GradeData gradeData = new GradeData();
				
				String[] gData = line.split("/");
				
				gradeData.setCourse(gData[0]);
				gradeData.setCredit(gData[1]);
				gradeData.setGrade(Float.valueOf(gData[2]));
				
				gradeDatas.add(gradeData);
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return gradeDatas;

	}
	
	public ArrayList<GradeData> excelRead(String filepath) {

		ArrayList<GradeData> gradeDatas = new ArrayList<GradeData>();
		int point = filepath.indexOf(".");
		int last = filepath.length();

		System.out.println("输入的Excel文件类型是：" + filepath.substring(point + 1, last));
		try {
			if (filepath.substring(point, last).equals(".xls")) {
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filepath)));
				HSSFSheet sheet = null;
				for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
					sheet = workbook.getSheetAt(i);
					for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
						HSSFRow hssfRow = sheet.getRow(j);
						if (hssfRow != null) {
							GradeData gradeData = new GradeData();
							for (int k = 0; k < hssfRow.getLastCellNum(); k++) {
								if (hssfRow.getCell(k) != null) {
									if (k == 0) {
										gradeData.setCourse(hssfRow.getCell(k).toString());
									}
									if (k == 1) {
										gradeData.setCredit(hssfRow.getCell(k).toString());
									}
									if (k == 2) {
										gradeData.setGrade(Float.valueOf(hssfRow.getCell(k).toString()));
									}
									if ((k + 1) % 3 == 0) {
										gradeDatas.add(gradeData);
									}
								}
							}
						}
					}
					System.out.println("导出的成绩表：");
					for (GradeData gradeData2 : gradeDatas) {
						System.out.println(
								gradeData2.getCourse() + "|" + gradeData2.getCredit() + "|" + gradeData2.getGrade());
					}
				}
			} else {
				XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(filepath)));
				XSSFSheet sheet = null;
				for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
					sheet = workbook.getSheetAt(i);
					for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
						XSSFRow hssfRow = sheet.getRow(j);
						if (hssfRow != null) {
							GradeData gradeData = new GradeData();
							for (int k = 0; k < hssfRow.getLastCellNum(); k++) {
								if (hssfRow.getCell(k) != null) {
									if (k == 0) {
										gradeData.setCourse(hssfRow.getCell(k).toString());
									}
									if (k == 1) {
										gradeData.setCredit(hssfRow.getCell(k).toString());
									}
									if (k == 2) {
										gradeData.setGrade(Float.valueOf(hssfRow.getCell(k).toString()));
									}
									if ((k + 1) % 3 == 0) {
										gradeDatas.add(gradeData);
									}
								}

							}
						}
					}
					System.out.println("导出的成绩表：");
					for (GradeData gradeData2 : gradeDatas) {
						System.out.println(
								gradeData2.getCourse() + "|" + gradeData2.getCredit() + "|" + gradeData2.getGrade());
					}
				}
			}

		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gradeDatas;

	}

}
