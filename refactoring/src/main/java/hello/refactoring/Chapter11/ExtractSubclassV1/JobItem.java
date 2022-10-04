package hello.refactoring.Chapter11.ExtractSubclassV1;

public class JobItem {

    private int _unitPrice;
    private int _quantity;
    private boolean _isLabor;

    public JobItem(int unitPrice, int quantity,boolean isLabor){
        _unitPrice= unitPrice;
        _quantity = quantity;
        _isLabor = isLabor;
    }

    public int getTotalPrice() {
        return getUnitPrice()*_quantity;
    }

    public int getUnitPrice() {
        return (_isLabor) ? 30:_unitPrice;
    }

    public int getQuantity() {
        return _quantity;
    }

    public boolean is_isLabor() {
        return _isLabor;
    }
}
