package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public class StrategyEat extends Strategy{
    private final Command command = getCommand();
    private final Game game = getGame();
    /**
     * @param command1 接收到的命令
     * @param game1    产生反应的Game实体
     */
    public StrategyEat(Command command1, Game game1) {
        super(command1, game1);
    }

    /**
     * @return
     */
    @Override
    public Object copeWithCommand() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Eat what?");
            return "Unknow what to Eat....";
        }
        String description = command.getSecondWord();
        if(!description.equals("cookie")){
            System.out.println("You can't eat it.");
            return "Wrong description!";
        }
        //先看房间中有没有cookie
        Integer weight=game.getPlayer().getCurrentRoom().getObject(description);
        if(weight!=null){
                //房间删除饼干
                game.getPlayer().getCurrentRoom().dropObject(description);
                //玩家承重增加
                game.getPlayer().setMaximum_load(game.getPlayer().getMaximum_load()+2);
                System.out.println("You can take more things now.");
                return "Success!";
        }else{
            //查询玩家行李中是否有饼干
            weight=game.getPlayer().getObject(description);
            //有饼干时
            if(weight!=null) {
                //背包删除饼干
                game.getPlayer().dropObject(description);
                //玩家承重增加
                game.getPlayer().setMaximum_load(game.getPlayer().getMaximum_load() + 2);
                System.out.println("You can take more things now.");
                return "Success!";
            }else{
                System.out.println("There is no cookie.");
                return "No cookie!";
            }
        }


    }
}
