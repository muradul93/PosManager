package posmanager.formdomain;

import java.util.List;

/**
 * Created by  on 5/11/17.
 */
public class DamageReturnValueObject {
    private Integer damageAuditId;
    private Double  totalBalance;

    List<DamageReturnProductObject> damageAuditProducts;

    public Integer getDamageAuditId() {
        return damageAuditId;
    }

    public void setDamageAuditId(Integer damageAuditId) {
        this.damageAuditId = damageAuditId;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public List<DamageReturnProductObject> getDamageAuditProducts() {
        return damageAuditProducts;
    }

    public void setDamageAuditProducts(List<DamageReturnProductObject> damageAuditProducts) {
        this.damageAuditProducts = damageAuditProducts;
    }

    @Override
    public String toString() {
        return "DamageReturnValueObject{" +
                "damageAuditId=" + damageAuditId +
                ", totalBalance=" + totalBalance +
                ", damageAuditProducts=" + damageAuditProducts +
                '}';
    }
}
