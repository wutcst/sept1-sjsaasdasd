package strategy;

/**
 * 策略模式-------上下文类.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Object getResult() {
        return strategy.copeWithCommand();
    }
}

