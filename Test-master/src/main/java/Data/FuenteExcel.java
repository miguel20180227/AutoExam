package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;


import Framework.Cls_Log_Ejecucion;
 
public class FuenteExcel
{

	private String ruta_excel;
	private String ext_excel;
	
	public FuenteExcel(){}
	
	public void cargaConfiguracionExcel(String ruta){
		ruta_excel = ruta;
		String [] tmp_ext_excel = ruta_excel.split("\\.");
		ext_excel = tmp_ext_excel[tmp_ext_excel.length-1];
	}
	
	public String getRutaExcel(){
		return this.ruta_excel;
	}
	
	public String getExtExcel(){
		return this.ext_excel;
	}
	

}