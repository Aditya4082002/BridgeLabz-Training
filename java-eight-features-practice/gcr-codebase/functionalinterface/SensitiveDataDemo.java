package functionalinterface;

//Marker interface (no methods)
interface SensitiveData {
}


class CustomerCredentials implements SensitiveData {

    private String username;
    private String password;

    public CustomerCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString() {
        return "CustomerCredentials [username=" + username +
               ", password=" + password + "]";
    }
}


class ProductInfo {

    private String productName;

    public ProductInfo(String productName) {
        this.productName = productName;
    }

    public String toString() {
        return "ProductInfo [productName=" + productName + "]";
    }
}


class EncryptionService {

    public static void process(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data: " + obj);
        } else {
            System.out.println("No encryption required: " + obj);
        }
    }
}


public class SensitiveDataDemo {

    public static void main(String[] args) {

        CustomerCredentials credentials =
                new CustomerCredentials("aditya", "secret123");

        ProductInfo product =
                new ProductInfo("Laptop");

        EncryptionService.process(credentials);
        EncryptionService.process(product);
    }
}
