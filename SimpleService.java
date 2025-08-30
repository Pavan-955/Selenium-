package One.simple.Learn_Maven;

public class SimpleService {

    // Constructor (optional, if you want to print "y" when an object is created)
    public SimpleService() {
        System.out.println("y");
    }

    // Method to return a greeting
    public String helloService(String msg) {
        return "Hello " + msg;
    }

    // Main method to run the class directly
    public static void main(String[] args) {
        SimpleService service = new SimpleService();
        String response = service.helloService("World");
        System.out.println(response);
    }
}
