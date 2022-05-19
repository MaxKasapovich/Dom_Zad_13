package com.company.view;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;
import com.company.dto.top5.BuyingTopDto;
import com.company.dto.top5.ReportTopDto;

public class ReportView {

    public static final String DESCRIPTION = "REPORT DATA: ";

    public void printDetails(ReportDto report) {
        int dash = 60;
        int firstColumn = 30;
        int secColumn = 15;

        System.out.println("=".repeat(dash));
        System.out.println(DESCRIPTION + report.getName());
        System.out.println("=".repeat(dash));

        System.out.println("Name" + (" ".repeat(firstColumn - "Name".length())) + "Count" + (" ".repeat(secColumn - "Count".length())) + "Sum");
        System.out.println("=".repeat(dash));
        for (BuyingDto buyingDto : report.getData()) {
            String cost = Math.round(buyingDto.getSum()) + " uah";
            System.out.println(buyingDto.getName() + (" ".repeat(firstColumn - buyingDto.getName().length())) +
                    buyingDto.getCount() + (" ".repeat(secColumn - String.valueOf(buyingDto.getCount()).length())) + cost);
            System.out.println("-".repeat(dash));
        }
        System.out.println("=".repeat(dash));
        System.out.println("Total sum: " + report.getTotalSum() + " uah");
    }

    public void printDetails(ReportTopDto report) {
        int dash = 40;
        int firstColumn = 30;

        System.out.println("=".repeat(dash));
        System.out.println(DESCRIPTION + report.getName());
        System.out.println("=".repeat(dash));

        System.out.println("Name" + (" ".repeat(firstColumn - "Name".length())) + "Count");
        System.out.println("=".repeat(dash));
        for (BuyingTopDto buyingTopDto : report.getData()) {
            System.out.println(buyingTopDto.getName() + (" ".repeat(firstColumn - buyingTopDto.getName().length())) + buyingTopDto.getCount());
            System.out.println("-".repeat(dash));
        }

        System.out.println("=".repeat(dash));
    }
}
