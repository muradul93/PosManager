package posmanager.controller;

import posmanager.formdomain.DashboardBarChart;
import posmanager.formdomain.SalesAndDeatils;
import posmanager.formdomain.Top5ProductsWithImg;
import posmanager.formvalidator.DashboardPriceWithDate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

/**
 * Created by root on 16/5/17.
 */
@Controller
public class HomeController {


  private List<DashboardPriceWithDate> dashboardPriceWithDates;
//
//    @Autowired
//    TransactionService transactionService;
//
//    @Autowired
//    SalesDeatilsRepository salesDeatilsRepository;
//
//    @Autowired
//    SalesService salesService;
//
//    @Autowired
//    ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home/home";
    }

    @RequestMapping(value = "/getBarChartData", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  List<DashboardBarChart> barChartData(){
        List<DashboardBarChart> list = new ArrayList<>();


//        List<Product> products = productService.findByProductActive();
//
//        for (Product product : products) {
//            double sum = salesDeatilsRepository.findAllByProduct(product).stream().mapToDouble(SalesDeatils::getTotalPrice).sum();
//            list.add(new DashboardBarChart(sum, product.getProductName(), "p"));



        return list;
    }

    @RequestMapping(value = "/getPriceList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  List<DashboardPriceWithDate> getPriceList() {
        dashboardPriceWithDates = new ArrayList<>();

//        List<SalesAndDeatils> collect = getRawData().stream().collect(groupingBy(foo -> foo.getDate(), collectingAndThen(reducing(
//                (a, b) -> new SalesAndDeatils(a.getDate(), a.getTotalPrice() + b.getTotalPrice())),
//                Optional::get))).entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
//
//        dashboardPriceWithDates.add(new DashboardPriceWithDate("s", collect));
        return dashboardPriceWithDates;
    }

    @RequestMapping(value = "/getTopProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  List<Top5ProductsWithImg> getTopProduct() {

        List<Top5ProductsWithImg> list = new ArrayList<>();

//        List<Sales> all = salesService.findAll();
//        for (Sales byTransaction : all) {
//            for (SalesDeatils dt : byTransaction.getSalesDeatils()) {
//                list.add(new Top5ProductsWithImg(dt.getProduct().getProductName(), dt.getProduct().getImageId(), dt.getQuantity()));
//            }
//        }

        list = list.stream().collect(groupingBy(foo -> foo.getName(), collectingAndThen(reducing(
                (a, b) -> new Top5ProductsWithImg(a.getName(), a.getImg(), a.getQty() + b.getQty())),
                Optional::get))).entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());

        list = list.stream().sorted(Comparator.comparing(Top5ProductsWithImg::getQty).reversed()).collect(Collectors.toList());
        list = list.stream().limit(5).collect(Collectors.toList());

        return list;
    }

    private List<SalesAndDeatils> getRawData() {
        List<SalesAndDeatils> sales = new ArrayList<>();

//        List<Sales> all = salesService.findAll();
//        for (Sales byTransaction : all) {
//            for (SalesDeatils dt : byTransaction.getSalesDeatils()) {
//                sales.add(new SalesAndDeatils(dt.getProduct().getProductName(),
//                        dt.getQuantity(),
//                        dt.getTotalPrice(),
//                        byTransaction.getDate()));
//            }
//        }

        return sales;
    }



}


