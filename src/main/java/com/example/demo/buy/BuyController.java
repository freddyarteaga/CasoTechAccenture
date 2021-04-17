package com.example.demo.buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/buy")
public class BuyController {


    private final BuyService service;

    @Autowired
    public BuyController(com.example.demo.buy.BuyService service) {
        this.service = service;
    }


    @GetMapping("/getBuy")
    public List<Buy> getBuy(){
        return service.getBuy();
    }

    @PutMapping("/updateBuy")
    public void updateBuy(@RequestBody Buy buy){
        service.updateBuy(buy);
    }

    @PostMapping("/addBuy")
    public Buy addBuy(@RequestBody Buy buy) {
        System.out.println(buy.toString());
        service.addBuy(buy);
        return buy;
    }

    @DeleteMapping("/{id}")
    public void deleteBuy(@PathVariable("id") UUID id) {
        service.deleteBuy(id);

    }

}
