package lk.ijse.absd.pos.dto;

public class ItemDTO {

    private String code;
    private String description;
    private double unitPrice;
    private int qty;

    public ItemDTO() {
    }

    public ItemDTO(String code, String description, double unitPrice, int qty) {
        this.setCode(code);
        this.setDescription(description);
        this.setUnitPrice(unitPrice);
        this.setQty(qty);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}
