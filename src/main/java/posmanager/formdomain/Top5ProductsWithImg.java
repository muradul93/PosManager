package posmanager.formdomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dream71 on 21/11/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Top5ProductsWithImg{
    private String name;
    private String img;
    private Integer qty;
}