package posmanager.utility;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by  on 4/3/17.
 */
public class Maneger {


    //Temp
    public static final Integer ScondarySaleConfig = 1;
    public static final Integer SETTING_ID = 1;
    public static final Integer LineItem = 1;
    public static final Integer Price = 1;
    public static final Integer FixedAmopunt = 1;
    public static final Integer Percentage = 2;
    public static final Integer Quantity = 3;

    public static final Integer ALL_ITEM = -1;

    //QR-CODE
    // Image Width and Height
    private static final int IMAGE_SIZE = 250;

    //Date Format
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public static final DateTimeFormatter formatterRest = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    public static final DateTimeFormatter formatterMonthSelect=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //Image Format
    public static final String IMAGE_PNG_FORMAT = "image/png";
    public static final String IMAGE_JPG_FORMAT = "image/jpeg";
    public static final String IMAGE_JPEG_FORMAT = "image/jpeg";


    public static final String DATA_SAVE_SUCCESS = "data Save Successfully";
    public static final String DATA_SAVE_FAIL = "Fail To Save Data";
    public static final String DATA_DELETE_SUCCESS = "Successfully Delete";
    public static final String DATA_VALUE_ERROR = "Object parameter value null ";
    public static final String DATA_VALUE_EMPTY = "Object parameter value empty ";
    public static final String DATA_FEACHES_SUCCESSS = "Data feaches successfully ";
    public static final String DATA_UNOTHORIZED_PUSH = "Data can't save unauthorized location  ";
    public static final String RESOURCE_NOT_FOUND = "resource not found";
    public static final String LOGIN_SUCCESS = "Login Successfully";
    public static final String LOGIN_FAILED = "Invalid Username or Password";


    public static  String STATUS_LOCATION_MISS_MATCH="Location Miss Match";

    public static final String SERVER_ERROR = "Server error";
    public static final String METHOD_NOT_ALLOWED = "Method Not Allowed";
    public static final String OK = "OK";

    public static String imageBaseName() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    public static boolean distFrom(float lat1, float lng1, float lat2, float lng2) {

        float TolarableDistance = 20.0f; // Tolareble Redius

        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        float dist = (float) (earthRadius * c);

        System.out.println("dist : "+dist);

        return TolarableDistance > dist;
    }

    public static List<String> getProductsId(String product) {
        List<String> strings = new ArrayList<>();

        System.out.println(" product call" + product);

        String[] productids = product.split(",");
        for (String pId : productids) {
            System.out.println(pId);
            if (!pId.isEmpty()) {
                strings.add(pId);
                System.out.println(" product " + pId);
            }

        }

        return strings;

    }





    /**   QR CODE Write and Read   */

    /***  QR write      */
    public static boolean QRCodeGenerate(Map<String, String> datas, String path) {
        try {
            Document document = new Document(PageSize.A4);

            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path));


            document.open();

            //PdfContentByte pdfContentByte = pdfWriter.getDirectContent();


            int index = 0;
            for (Map.Entry<String, String> data : datas.entrySet()) {


                try {

                    BarcodeQRCode barcodeQrcode = new BarcodeQRCode(data.getKey(), IMAGE_SIZE, IMAGE_SIZE, null);
                    Image qrcodeImage = barcodeQrcode.getImage();


                    PdfPTable table = new PdfPTable(2);
                    table.setWidthPercentage(100);
                    table.setWidths(new int[]{1, 1});
                    table.addCell(createImageCell(qrcodeImage));
                    table.addCell(createTextCell(data.getValue()));
                    document.add(table);


                    index++;

                    if (index % 2 == 0) {
                        document.newPage();
                        index = 0;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            document.close();

        } catch (FileNotFoundException e)

        {

            e.printStackTrace();

        } catch (DocumentException e)

        {

            e.printStackTrace();

        }


        return true;
    }


    public static boolean BarCodeGenerate(Map<String,String> products, String path) {

        try {
            Document document = new Document();

            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path));


            document.open();

            int index = 0;


            for (Map.Entry<String,String> product :products.entrySet()) {

                PdfContentByte cb = pdfWriter.getDirectContent();
                Barcode39 barcode39 = new Barcode39();
                barcode39.setCode(product.getKey());


                Image code39Image = barcode39.createImageWithBarcode(cb, null, null);
                try {
                    PdfPTable table = new PdfPTable(2);
                    table.setWidthPercentage(100);
                    table.setWidths(new int[]{1, 1});
                    table.addCell(createImageCell(code39Image));
                    table.addCell(createTextCell(product.getValue()));

                    document.add(table);

                    index++;

                    if (index % 15 == 0) {
                        document.newPage();
                        index = 0;
                    }

                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public static PdfPCell createImageCell(Image image) throws DocumentException, IOException {

        PdfPCell cell = new PdfPCell(image, false);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPaddingBottom(10);
        return cell;
    }

    public static PdfPCell createTextCell(String text) throws DocumentException, IOException {
        PdfPCell cell = new PdfPCell();
        Paragraph p = new Paragraph(text);
        p.setAlignment(Element.ALIGN_LEFT);
        cell.addElement(p);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
         cell.setPaddingBottom(10);
        return cell;
    }


    public PdfPCell createBarcode(PdfWriter writer, String code) throws DocumentException, IOException {
        BarcodeEAN barcode = new BarcodeEAN();
        barcode.setCodeType(Barcode.EAN8);
        barcode.setCode(code);
        PdfPCell cell = new PdfPCell(barcode.createImageWithBarcode(writer.getDirectContent(), BaseColor.BLACK, BaseColor.GRAY), false);
        cell.setPadding(10);
        return cell;
    }


}
