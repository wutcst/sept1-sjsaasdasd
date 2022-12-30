package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public class StrategyItem extends Strategy {
    private final Command command = getCommand();
    private final Game game = getGame();
    /**
     * @param command1 接收到的命令
     * @param game1    产生反应的Game实体
     */
    public StrategyItem(Command command1, Game game1) {
        super(command1, game1);
    }

    /**
     * @return
     */
    @Override
    public Object copeWithCommand() {
        Integer object_totalWeight=game.getPlayer().getCurrentRoom().showObjects();
        System.out.println("Objects' total weight:"+object_totalWeight);
        System.out.println();
        Integer baggage_totalWeight=game.getPlayer().showBaggage();
        System.out.println("Baggage's total weight:"+baggage_totalWeight);
        return null;
    }
}
