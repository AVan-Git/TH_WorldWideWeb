package vn.edu.iuh.fit.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.se.entity.Address;
import vn.edu.iuh.fit.se.service.impl.AddressServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping()
    public List<Address> getAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id) {
        Optional<Address> op = addressService.findById(id);
        if (op.isPresent())
            return op.get().toString();
        return "Khong tim thay !!";
    }


}
