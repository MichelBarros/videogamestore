package com.videogamestore.controller;

import com.videogamestore.model.Bill;
import com.videogamestore.model.Client;
import com.videogamestore.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping
    public ResponseEntity<List<Bill>> getBill(){
        List<Bill> bills = (List<Bill>) billRepository.findAll();
        return ResponseEntity.ok(bills);
    }

    @RequestMapping(value = "{billId}")
    public ResponseEntity<Bill> getBillById(@PathVariable("billId") Bill bill){
        Optional<Bill> bills = billRepository.findById(bill.getId());
        if(bills.isPresent()){
            return ResponseEntity.ok(bills.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Bill> createClient(@RequestBody Bill bill){
        Bill newBill = billRepository.save(bill);
        return ResponseEntity.ok(newBill);
    }

    @DeleteMapping(value = "{billId}")
    public ResponseEntity<Void> deleteBill(@PathVariable("billId") Long billId){
        billRepository.deleteById(billId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Bill> updateCause(@RequestBody Bill bill){
        Optional<Bill> bills = billRepository.findById(bill.getId());
        if(bills.isPresent()){
            Bill updateBill = bills.get();
            updateBill.setClient(bill.getClient());
            updateBill.setRentDate(bill.getRentDate());
            updateBill.setReturnDate(bill.getReturnDate());
            updateBill.setTotal(bill.getTotal());
            billRepository.save(updateBill);
            return ResponseEntity.ok(updateBill);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
