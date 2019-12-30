package com.eve.service;
import com.eve.dto.DishDto;
import com.eve.dto.OrderDto;
import com.eve.entity.*;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public interface PoiService {
	 void importFile( Workbook wb ) ;
	 void exportFile(String tableName) throws IOException;
	}




