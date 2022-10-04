package hello.refactoring.Chapter11.ExtractSubclassV2;

/*
* 하위클래스 추출
* 일부 인스턴스에만 사용되는 기능이 든 클래스가 있을 땐
* 그 기능 부분만을 전담하는 하위클래스를 작성하자.
*
* */
public class JobItem {

    private int _unitPrice;
    private int _quantity;
    private boolean _isLabor;

    protected JobItem(int unitPrice, int quantity, boolean isLabor){
        _unitPrice= unitPrice;
        _quantity = quantity;
        _isLabor = isLabor;
    }

    protected JobItem(int unitPrice, int quantity){
        this(unitPrice,quantity,false);
    }

    public int getTotalPrice() {
        return getUnitPrice()*_quantity;
    }

    public int getUnitPrice() {
        return _unitPrice;
    }

    public int getQuantity() {
        return _quantity;
    }

    public boolean is_isLabor() {
        return _isLabor;
    }

    protected boolean isLabor(){
        return false;
    }
}
