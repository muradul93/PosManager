package posmanager.reporting;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPTableEvent;
import com.lowagie.text.pdf.draw.LineSeparator;
import posmanager.domain.OrganizationSetting;
import posmanager.utility.InWordsConverter;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

/**
 * Created by root on 18/4/17.
 */
public class PdfUtill {

    private static Font companyNameFont = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
    private static Font companyAddFont = new Font(Font.HELVETICA, 9);
    private static Font leftFont = new Font(Font.TIMES_ROMAN, 9, Font.BOLD);
    private static Font rightFont = new Font(Font.TIMES_ROMAN, 9, Font.NORMAL);
    private static Font detailsHeaderFont = new Font(Font.TIMES_ROMAN, 9, Font.BOLD);
    private static Font detailsInnerFont = new Font(Font.TIMES_ROMAN, 9, Font.NORMAL);
    private static Font detailsFont = new Font(Font.TIMES_ROMAN, 9, Font.BOLDITALIC | Font.UNDERLINE);
    private static Font leftDefFont = new Font(Font.TIMES_ROMAN, 9);
    private static DecimalFormat df = new DecimalFormat("##.00");

    static Image getImage(OrganizationSetting setting, String path) throws BadElementException, IOException {
        Path pathDir1 = Paths.get(new File(path).getAbsolutePath());
        File file1 = new File(pathDir1.toAbsolutePath().toString(), setting.getImage());

        Image image = Image.getInstance(file1.getAbsolutePath());
        image.setAlignment(Image.ALIGN_CENTER);
        image.scaleAbsolute(100f, 50f);
        return image;
    }




    static Paragraph getReqDetailsParagraph(String s) {
        return new Paragraph(s, detailsFont);
    }

    static void setUnnessaryDataOnetailsTable(PdfPTable detailsTable, int size, boolean l, boolean e) {
        for (int i=0; i<40; i++) {
            PdfPCell cel = new PdfPCell(new Paragraph(""));
            cel.setBorder(Rectangle.LEFT);

            PdfPCell cer = new PdfPCell(new Paragraph(""));
            if (l) {
                cer.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
            } else {
                cer.setBorder(Rectangle.RIGHT);
            }

            PdfPCell ce = new PdfPCell(new Paragraph(""));
            ce.setMinimumHeight(10f);
            ce.setBorder(Rectangle.NO_BORDER);

            detailsTable.addCell(cel);
            for (int j=0; j<size-2; j++) {
                detailsTable.addCell(ce);
            }
            detailsTable.addCell(cer);
        }
        if (e) {
            PdfPCell c = new PdfPCell(new Paragraph(""));
            c.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);

            PdfPCell m = new PdfPCell(new Paragraph(""));
            m.setBorder(Rectangle.BOTTOM);

            PdfPCell r = new PdfPCell(new Paragraph(""));
            r.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);

