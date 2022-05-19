package com.company.service;

import com.company.dto.top5.BuyingTopDto;
import com.company.dto.top5.ReportTopDto;
import com.company.dto.top5.StoreTopDto;
import com.company.model.product.Buying;
import com.company.model.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ReportServiceTop {

    private int getTopCount(StoreTopDto[] storeTopDtos) {
        int count = 0;
        for (StoreTopDto storeTopDto : storeTopDtos) {
            count += storeTopDto.getSells().length;
        }
        return count;
    }

    private StoreTopDto[] mapStores(Store[] stores) {
        StoreTopDto[] array = new StoreTopDto[stores.length];
        for (int i = 0; i < array.length; i++) {
            Store store = stores[i];
            String name = store.getName();
            BuyingTopDto[] buyingTopDtos = new BuyingTopDto[store.getSales().length];
            for (int j = 0; j < store.getSales().length; j++) {
                Buying sale = store.getSales()[j];
                double sum = sale.getProduct().getPrice() * sale.getCount();
                buyingTopDtos[j] = new BuyingTopDto(sale.getProduct().getName(), sale.getCount());
            }
            array[i]= new StoreTopDto(name, buyingTopDtos);
        }
        return array;
    }

    public ReportTopDto build2(Store[] stores) {
        StoreTopDto[] storeTopDtos = mapStores(stores);
        BuyingTopDto[] buyingTopDtos = mergeTopBuyings(storeTopDtos);
        List<Integer>arrIndexes = new ArrayList<>();
        BuyingTopDto[] newBuyingTopDtos = new BuyingTopDto[5];
        for (int i = 0; i < 5; i++) {
            BuyingTopDto tempResult = new BuyingTopDto();
            int temp = 0;
            for (int j = 0; j < buyingTopDtos.length; j++) {

                if (tempResult.getCount() < buyingTopDtos[j].getCount()) {
                    if (arrIndexes.contains(j)) {
                        continue;
                    } else {
                        tempResult = buyingTopDtos[j];
                        temp = j;
                    }
                }
            }
            newBuyingTopDtos[i] = tempResult;
            arrIndexes.add(temp);
        }
        return new ReportTopDto("Top 5 products:", newBuyingTopDtos);
    }

    private BuyingTopDto[] mergeTopBuyings(StoreTopDto[] storeTopDtos) {
        int count = getTopCount(storeTopDtos);
        BuyingTopDto[] totalArr = new BuyingTopDto[count];
        int i = 0;
        for (StoreTopDto storeTopDto : storeTopDtos) {
            for (BuyingTopDto sell : storeTopDto.getSells()) {
                totalArr[i++] = sell;
            }
        }
        return totalArr;
    }
}
