package lk.ijse.absd.pos.service.impl;

import lk.ijse.absd.pos.dto.ItemDTO;
import lk.ijse.absd.pos.entity.Item;
import lk.ijse.absd.pos.repository.ItemRepository;
import lk.ijse.absd.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveItem(String itemCode, ItemDTO dto) {
        if (!dto.getCode().equals(itemCode)) {
            throw new RuntimeException("Item code mismatched.");
        } else {
            repository.save(new Item(
                    dto.getCode(),
                    dto.getDescription(),
                    dto.getUnitPrice(),
                    dto.getQty()));
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateItem(String itemCode, ItemDTO dto) {
        if (!dto.getCode().equals(itemCode)) {
            throw new RuntimeException("Item code mismatched.");
        } if (repository.existsById(itemCode)) {
            repository.save(new Item(
                    dto.getCode(),
                    dto.getDescription(),
                    dto.getUnitPrice(),
                    dto.getQty()));
        } else {
            throw new RuntimeException("Item not found");
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteItem(String itemCode) {
        repository.deleteById(itemCode);

    }

    @Override
    public ItemDTO findItem(String itemCode) {

        Item item = repository.findById(itemCode).get();

        return new ItemDTO(
                item.getCode(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQty());
    }

    @Override
    public List<ItemDTO> findAllItems() {
        List<Item> items = repository.findAll();
        List<ItemDTO> dtos = new ArrayList<>();

        for (Item item : items) {
            dtos.add(new ItemDTO(
                    item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQty()
            ));

        }

        return dtos;
    }

    @Override
    public long getItemCount() {
        return 0;
    }

}
