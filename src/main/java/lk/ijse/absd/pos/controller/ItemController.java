package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.ItemDTO;
import lk.ijse.absd.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService service;

    @PutMapping("/{code}")
    public void saveItem(@PathVariable("code") String code,
                         @RequestBody ItemDTO dto) {
        service.saveItem(code, dto);
//        System.out.println("put mapping");
    }

    @PostMapping("/{code}")
    public void updateItem(@PathVariable String code,
                           @RequestBody ItemDTO dto) {
        service.updateItem(code, dto);
    }

    @DeleteMapping("/{code}")
    public void deleteItem(@PathVariable String code) {
//        service.deleteItem(code);
        System.out.println("delete mapping");
    }

    @GetMapping
    public List<ItemDTO> findAllItems() {
        return service.findAllItems();
    }

}
