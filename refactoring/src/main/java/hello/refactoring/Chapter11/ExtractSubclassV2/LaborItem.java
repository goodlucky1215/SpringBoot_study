package hello.refactoring.Chapter11.ExtractSubclassV2;

import hello.refactoring.Chapter11.ExtractSubclassV1.JobItem;

public class LaborItem extends JobItem {
    public LaborItem(int quantity) {
        super(0, quantity, true);
    }
    public int getUnitPrice() {
        return 30;
    }
    protected boolean isLabor(){
        return true;
    }
}
