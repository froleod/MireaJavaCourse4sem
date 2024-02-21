package prak6;

// Интерфейс прототипа
interface Prototype {
    Prototype clone();
}

// Конкретный прототип A
class ConcretePrototypeA implements Prototype {
    private String field;

    public ConcretePrototypeA(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototypeA(this.field);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA [field=" + field + "]";
    }
}

// Конкретный прототип B
class ConcretePrototypeB implements Prototype {
    private int number;

    public ConcretePrototypeB(int number) {
        this.number = number;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototypeB(this.number);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeB [number=" + number + "]";
    }
}

// Пример использования
public class PrototypeExample {
    public static void main(String[] args) {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("Initial field value");
        System.out.println("Original prototypeA: " + prototypeA);

        // Клонирование прототипа A
        ConcretePrototypeA clonedPrototypeA = (ConcretePrototypeA) prototypeA.clone();
        System.out.println("Cloned prototypeA: " + clonedPrototypeA);

        ConcretePrototypeB prototypeB = new ConcretePrototypeB(42);
        System.out.println("Original prototypeB: " + prototypeB);

        // Клонирование прототипа B
        ConcretePrototypeB clonedPrototypeB = (ConcretePrototypeB) prototypeB.clone();
        System.out.println("Cloned prototypeB: " + clonedPrototypeB);
    }
}
