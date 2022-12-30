package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public class StrategyTake extends Strategy{
    private final Command command = getCommand();
    private final Game game = getGame();
    /**
     * @param command1 接收到的命令
     * @param game1    产生反应的Game实体
     */
    public StrategyTake(Command command1, Game game1) {
        super(command1, game1);
    }

    /**
     * @return
     */
    @Override
    public Object copeWithCommand() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return "Unknow what to Take....";
        }
        String description = command.getSecondWord();
        Integer weight=game.getPlayer().getCurrentRoom().getObject(description);
        if(weight==null){
            System.out.println("There is nothing like “"+description+"”.");
            return "Wrong description!";
        }else if(game.getPlayer().isOverWeight(weight)){
            System.out.println("It will be overweight if you take it.");
            return "Overweight!";
        }else{
            //玩家添加物品
            game.getPlayer().setObject(description,weight);
            //房间删除物品
            game.getPlayer().getCurrentRoom().dropObject(description);
            System.out.println("You take it up.");
        }
        return "Success!";
    }

}
