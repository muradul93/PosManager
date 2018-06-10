package posmanager.formdomain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by  on 5/3/17.
 */
public class DamageAuditObject implements Serializable {

    private Integer damageRequestId;

    private String description;

    private List<DamageAuditProduct> damageAuditProducts;

    public Integer getDamageRequestId() {
        return damageRequestId;
    }

    public void setDamageRequestId(Integer damageRequestId) {
        this.damageRequestId = damageRequestId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DamageAuditProduct> getDamageAuditProducts() {
        return damageAuditProducts;
    }

    public void setDamageAuditProducts(List<DamageAuditProduct> damageAuditProducts) {
        this.damageAuditProducts = damageAuditProducts;
    }

    @Override
    public String toString() {
        return "DamageAuditObject{" +
                "damageRequestId=" + damageRequestId +
                ", description='" + description + '\'' +
                ", damageAuditProducts=" + damageAuditProducts +
                '}';
    }
}
