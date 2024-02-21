package prak6.Builder;


// Продукт, который мы строим

// Интерфейс строителя
interface Builder {
    void buildPart1();
    void buildPart2();
    Product getResult();
}

// Конкретный строитель
class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("Part1 built");
    }

    @Override
    public void buildPart2() {
        product.setPart2("Part2 built");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

// Директор, который управляет строителем
class Director {
    public void construct(Builder builder) {
        builder.buildPart1();
        builder.buildPart2();
    }
}

// Пример использования
public class BuilderExample {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director();

        director.construct(builder);

        Product product = builder.getResult();
        System.out.println(product);
    }
}
