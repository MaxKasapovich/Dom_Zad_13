package com.company.dto.top5;

import com.company.dto.top5.BuyingTopDto;

public class ReportTopDto {

    String name;
    private BuyingTopDto[] data;

    public ReportTopDto(String name, BuyingTopDto[] data) {
        this.name = name;
        this.data = data;
    }

    public ReportTopDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuyingTopDto[] getData() {
        return data;
    }

    public void setData(BuyingTopDto[] data) {
        this.data = data;
    }
}


