package prak7;

interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}

// Заместитель Proxy
class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        // Создаем реальный объект только при необходимости
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        // Делегируем запрос реальному объекту
        realSubject.request();
    }
}
public class ProxyPatternExample {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.request();
    }
}