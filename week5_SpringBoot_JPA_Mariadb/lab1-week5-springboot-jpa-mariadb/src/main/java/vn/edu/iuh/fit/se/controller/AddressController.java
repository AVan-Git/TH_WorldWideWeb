package vn.edu.iuh.fit.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.service.impl.AddressServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping()
    public List<Address> getAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Address> op = addressService.findById(id);
        if (op.isPresent())
            return ResponseEntity.ok(op.get());
//            return op.get().toString();
//        return "Khong tim thay !!";
        return new ResponseEntity<>("Not Found Address: " + id, HttpStatus.NOT_FOUND);
//        return ResponseEntity.notFound().build();
//       return ResponseEntity.ok("Khong tim thay !!");
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody Address address) {

        addressService.insert(address);

        return new ResponseEntity<>("Finish Address " + address, HttpStatus.CREATED);
    }

    //    @PutMapping("")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
        Optional<Address> optional = addressService.findById(id);

        addressService.insert(address);

        if (optional.isPresent()) {
            return new ResponseEntity<>("Finish update Address ", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Finish add Address ", HttpStatus.CREATED);
        }
    }

    // delete
    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteAddRess(@PathVariable("id") long id) {
        Optional<Address> optional = addressService.findById(id);
        if (optional.isPresent())
        {
            addressService.delete(id);
            return new ResponseEntity<>("Finish Del Address ", HttpStatus.OK);
        }
        //NO_CONTENT: khongo co noi dung
        return new ResponseEntity<>("Không tìm thấy", HttpStatus.NO_CONTENT);
    }


}
