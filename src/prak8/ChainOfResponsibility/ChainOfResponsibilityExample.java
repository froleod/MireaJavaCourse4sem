package prak8.ChainOfResponsibility;

interface Handler {
    void handleRequest();
}

class ConcreteHandler1 implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest() {
        System.out.println("ConcreteHandler1 is handling the request");
        if (nextHandler != null) {
            nextHandler.handleRequest();
        }
    }
}

class ConcreteHandler2 implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest() {
        System.out.println("ConcreteHandler2 is handling the request");
        if (nextHandler != null) {
            nextHandler.handleRequest();
        }
    }
}

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        ((ConcreteHandler1) handler1).setNextHandler(handler2);

        handler1.handleRequest(); // Обработает ConcreteHandler1 и ConcreteHandler2
    }
}
