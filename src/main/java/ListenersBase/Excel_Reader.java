package ListenersBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import orgGeneric.BaseClass;

public class Excel_Reader extends BaseClass {
	public static FileInputStream fis=null;
	public FileOutputStream fos=null;
	private Workbook workbook=null;
	public static int allRows;
	static String cellData="";
	public static Workbook getworkbook() throws Exception
	{
		path=xlProperties.getProperty("path");
		fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		System.out.println(path+"  workbook opened");
		ExtentReportUtils.logs.info(path+"  workbook opened");		
		return wb;
	}

	public static Sheet getSheet() throws Exception
	{
		sheet=xlProperties.getProperty("sheetname");
		Sheet sheetname=getworkbook().getSheet(sheet);
		System.out.println("Running sheet "+sheet);
		ExtentReportUtils.logs.info("Running sheet "+sheet);	
		return sheetname;
	}
	
	public static int getRowCount() throws Exception
	{
		allRows=getworkbook().getSheet(sheet).getPhysicalNumberOfRows();	
		return allRows;
	}
	
	public static int getCellCount() throws Exception
	{   
		int allCell=getworkbook().getSheet(sheet).getRow(0).getLastCellNum();	
		return allCell;
	}
	
	public static String getCellData(String colName,int rowNum)
	{   
		try{int allRows=getRowCount();
	        if(allRows<=0)
		    return "";
	        int col_Num=-1;
	        Row row=getSheet().getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
	        
			if(col_Num==-1)
			return "";
			
			Cell cell= getSheet().getRow(rowNum).getCell(col_Num);
			
			if(cell==null)
		    return "";
			
			if(cell.getCellTypeEnum()==CellType.STRING)
			{
				cellData=cell.getStringCellValue();
			}
			else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			{
				cellData=String.valueOf(cell.getNumericCellValue());
			}
			else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			{
				cellData=String.valueOf(cell.getBooleanCellValue());
			}
			
			/*if(cell.getCellType()==Cell.CELL_TYPE_STRING )
			{
				String cellText=cell.getStringCellValue();
			}
			*/			
		}
	  catch(Exception e)
	     {
		  System.out.println(e.getStackTrace());
	     }
	return cellData;
	}
	
	
	public static String getCellData(int colNum,int rowNum)
	{
		try
		{
			Row row=getSheet().getRow(rowNum-1);
			if(row==null)
			return "";
			
			Cell cell=row.getCell(colNum);

			if(cell==null)
				return "";
			
			if(cell.getCellTypeEnum()==CellType.STRING)
			{
				cellData=cell.getStringCellValue();
			}
			else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			{
				cellData=String.valueOf(cell.getNumericCellValue());
			}
			else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			{
				cellData=String.valueOf(cell.getBooleanCellValue());
			}
			
		}
		  catch(Exception e)
	     {
		  System.out.println(e.getStackTrace());
	     }
	return cellData;
		
	}
	/********************************************************/
	/*Set cell data*/
	public static void setCellData(String colName,int rowNum,String data)
	{
		try{
			Workbook wb=getworkbook();
			Sheet sh=getSheet();
			int colNum=-1;
			
			Row row=sh.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			row=sh.getRow(rowNum);
			if(row==null){
				row=sh.createRow(rowNum);
			}
			Cell cell=row.getCell(colNum);
			if(cell==null)
			{cell=row.createCell(colNum);}
			
			cell.setCellValue(data);
			FileOutputStream fileOut=new FileOutputStream(path);
			wb.write(fileOut);
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	/***************Get cell row number**********/
	public static int getCellRowNum(String colName,String testcaseName)throws Exception
	{
		int rownum=-1;
		for(int i=1;i<getRowCount();i++)
		{
			if(getCellData(colName,i).equalsIgnoreCase(testcaseName)){
				rownum=i;
			}
		}	
		return rownum;
}
}
