package com.company.dto.top5;

import com.company.dto.top5.BuyingTopDto;

public class StoreTopDto {

    private String name;
    private BuyingTopDto[] sells;

    public StoreTopDto(String name, BuyingTopDto[] sells) {
        this.name = name;
        this.sells = sells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuyingTopDto[] getSells() {
        return sells;
    }

    public void setSells(BuyingTopDto[] sells) {
        this.sells = sells;
    }
}
