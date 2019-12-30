package com.eve.service.impl;


import com.eve.dao.dishMapper;
import com.eve.dto.DishDto;
import com.eve.entity.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eve.service.DishService;
import com.eve.service.PoiService;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

@Service
public class poiServiceImpl implements PoiService {
	@Autowired
	private dishMapper dishMapper;
	
	public void importFile( Workbook wb ){
	    int numberOfSheets = wb.getNumberOfSheets(); //获取sheet并遍历
	    System.out.println(numberOfSheets+"nummmmmmmmmof sheeeeeeeet");
	    Sheet sheet =wb.getSheetAt(0);
	    List<Dish> list = new ArrayList(); //创建好一个dishlist 之后读取完一行add一个dish进来
	    //按行循环
	    for (int r =1 ; r <= sheet.getLastRowNum(); r++) {  //r = 1 从表格第二行开始读取
	         Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
	         if (row == null){
	             continue;}
	         
	         Dish dish = new Dish();  //创建一个dish 实体         
	         //id 不需要 id根据sq生成 可以不从excel读取                                                 //第一个单元格是id                                                          
	         String dishName = row.getCell(1).getStringCellValue();//得到每x行第二个单元格的值
	         System.out.println("dishNAme:"+ dishName);
	         String description = row.getCell(2).getStringCellValue(); //得到每x行的 第三个单元格的值 
	         System.out.println("descrp:"+ description);
		     long dishType = (long)row.getCell(3).getNumericCellValue(); //得到每x行的 第三个单元格的值   
		     System.out.println("dishType:"+ dishType);
		     double price = row.getCell(4).getNumericCellValue(); //得到每x行的 第三个单元格的值
		     dish.setName(dishName);
		     dish.setDescription(description);
		     dish.setDishTypeId(dishType);
		     dish.setPrice(price);
		     list.add(dish);}
	    dishMapper.insertList(list);
		 }

	@Override
	public void exportFile(String tableName) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
	    XSSFSheet sheet = wb.createSheet("dishSheet");
	    XSSFRow row0 = sheet.createRow(0);//创建第一行
	    row0.createCell(0).setCellValue("Id");//为第一个单元格设值
	    row0.createCell(1).setCellValue("名");//为第二个单元格设值
	    row0.createCell(2).setCellValue("描述");//为第三个单元格设值
	    row0.createCell(3).setCellValue("种类ID");//为第四个单元格设值
	    row0.createCell(4).setCellValue("种类名");//为第五个单元格设值
	    row0.createCell(5).setCellValue("价格");//为第六个单元格设值
	    	
		List<DishDto> Dishes = dishMapper.selectAll();	
		for (int i=0; i<Dishes.size();i++ ){   //增强for循环 DishDto dish:Dishes在此处没有普通循环合适
			XSSFRow row = sheet.createRow(i+1);//创建第二行 第3 4 5 6 7
		    row.createCell(0).setCellValue(Dishes.get(i).getId());//为第一个单元格设值
		    row.createCell(1).setCellValue(Dishes.get(i).getName());//为第二个单元格设值
		    row.createCell(2).setCellValue(Dishes.get(i).getDescription());//为第三个单元格设值
		    row.createCell(3).setCellValue(Dishes.get(i).getDishTypeId());//为第四个单元格设值
		    row.createCell(4).setCellValue(Dishes.get(i).getTypeName());//为第五个单元格设值
		    row.createCell(5).setCellValue(Dishes.get(i).getPrice());//为第六个单元格设值    
		}

        //创建文件
        File path = new File("D:\\sgmuserprofile\\simkfv\\Desktop\\learn\\excel");   //""空filepath就是在当前目录生成
        if (!path.exists()) {
            path.mkdirs();
        }
        String fileName = System.currentTimeMillis() + "_Dish.xlsx";
        File file = new File(path, fileName);

        //输出文件
        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos);  //将workbook写入输出流
	

		
	}


	}
		         
