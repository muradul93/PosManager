package posmanager.reporting;


import posmanager.domain.OrganizationSetting;
import posmanager.formdomain.Top10Product;
import posmanager.utility.InWordsConverter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static posmanager.reporting.ExcelUtill.*;


public class ExcelView extends AbstractExcelView {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
	private DecimalFormat df = new DecimalFormat("##.00");

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> map = (Map<String, Object>) model.get("model");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			switch (entry.getKey()) {
				case "top10productList":
					top10productList(map, workbook);
					break;
				case "top10SalesList":
					top10SalesList(map,workbook);
					break;
				default:
					break;
			}
		}



	}

	private void top10SalesList(Map<String, Object> model, HSSFWorkbook workbook) {
		List<Top10Product> top10Products = (List<Top10Product>) model.get("top10SalesList");
		OrganizationSetting setting = (OrganizationSetting) model.get("setting");
		String path = model.get("path").toString();

		HSSFSheet sheet = workbook.createSheet("Top 10 Customer");
		sheet.setDefaultColumnWidth(20);

		CellStyle infoTableStyle = getInfoTableStyle(workbook);
		CellStyle detailsTableStyle = getDetailsTableStyle(workbook);
		CellStyle detailsHeader = getdetailsHeaderStyle(workbook);
		CellStyle headerStyle = getHeaderStyle(workbook);


		int rowCount = 1;
		sheet.createRow(rowCount++).createCell(0).setCellValue(setting.getCompanyName());
		sheet.createRow(rowCount++).createCell(0).setCellValue(setting.getCompanyAddress());
		sheet.createRow(rowCount++).createCell(0).setCellValue(setting.getCompanyPhone());
		sheet.createRow(rowCount++).createCell(0).setCellValue("Generated at "+ LocalDateTime.now().format(formatter2));

		rowCount = getHeaderTitle(sheet, headerStyle, rowCount,"Top 10 Customer List");

		rowCount++;

		HSSFRow header = sheet.createRow(rowCount);
		header.setHeight((short) 400);
		getCustomCell(infoTableStyle, header,0, "Customer Name");
		getCustomCell(infoTableStyle, header,1, "Amount (" + setting.getCurrencySymbol() + ")");

		rowCount++;

		for (Top10Product product : top10Products) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(product.getName());
			aRow.createCell(1).setCellValue(product.getAmount() == 0.0 ? "00.00" : df.format(product.getAmount()));
		}
		double sum = top10Products.stream().mapToDouble(v -> v.getAmount()).sum();

		HSSFRow row = sheet.createRow(rowCount++);
		getCustomCell(detailsHeader, row,0, "Total");
		getCustomCell(detailsHeader, row,1, df.format(sum));
		rowCount++;
		getCustomCell(detailsHeader, sheet.createRow(rowCount++),0, InWordsConverter.getInWords(sum, setting.getCurrencySymbol()));

	}

	private void top10productList(Map<String, Object> model, HSSFWorkbook workbook) {
		List<Top10Product> top10Products = (List<Top10Product>) model.get("top10productList");
		OrganizationSetting setting = (OrganizationSetting) model.get("setting");
		String path = model.get("path").toString();

		HSSFSheet sheet = workbook.createSheet("Top 10 Products");
		sheet.setDefaultColumnWidth(20);

		CellStyle infoTableStyle = getInfoTableStyle(workbook);
		CellStyle detailsTableStyle = getDetailsTableStyle(workbook);
		CellStyle detailsHeader = getdetailsHeaderStyle(workbook);
		CellStyle headerStyle = getHeaderStyle(workbook);


		int rowCount = 1;
		sheet.createRow(rowCount++).createCell(0).setCellValue(setting.getCompanyName());
		sheet.createRow(rowCount++).createCell(0).setCellValue(setting.getCompanyAddress());
		sheet.createRow(rowCount++).createCell(0).setCellValue(setting.getCompanyPhone());
		sheet.createRow(rowCount++).createCell(0).setCellValue("Generated at "+ LocalDateTime.now().format(formatter2));

		rowCount = getHeaderTitle(sheet, headerStyle, rowCount,"Top 10 Product List");

		rowCount++;

		HSSFRow header = sheet.createRow(rowCount);
		header.setHeight((short) 400);
		getCustomCell(infoTableStyle, header,0, "Product Name");
		getCustomCell(infoTableStyle, header,1, "Quantity");

		for (Top10Product product : top10Products) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(product.getName());
			aRow.createCell(1).setCellValue(product.getVolume().toString());
		}
	}



}
