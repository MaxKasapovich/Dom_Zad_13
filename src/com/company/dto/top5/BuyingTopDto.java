package com.company.dto.top5;

public class BuyingTopDto {

    private String name;
    private int count;

    public BuyingTopDto(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public BuyingTopDto() {
        // EMPTY
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
