package hello.proxy.app.v2;



public class OrderRepositoryV2 {

    public void save(String itemId) {
        //저장 로직
        if(itemId.equals("ex")){
            throw new IllegalStateException("삐용 삐용~~예외~~");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
