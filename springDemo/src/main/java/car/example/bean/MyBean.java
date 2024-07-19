package car.example.bean;

public class MyBean {
    private String message;

    public void setMessage(String msg) {
        this.message = msg;
    }

    public void showMessage() {
        System.out.println("Message" + message);
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "message='" + message + '\'' +
                '}';
    }
}

