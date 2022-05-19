package com.company.controller;

import com.company.dto.ReportDto;
import com.company.dto.top5.ReportTopDto;
import com.company.model.store.Store;
import com.company.service.ReportService;
import com.company.view.ReportView;
import com.company.service.ReportServiceTop;

public class ReportController { // API

    public void execute(Store[] stores) {
        ReportService reportService = new ReportService();
        ReportDto report = reportService.build(stores);
        ReportView view = new ReportView();
        view.printDetails(report);
    }

    public void executeTop5(Store[] stores) {
        ReportServiceTop reportServiceTop = new ReportServiceTop();
        ReportTopDto report = reportServiceTop.build2(stores);
        ReportView view2 = new ReportView();
        view2.printDetails(report);
    }
}
