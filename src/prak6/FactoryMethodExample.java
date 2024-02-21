package prak6;


// Интерфейс продукта
interface Product {
    void create();
}

// Конкретный продукт
class ConcreteProduct implements Product {
    @Override
    public void create() {
        System.out.println("ConcreteProduct created");
    }
}

// Интерфейс фабрики
interface Creator {
    Product createProduct();
}

// Конкретная фабрика
class ConcreteCreator implements Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProduct();
    }
}

// Пример использования
public class FactoryMethodExample {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct();
        product.create();
    }
}
