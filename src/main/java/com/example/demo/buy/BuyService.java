package com.example.demo.buy;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BuyService {

    private List<Buy> buys = new ArrayList<Buy>();

    public void addBuy(Buy buy){

        buys.add(buy);

    }


    public List<Buy> getBuy() {
       return this.buys;
    }

    public void deleteBuy(UUID id) {

        Buy buy = this.buys.stream().filter(item -> item.getId().equals(id)).findAny().orElse(null);
        if (buy != null){
            Date start = buy.getCreateAt();
            Date end = new Date();
            int hours= end.getHours() - start.getHours();
            if (hours < 12){
                System.out.println("se puede eliminar");
                this.buys.removeIf(item -> item.getId().toString().equals(id.toString()));
            }
            else {
                float price = (buy.getSubtotal() * 1.10f) - buy.getSubtotal();
                System.out.println("Tienes que cancelar el 10% de tu pedido:" + "  " + price);
            }
            System.out.println(hours);

        }else {
            System.out.println("no lo encontro");
        }

    }


    public void updateBuy(Buy buy) {

        Date start = buy.getCreateAt();
        Date end = new Date();
        int hours= end.getHours() - start.getHours();
        Buy oldBuy = (this.buys.stream().filter(item -> item.getId().equals(buy.getId())).
                findAny().orElseThrow(() -> new IllegalStateException(
                "buy with id " + buy.getId() + "does not exist"
        )));
        if (hours < 5 ){

            this.buys.removeIf(item -> item.getId().equals(oldBuy.getId()));

            this.buys.add(buy);
        }else{
            System.out.println("no es permitido editar la compra");
        }


    }

}