            detailsTable.addCell(c);
            for (int j=0; j<size-2; j++) {
                detailsTable.addCell(m);
            }
            detailsTable.addCell(r);
        }
    }

    static Paragraph getInWordsParagraph(OrganizationSetting setting, double total) {
        Paragraph inWords = new Paragraph(InWordsConverter.getInWords(total, setting.getCurrencySymbol()), detailsHeaderFont);
        inWords.setAlignment(Element.ALIGN_LEFT);
        return inWords;
    }

    static void getLastRow(PdfPTable totalTable, double total, String totalOrder) {
        PdfPCell totalTCell = new PdfPCell(new Paragraph(totalOrder, detailsHeaderFont));
        totalTCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        totalTCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
        totalTable.addCell(totalTCell);

        PdfPCell totalFCell = new PdfPCell(new Paragraph(df.format(total), detailsHeaderFont));
        totalFCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        totalFCell.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP);
        totalTable.addCell(totalFCell);
    }

    static double getRowWithTax(OrganizationSetting setting, double sum, double tax, String sumFinal, PdfPTable totalTable) {
        PdfPCell subTotalTCell = new PdfPCell(new Paragraph("Sub-total",detailsInnerFont));
        subTotalTCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        subTotalTCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
        totalTable.addCell(subTotalTCell);

        PdfPCell subTotalTFCell = new PdfPCell(new Paragraph(sumFinal, detailsInnerFont));
        subTotalTFCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        subTotalTFCell.setBorder(Rectangle.RIGHT);
        totalTable.addCell(subTotalTFCell);


        if (!setting.getTax1Amount().isEmpty()) {
            try {
                tax = sum * Double.parseDouble(setting.getTax1Amount()) / 100;
                PdfPCell taxTCell = new PdfPCell(new Paragraph(setting.getTax1(), detailsInnerFont));
                taxTCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                taxTCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                PdfPCell taxFCell = new PdfPCell(new Paragraph(df.format(tax), detailsInnerFont));
                taxFCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                taxFCell.setBorder(Rectangle.RIGHT);

                totalTable.addCell(taxTCell);
                totalTable.addCell(taxFCell);
            } catch (NumberFormatException n) {}
        }
        return tax;
    }




    static double getRowWithVat(OrganizationSetting setting,  double vat, String vatAmount, PdfPTable totalTable) {
        PdfPCell subVatTCell = new PdfPCell(new Paragraph("Vat",detailsInnerFont));
        subVatTCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        subVatTCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
        totalTable.addCell(subVatTCell);

        PdfPCell subTotalTFCell = new PdfPCell(new Paragraph(vatAmount, detailsInnerFont));
        subTotalTFCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        subTotalTFCell.setBorder(Rectangle.RIGHT);
        totalTable.addCell(subTotalTFCell);

        return vat;
    }




    static double getRowWithPaid(OrganizationSetting setting,  double paid, String paidAmount, PdfPTable totalTable) {
        PdfPCell subPaidTCell = new PdfPCell(new Paragraph("Paid",detailsInnerFont));
        subPaidTCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        subPaidTCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
        totalTable.addCell(subPaidTCell);

        PdfPCell subTotalTFCell = new PdfPCell(new Paragraph(paidAmount, detailsInnerFont));
        subTotalTFCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        subTotalTFCell.setBorder(Rectangle.RIGHT);
        totalTable.addCell(subTotalTFCell);

        return paid;
    }



    static PdfPTable getTotalTable() throws DocumentException {
        PdfPTable totalTable = new PdfPTable(2);
        float[] totalWidth = {75, 25};
        totalTable.setWidths(totalWidth);
        totalTable.setSpacingBefore(0);
        totalTable.setWidthPercentage(100);
        return totalTable;
    }

    static PdfPCell getDetailsTableRightCell(Double dt) {
        PdfPCell total = new PdfPCell(new Paragraph(dt == null ? "" : df.format(dt), detailsInnerFont));
        total.setHorizontalAlignment(Element.ALIGN_RIGHT);
        total.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
        return total;
    }

    static PdfPCell getDetailsTableRightCell(String dt, int ha) {
        PdfPCell total = new PdfPCell(new Paragraph(dt, detailsInnerFont));
        total.setHorizontalAlignment(ha);
        total.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
        return total;
    }

    static PdfPCell getDetailsTableRightCell(String dt, int ha, int borderRight) {
        PdfPCell total = new PdfPCell(new Paragraph(dt, detailsInnerFont));
        total.setHorizontalAlignment(ha);
        total.setBorder(borderRight);
        return total;
    }

    static PdfPCell getDetailsTableMiddleCell(Double dt, int align) {
        PdfPCell price = new PdfPCell(new Paragraph(df.format(dt) ,detailsInnerFont));
        price.setHorizontalAlignment(align);
        price.setBorder(Rectangle.NO_BORDER);
        return price;
    }

    static PdfPCell getDetailsTableMiddleCell(String dt, int align) {
        PdfPCell price = new PdfPCell(new Paragraph(dt, detailsInnerFont));
        price.setHorizontalAlignment(align);
        price.setBorder(Rectangle.NO_BORDER);
        return price;
    }

    static PdfPCell getDetailsTableLeftCell(String dt, int ha) {
        PdfPCell product = new PdfPCell(new Paragraph(dt ,detailsInnerFont));
        product.setHorizontalAlignment(ha);
        product.setBorder(Rectangle.LEFT);
        return product;
    }

    static PdfPCell getLastBorderCell(boolean left, boolean middle, boolean right) {
        PdfPCell pdfPCell = new PdfPCell();
        if (left) {
            pdfPCell.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
            return pdfPCell;
        }
        if (right) {
            pdfPCell.setBorder(Rectangle.RIGHT | Rectangle.LEFT | Rectangle.BOTTOM);
            return pdfPCell;
        }
        pdfPCell.setBorder(Rectangle.BOTTOM);
        return pdfPCell;
    }

    static PdfPCell getDetailsTableRightHeaderCell(String n, int ha, boolean lb) {
        PdfPCell totalCell = new PdfPCell(new Paragraph(n ,detailsHeaderFont));
        totalCell.setBackgroundColor(new Color(221, 221, 221));
        totalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        totalCell.setHorizontalAlignment(ha);
        totalCell.setUseAscender(true);
        if (lb)
            totalCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
        else
            totalCell.setBorder(Rectangle.RIGHT | Rectangle.TOP);
        return totalCell;
    }



    static PdfPCell getSalesTableRightHeaderCell(String n, int ha, boolean lb) {
        PdfPCell totalCell = new PdfPCell(new Paragraph(n ,detailsHeaderFont));
        //totalCell.setBackgroundColor(new Color(221, 221, 221));
        totalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        totalCell.setHorizontalAlignment(ha);
        totalCell.setUseAscender(true);
        if (lb)
            totalCell.setBorder( Rectangle.NO_BORDER);
            //totalCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
        else
            totalCell.setBorder(Rectangle.NO_BORDER);
        return totalCell;
    }

    static PdfPCell getDetailsTableMiddleHeaderCell(String s, int hAlign) {
        PdfPCell priceCell = new PdfPCell(new Paragraph(s ,detailsHeaderFont));
        priceCell.setBackgroundColor(new Color(221, 221, 221));
        priceCell.setHorizontalAlignment(hAlign);
        priceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        priceCell.setUseAscender(true);
        priceCell.setBorder(Rectangle.TOP);
        return priceCell;
    }

    static PdfPCell getDetailsTableLeftHeaderCell(String product, int ha) {
        PdfPCell productCell = new PdfPCell(new Paragraph(product ,detailsHeaderFont));
        productCell.setBackgroundColor(new Color(221, 221, 221));
        productCell.setHorizontalAlignment(ha);
        productCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        productCell.setUseAscender(true);
        productCell.setBorder(Rectangle.LEFT | Rectangle.TOP);
        return productCell;
    }

    static PdfPTable getDetailsTable(int i) {
        PdfPTable detailsTable = new PdfPTable(i);
        detailsTable.setSpacingBefore(10);
        detailsTable.setWidthPercentage(100);
        return detailsTable;
    }

    static PdfPCell getInfoTableCell(String reqMaster) {
        PdfPCell customerCell = new PdfPCell(new Paragraph(reqMaster, rightFont));
        customerCell.setBorder(Rectangle.NO_BORDER);
        customerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return customerCell;
    }

    static PdfPCell getInfoTableCellRightAlign(String reqMaster) {
        PdfPCell customerCell = new PdfPCell(new Paragraph(reqMaster, rightFont));
        customerCell.setBorder(Rectangle.NO_BORDER);
        customerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        return customerCell;
    }

    static PdfPCell getInfoTableHeader(String s) {
        PdfPCell customerHCell = new PdfPCell(new Paragraph(s, leftFont));
        customerHCell.setBorder(Rectangle.NO_BORDER);
        customerHCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        customerHCell.setBackgroundColor(new Color(0, 196, 132));
        customerHCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        customerHCell.setUseAscender(true);
        return customerHCell;
    }

    static PdfPCell getInfoTableFooter(String s, int alignCenter) {
        PdfPCell customerHCell = new PdfPCell(new Paragraph(s, leftFont));
        customerHCell.setBorder(Rectangle.NO_BORDER);
        customerHCell.setHorizontalAlignment(alignCenter);
//        customerHCell.setBackgroundColor(new Color(0, 196, 132));
        customerHCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        customerHCell.setUseAscender(true);
        return customerHCell;
    }

    static PdfPTable getInfoTable(int i) {
        PdfPTable infoTable = new PdfPTable(i);
        infoTable.setSpacingBefore(5);
        infoTable.setTableEvent(new MyTableEvent());
        infoTable.setWidthPercentage(100);
        return infoTable;
    }

    static PdfPCell getCusTableCell(String reportMetaData) {
        PdfPCell nameCell = new PdfPCell(new Paragraph(reportMetaData, leftDefFont));
        nameCell.setBorder(Rectangle.NO_BORDER);
        return nameCell;
    }

    static PdfPCell getCusTableHeaderCell(String val) {
        PdfPCell detailsCell = new PdfPCell(new Paragraph(val, detailsFont));
        detailsCell.setBorder(Rectangle.NO_BORDER);
        return detailsCell;
    }

    static PdfPTable getCusTable() {
        PdfPTable cusTable = new PdfPTable(1);
        cusTable.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cusTable;
    }

    static PdfPTable getSalesTable() {
        PdfPTable cusTable = new PdfPTable(1);
        cusTable.setHorizontalAlignment(Element.ALIGN_RIGHT);
        return cusTable;
    }


    static LineSeparator getLineSeparator() {
        LineSeparator lineSeparator = new LineSeparator();
        lineSeparator.setPercentage(95);
        lineSeparator.setLineWidth(1);
        lineSeparator.setLineColor(new Color(221, 221, 221));
        return lineSeparator;
    }

    static Paragraph getParagraph(String setting) {
        Paragraph companyAddPara = new ListItem(setting, companyAddFont);
        companyAddPara.setAlignment(Element.ALIGN_CENTER);
        return companyAddPara;
    }

    static Paragraph getCompanyNamePara(String name) {
        Paragraph companyNamePara = new ListItem(name, companyNameFont);
        companyNamePara.setAlignment(Element.ALIGN_CENTER);
        return companyNamePara;
    }

    public static class MyTableEvent implements PdfPTableEvent {
        public void tableLayout(PdfPTable table, float[][] width, float[] height,
                                int headerRows, int rowStart, PdfContentByte[] canvas) {
            float widths[] = width[0];
            float x1 = widths[0];
            float x2 = widths[widths.length - 1];
            float y1 = height[0];
            float y2 = height[height.length - 1];
            PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
            cb.rectangle(x1, y1, x2 - x1, y2 - y1);
            cb.stroke();
            cb.resetRGBColorStroke();
        }
    }
}
