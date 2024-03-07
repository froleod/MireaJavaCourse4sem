package prak7;

import java.util.ArrayList;
import java.util.List;

interface Component {
    void operation();
    void add(Component c);
    void remove(Component c);
    Component getChild(int i);
}

class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    @Override
    public void operation() {
        System.out.println("Composite: Performing operation.");
        for (Component child : children) {
            child.operation();
        }
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }
}

class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf: Performing operation.");
    }

    @Override
    public void add(Component c) {
    }

    @Override
    public void remove(Component c) {
    }

    @Override
    public Component getChild(int i) {
        return null;
    }
}

public class CompositePatternExample {
    public static void main(String[] args) {
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        Composite composite = new Composite();

        // Добавляем Leaf в Composite
        composite.add(leaf1);
        composite.add(leaf2);

        // Вызываем метод operation() на Composite, который вызовет operation() на каждом объекте внутри него
        composite.operation();
    }
}
