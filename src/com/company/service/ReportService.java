package com.company.service;

import com.company.dto.*;
import com.company.dto.top5.BuyingTopDto;
import com.company.dto.top5.ReportTopDto;
import com.company.dto.top5.StoreTopDto;
import com.company.model.product.Buying;
import com.company.model.store.Store;

public class ReportService {

    public ReportDto build(Store[] stores) {
        StoreDto[] storeDtos = mapStores(stores);
        BuyingDto[] buyingDtos = mergeBuyings(storeDtos);

        double totalSum = 0;
        for (BuyingDto buyingDto : buyingDtos) {
            totalSum+= buyingDto.getSum();
        }
        return new ReportDto("Total money", buyingDtos, totalSum);
    }

    private BuyingDto[] mergeBuyings(StoreDto[] storeDtos) {
        int count = getCount(storeDtos);
        BuyingDto[] totalArr = new BuyingDto[count];
        int i = 0;
        for (StoreDto storeDto : storeDtos) {
            for (BuyingDto sell : storeDto.getSells()) {
                totalArr[i++] = sell;
            }
        }
        return totalArr;
    }

    private int getCount(StoreDto[] storeDtos) {
        int count = 0;
        for (StoreDto storeDto : storeDtos) {
            count += storeDto.getSells().length;
        }
        return count;
    }

    private StoreDto[] mapStores(Store[] stores) {
        StoreDto[] array = new StoreDto[stores.length];
        for (int i = 0; i < array.length; i++) {
            Store store = stores[i];
            String name = store.getName();
            BuyingDto[] buyingDtos = new BuyingDto[store.getSales().length];
            for (int j = 0; j < store.getSales().length; j++) {
                Buying sale = store.getSales()[j];
                double sum = sale.getProduct().getPrice() * sale.getCount();
                buyingDtos[j] = new BuyingDto(sale.getProduct().getName(), sale.getCount(), sum);
            }
            array[i]= new StoreDto(name, buyingDtos);
        }
        return array;
    }


}
