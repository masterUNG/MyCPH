package appewtc.masterung.mycph;

/**
 * Created by masterUNG on 4/28/2017 AD.
 */

public class MyConstant {

    private String urlGetProductWhereQR = "http://swiftcodingthai.com/cph/getProductWhereQRmaster.php";

    private String[] columnProduct = new String[]{"id", "Name", "QR_code",
            "id_Receive", "Description", "Date_Receive"};

    private String urlGetUserWhereID = "http://swiftcodingthai.com/cph/getUserWhereID.php";

    public String getUrlGetUserWhereID() {
        return urlGetUserWhereID;
    }

    public String[] getColumnProduct() {
        return columnProduct;
    }

    public String getUrlGetProductWhereQR() {
        return urlGetProductWhereQR;
    }
}   // Main Class
