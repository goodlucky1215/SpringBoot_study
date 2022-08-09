package rookie.shop.exception;

import java.sql.SQLException;

public class ItemException extends RuntimeException{

    public ItemException() {}

    public ItemException(Throwable cause) {
        super(cause);
    }

    public ItemException(String cause) {
        super(cause);
    }

}
