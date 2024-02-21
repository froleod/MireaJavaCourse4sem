package prak6;

// Интерфейс продукта A
interface ProductA {
    void create();
}

// Интерфейс продукта B
interface ProductB {
    void create();
}

// Конкретный продукт A1
class ConcreteProductA1 implements ProductA {
    @Override
    public void create() {
        System.out.println("ConcreteProductA1 created");
    }
}

// Конкретный продукт B1
class ConcreteProductB1 implements ProductB {
    @Override
    public void create() {
        System.out.println("ConcreteProductB1 created");
    }
}

// Абстрактная фабрика
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// Конкретная фабрика 1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}

// Пример использования
public class AbstractFactoryExample {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory1();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();

        productA.create();
        productB.create();
    }
}
