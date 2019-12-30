package com.eve.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.eve.dto.DishDto;
import com.eve.dto.OrderDto;
import com.eve.entity.Dish;
import com.eve.entity.Order;
import com.eve.entity.OrderItem;
import com.eve.service.DishService;
import com.eve.service.PoiService;

@RestController
public class BaseController {
	@Autowired
	private DishService dishService;
	
	@Autowired
	private PoiService poiService;

	@GetMapping("/test")
	public String search() {
		return "ok";
	}

	@GetMapping("/all")
	public List<DishDto> selectall() {
		return dishService.selectall();
	}

	@GetMapping("/getdish/{id}")
	public Object getdish(@PathVariable("id") Long id) {
		System.out.println("test :id: " + id);
		return dishService.selectByPrimaryKey(id);
	}


	@PostMapping("/insert")
	public String insert(@RequestBody DishDto dishDto) {
		long typeId = dishService.searchTypeId(dishDto.getTypeName());
		Dish dish = new Dish();
		// dish.setId(id);
		dish.setName(dishDto.getName());
		dish.setDescription(dishDto.getDescription());
		dish.setDishTypeId(typeId);
		dish.setPrice(dishDto.getPrice());
		dishService.insert(dish);
		return ("insert successfully");

	}

	@PostMapping("/insertlist")
	public void insertList(@RequestBody List<Dish> dishes) {
		// List<Dish> dishes = params.getJSONArray("dish");
		System.out.print("dishes" + dishes);
		dishService.insertList(dishes);

	}

	@PostMapping("/changeprice")
	public void changePrice(@RequestParam("id") Long id,
			@RequestParam("price") double price) {
		dishService.changePrice(id, price);
	}

	@PostMapping("/room")
	public List<DishDto> room(@RequestBody Order order) {
		order.setCreatedOn(new Date());
		dishService.getRoom(order);
		System.out.println(order);
		return(dishService.selectall());
	}

	@PostMapping("/checkOrderId")
	public long checkOrderId(@RequestParam ("roomId")  long roomId) {
	    return  dishService.checkOrderId(roomId);	
	}
	
	@PostMapping("/orderDishes")
	public String orderDishes(@RequestBody List<OrderItem> orderItem) {
		dishService.orderDishes(orderItem);
		long orderId = orderItem.get(0).getOrderId();
	    return("您已点菜成功,菜品总价：" + dishService.freshPrice(orderId)+"元");	
	}
	
	@PostMapping ("/check")
	public Order brief(@RequestParam("roomId") long roomId){
		return dishService.brief(roomId);
	}
	
	@PostMapping ("/check/detail")
	public OrderDto detail(@RequestParam("roomId") long roomId){
		//分两步走 第一步查到order的基本信息 第二步根据orderid 把菜打成一个list放到新赠的dish键里面 
		//打包放进 orderdto
              
		return dishService.detail(roomId);
	}
	
	@PostMapping ("/test")
	public OrderDto test(@RequestParam("roomId") long roomId){
		//分两步走 第一步查到order的基本信息 第二步根据orderid 把菜打成一个list放到新赠的dish键里面 
		//打包放进 orderdto
              
		return dishService.test(roomId);
	}
	
	
//	
//	@PostMapping("/import")
//	public String exImport(@RequestParam("excelFile") MultipartFile xlsFile ) throws InvalidFormatException, IOException{
//	   // Workbook wb=WorkbookFactory.create(xlsFile.getInputStream()); //create会自动根据文件类型创建hss/xss
//	    //把workbook传入service
//	       String fileName = xlsFile.getOriginalFilename();
//	       boolean isExcel2003 = true;
//	       if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//	    	   System.out.println("it is xlsx");
//	          isExcel2003 = false;
//	       }
//	       InputStream inputStream=xlsFile.getInputStream();
//	       Workbook wb = null;
//	       if (isExcel2003) {
//	          wb = new HSSFWorkbook(inputStream);
//	       } else {
//	          wb =new  XSSFWorkbook(inputStream);
//	       }
//	
//	    poiService.importFile(wb);
//		return "读取表格成功，并插入数据库";
//		
//	}
	
	
	@PostMapping("/export")
	public String exExport(@RequestParam("tableName") String tableName) throws IOException{
		poiService.exportFile(tableName);
		
		return "导出成功";
	}
	
	
	

	@PostMapping("/easyExcel")
	public String easy() throws IOException{
		
        String fileName = "D:\\sgmuserprofile\\simkfv\\Desktop\\learn\\excel\\dish.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, Dish.class, new DemoDataListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
		return "easy piece lemon squeeze";
	}
	
}