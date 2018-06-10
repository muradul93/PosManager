package posmanager.reporting;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;

import posmanager.domain.*;
import posmanager.formdomain.BreakDown;
import posmanager.formdomain.Top10Product;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static posmanager.reporting.PdfUtill.*;


public class PdfView extends AbstractPdfView {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
    private DecimalFormat df = new DecimalFormat("##.00");


    @Override
    protected Document newDocument() {
        Document document = new Document();
        document.setMargins(30, 30, 5, 10);
        return document;
    }

	/*@Override
    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
		Font font = new Font(Font.COURIER, 10, Font.BOLD);
		font.setColor(Color.LIGHT_GRAY);
		HeaderFooter header = new HeaderFooter(new Phrase("REQUISITION", font), false);
		header.setAlignment(Element.ALIGN_RIGHT);
//		header.setBorder(Rectangle.NO_BORDER);
		document.setHeader(header);
		super.buildPdfMetadata(model, document, request);
	}*/

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        Map<String, Object> map = (Map<String, Object>) model.get("model");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            switch (entry.getKey()) {

                case "top10productList":
                    top10productList(map, document, writer);
                    break;
                case "breakDownsSalesList":
                    breakDownsSalesList(map, document, writer);
                    break;
                default:
                    break;
            }
        }
    }


    private void top10productList(Map<String, Object> model, Document document, PdfWriter writer) throws IOException, DocumentException {
        List<Top10Product> top10Products = (List<Top10Product>) model.get("top10productList");
        OrganizationSetting setting = (OrganizationSetting) model.get("setting");
        String path = model.get("path").toString();


        /******************* HEADER INFO *******************/
        Image image = getImage(setting, path);
        Paragraph companyNamePara = getCompanyNamePara(setting.getCompanyName());
        Paragraph companyAddPara = getParagraph(setting.getCompanyAddress());
        Paragraph companyPhonePara = getParagraph(setting.getCompanyPhone());
        Paragraph companyEmailPara = getParagraph(setting.getEmail());
        Paragraph reportOnTime = getParagraph("Report Generated at " + LocalDateTime.now().format(formatter1));
        reportOnTime.setSpacingAfter(10);
        LineSeparator lineSeparator = getLineSeparator();

        Paragraph reqDetail = getReqDetailsParagraph("Top 10 Product List");

        /******************* INFO TABLE *******************/
        PdfPTable infoTable = getInfoTable(2);
        PdfPCell dateHCell = getInfoTableHeader("Product Name");
        dateHCell.setMinimumHeight(15f);
        PdfPCell cusHCell = getInfoTableHeader("Quantity");

        infoTable.addCell(dateHCell);
        infoTable.addCell(cusHCell);

        top10Products.forEach(ma -> {
            PdfPCell reqNuCell = getInfoTableCell(ma.getName());
            reqNuCell.setMinimumHeight(15f);
            PdfPCell reqDateCell = getInfoTableCell(ma.getVolume().toString());
            infoTable.addCell(reqNuCell);
            infoTable.addCell(reqDateCell);
        });

        document.add(image);
        document.add(companyNamePara);
        document.add(companyPhonePara);
        document.add(companyEmailPara);
        document.add(companyAddPara);
        document.add(reportOnTime);
        document.add(lineSeparator);
        document.add(reqDetail);
        document.add(infoTable);
    }

    private void breakDownsSalesList(Map<String, Object> model, Document document, PdfWriter writer) throws IOException, DocumentException {
        List<BreakDown> breakDownsSalesList = (List<BreakDown>) model.get("breakDownsSalesList");
        OrganizationSetting setting = (OrganizationSetting) model.get("setting");
        String ser = (String) model.get("ser");
        String path = model.get("path").toString();


        /******************* HEADER INFO *******************/
        Image image = getImage(setting, path);
        Paragraph companyNamePara = getCompanyNamePara(setting.getCompanyName());
        Paragraph companyAddPara = getParagraph(setting.getCompanyAddress());
        Paragraph companyPhonePara = getParagraph(setting.getCompanyPhone());
        Paragraph companyEmailPara = getParagraph(setting.getEmail());
        Paragraph reportOnTime = getParagraph("Report Generated at " + LocalDateTime.now().format(formatter1));
        reportOnTime.setSpacingAfter(10);
        LineSeparator lineSeparator = getLineSeparator();

        Paragraph reqDetail = getReqDetailsParagraph("Payment List " + ser);

        /******************* INFO TABLE *******************/
        PdfPTable infoTable = getInfoTable(4);
        PdfPCell dateHCell = getInfoTableHeader("SR Name");
        dateHCell.setMinimumHeight(15f);
        PdfPCell cusHCell = getInfoTableHeader("Total");
        PdfPCell dueHCell = getInfoTableHeader("Due");
        PdfPCell padHCell = getInfoTableHeader("Paid");

        infoTable.addCell(dateHCell);
        infoTable.addCell(cusHCell);
        infoTable.addCell(dueHCell);
        infoTable.addCell(padHCell);

        breakDownsSalesList.forEach(ma -> {
            PdfPCell reqNuCell = getInfoTableCell(ma.getHrEmployeeInfo().getEmail());
            reqNuCell.setMinimumHeight(15f);
            PdfPCell totDateCell = getInfoTableCell(ma.getTotal().toString());
            PdfPCell dueDateCell = getInfoTableCell(ma.getDue().toString());
            PdfPCell padDateCell = getInfoTableCell((String.valueOf(ma.getTotal() - ma.getDue())));
            infoTable.addCell(reqNuCell);
            infoTable.addCell(totDateCell);
            infoTable.addCell(dueDateCell);
            infoTable.addCell(padDateCell);
        });

        document.add(image);
        document.add(companyNamePara);
        document.add(companyPhonePara);
        document.add(companyEmailPara);
        document.add(companyAddPara);
        document.add(reportOnTime);
        document.add(lineSeparator);
        document.add(reqDetail);
        document.add(infoTable);
    }


}
