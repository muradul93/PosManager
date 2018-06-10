package posmanager.formdomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Marketing on 17-Jul-17.
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SplineAreaChart {
    private double totalOderAmount;
    private double totalSalesAmount;
    private Integer month;
    private Integer year;
    private Integer numberOfOder;
    private Integer numberOfSales;
    private double secondaryTotalOderAmount;
    private double secondaryTotalSalesAmount;
    private Integer secondaryNumberOfOder;
    private Integer secondaryNumberOfSales;



   // private String ps;
}