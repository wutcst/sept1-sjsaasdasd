package strategy;

/**
 * 策略模式-------上下文类.
 */
public class Context {
    /**
     * 用来确定上下文的变量
     */
    private final Strategy strategy;

    /**
     * 构造函数
     *
     * @param strategy1 关联上下文
     */
    public Context(Strategy strategy1) {
        this.strategy = strategy1;
    }

    /**
     * 调用strategy类定义的抽象类copeWithCommand();
     */
    public Object getResult() {
        return strategy.copeWithCommand();
    }
}

