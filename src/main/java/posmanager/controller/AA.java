package posmanager.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

/**
 * Created by dream71 on 16/11/17.
 */
public class AA {
    public static void main(String[] args) {

        /*WEEKS */

        LocalDate now = LocalDate.now();
        TemporalField fieldISO = WeekFields.SUNDAY_START.dayOfWeek();

        LocalDate m = now.with(fieldISO, 1);
        LocalDate l = m.minus(1, ChronoUnit.WEEKS);
        LocalDate f = m.plus(1, ChronoUnit.WEEKS);


        System.out.println(l+ " to " + m);
        System.out.println(m + " to " + f);

        /**********************************************************/
        /*MONTH*/
        /*LocalDate initial = LocalDate.now();
        LocalDate start = initial.with(firstDayOfMonth());
        LocalDate end = initial.with(lastDayOfMonth());

        System.out.println(start.minusDays(1) + " to " + end.plusDays(1));

        LocalDate initial1 = LocalDate.now();
        LocalDate localDate = initial1.minusMonths(1);
        LocalDate start1 = localDate.with(firstDayOfMonth());
        LocalDate end1 = localDate.with(lastDayOfMonth());

        System.out.println(start1.minusDays(1) + " to " + end1.plusDays(1));*/

        /**********************************************************/
        /*YEAR*/

       /* LocalDate initial = LocalDate.now();
        LocalDate start = initial.with(firstDayOfYear());
        LocalDate end = initial.with(lastDayOfYear());

        System.out.println(start.minusDays(1) + " to " + end.plusDays(1));

        LocalDate initial1 = LocalDate.now();
        LocalDate localDate = initial1.minusYears(1);
        LocalDate start1 = localDate.with(firstDayOfYear());
        LocalDate end1 = localDate.with(lastDayOfYear());

        System.out.println(start1.minusDays(1) + " to " + end1.plusDays(1));*/

        /**********************************************************/
        /*QUATER*/

       /* List<Server> servers1 = Arrays.asList(
                new Server("name1", "attr1.1", null),
                new Server("name2", "attr1.2", null));

        List<Server> servers2 = Arrays.asList(
                new Server("name1", null, "attr2.1"),
                new Server("name2", null, "attr2.2"));

        Map<String, Server> serverMap1 = servers1.stream().collect(Collectors.toMap(Server::getName, Function.identity()));
        Map<String, Server> serverMap2 = servers2.stream().collect(Collectors.toMap(Server::getName, Function.identity()));

        serverMap1.keySet().forEach(key -> serverMap1.merge(key,
                serverMap2.get(key),
                (server1, server2) -> {
                    server1.setAttribute2(server2.getAttribute2());
                    return server1;
                }));


        serverMap1.forEach((k, v) -> System.out.println(k + " : " + v));*/

        /*LocalDate initial = LocalDate.now();
        LocalDate start = initial.with(firstDayOfYear());
        LocalDate end = initial.with(lastDayOfYear());

        System.out.println(start.minusDays(1) + " to " + end.plusDays(1));

        LocalDate initial1 = LocalDate.now();
        LocalDate localDate = initial1.minusYears(1);
        LocalDate start1 = localDate.with(firstDayOfYear());
        LocalDate end1 = localDate.with(lastDayOfYear());

        System.out.println(start1.minusDays(1) + " to " + end1.plusDays(1));*/
    }


}
