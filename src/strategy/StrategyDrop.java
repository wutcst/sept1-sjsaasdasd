package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public class StrategyDrop extends Strategy{
    private final Command command = getCommand();
    private final Game game = getGame();
    /**
     * @param command1 接收到的命令
     * @param game1    产生反应的Game实体
     */
    public StrategyDrop(Command command1, Game game1) {
        super(command1, game1);
    }

    /**
     * @return
     */
    @Override
    public Object copeWithCommand() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Drop what?");
            return "Unknow what to Drop....";
        }
        String description = command.getSecondWord();
        Integer weight=game.getPlayer().getObject(description);
        if(weight==null){
            System.out.println("You have nothing like “"+description+"”.");
            return "Wrong description!";
        }else{
            //房间添加物品
            game.getPlayer().getCurrentRoom().setObject(description,weight);
            //玩家删除物品
            game.getPlayer().dropObject(description);
            System.out.println("You dropped the "+description+".");
        }
        return "Success!";
    }
}
