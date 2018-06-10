package posmanager.utility;

/**
 * Created by dream71 on 28/9/17.
 */
public enum TransactionStatus {
    FACTORY_TO_WAREHOUSE,
    WAREHOUSE_TO_WAREHOUSE,
    WAREHOUSE_TO_VAN,
    VAN_TO_VAN,
    VAN_TO_WAREHOUSE,
    VAN_TO_CUSTOMER,
    CUSTOMER_TO_VAN,
    CUSTOMER_TO_VAN_DAMAGE

}
