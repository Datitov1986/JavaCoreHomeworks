package Shop.Exceptions;

public class TooMuchSaleException extends Exception{
    public TooMuchSaleException() {
    }

    public TooMuchSaleException(String message) {
        super(message);
    }
}
