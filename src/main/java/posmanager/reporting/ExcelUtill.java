package posmanager.reporting;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

/**
 * Created by root on 8/5/17.
 */
public class ExcelUtill {

    public static void getCustomCell(CellStyle infoTableStyle, HSSFRow header, int ind, String val) {
        header.createCell(ind).setCellValue(val);
        header.getCell(ind).setCellStyle(infoTableStyle);
    }

    public static int getHeaderTitle(HSSFSheet sheet, CellStyle headerStyle, int rowCount, String value) {
        HSSFRow headerTile = sheet.createRow(rowCount++);
        headerTile.setHeight((short) 400);
        headerTile.createCell(0).setCellValue(value);
        headerTile.getCell(0).setCellStyle(headerStyle);
        return rowCount;
    }

    static public CellStyle getHeaderStyle(HSSFWorkbook workbook) {
        CellStyle headerStyle = workbook.createCellStyle();
        Font font2 = workbook.createFont();
        font2.setFontName("Arial");
        font2.setFontHeight((short) 300);
        headerStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font2.setColor(HSSFColor.DARK_GREEN.index);
        headerStyle.setFont(font2);
        return headerStyle;
    }

    static public CellStyle getdetailsHeaderStyle(HSSFWorkbook workbook) {
        CellStyle detailsHeader = workbook.createCellStyle();
        Font font1 = workbook.createFont();
        font1.setFontName("Arial");
        font1.setItalic(true);
        font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        detailsHeader.setFont(font1);
        return detailsHeader;
    }

    static public CellStyle getDetailsTableStyle(HSSFWorkbook workbook) {
        CellStyle detailsTableStyle = workbook.createCellStyle();
        Font fontDetails = workbook.createFont();
        fontDetails.setFontName("Arial");
        detailsTableStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        detailsTableStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        fontDetails.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontDetails.setColor(HSSFColor.WHITE.index);
        detailsTableStyle.setFont(fontDetails);
        return detailsTableStyle;
    }

    static public CellStyle getInfoTableStyle(HSSFWorkbook workbook) {
        CellStyle infoTableStyle = workbook.createCellStyle();
        Font fontInfo = workbook.createFont();
        fontInfo.setFontName("Arial");
        infoTableStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        infoTableStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        fontInfo.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        fontInfo.setColor(HSSFColor.WHITE.index);
        infoTableStyle.setFont(fontInfo);
        return infoTableStyle;
    }
}
