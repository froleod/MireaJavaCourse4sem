package prak8.State;

interface State{
    void handle();
}

class Context{

    private State currentState;

    public Context() {
        currentState = new ConcreteState1(this);
    }

    public void setState(State currentState) {
        this.currentState = currentState;
    }

    void request(){
        currentState.handle();
    }
}

class ConcreteState1 implements State{
    private final Context context;

    ConcreteState1(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println("Handling request in ConcreteState1");
        context.setState(new ConcreteState2(context));
    }
}


class ConcreteState2 implements State{
    private final Context context;

    ConcreteState2(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println("Handling request in ConcreteState2");
        context.setState(new ConcreteState1(context));
    }
}

public class StatePatternExample {
    public static void main(String[] args) {
        Context context = new Context();
        context.request();


        context.request();
    }
}
