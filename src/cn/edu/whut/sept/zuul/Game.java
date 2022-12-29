/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * <p>
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 * <p>
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;


import room.*;
import strategy.*;

import java.util.ArrayList;

public class Game {

    private Parser parser;

    private Absroom startRoom;
    //private Rroom currentRoom;
    private RoomBuilderFactory factory;
    //游戏玩家类
    private Player Player=null;



    //保存生成的房间
    private  ArrayList<Absroom> RoomList=null;
    /**
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game() {
        RoomList=new ArrayList<>();
        Player=new Player();
        parser = new Parser();
        createRooms();
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms() {
        //Room outside, theater, pub, lab, office;

        // create the rooms
        /*
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        */
        //创建普通房间
        factory = new OutsideBuilder();
        Absroom outside = factory.createRoom();
        factory = new TheaterBuilder();
        Absroom theater= factory.createRoom();
        factory = new PubBuilder();
        Absroom pub= factory.createRoom();
        factory = new LabBuilder();
        Absroom lab= factory.createRoom();
        factory = new OfficeBuilder();
        Absroom office= factory.createRoom();
        //创建随机传送房间
        factory = new TransRoomBuilder();
        Absroom transfer= factory.createRoom();
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        theater.setExit("south",transfer);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        transfer.setExit("north",theater);
        //将创建好的Rooms加入List，不需要加入随机房间
        this.RoomList.add(outside);
        this.RoomList.add(theater);
        this.RoomList.add(pub);
        this.RoomList.add(lab);
        this.RoomList.add(office);
        startRoom=outside;

        this.Player.setCurrentRoom(outside);
        //currentRoom = outside;  // start game outside
    }

    /**
     *  游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(Player.getCurrentRoom().getLongDescription());
    }

    /**
     * 执行用户输入的游戏指令.
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     * @return 如果执行的是游戏结束指令，则返回true，否则返回false.
     */
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        switch (command.getCommandWord()) {
            case "help":
                new Context(new StrategyHelp(command, this)).getResult();
                break;
            case "go":
                new Context(new StrategyGo(command, this)).getResult();
                break;
            case "look":
                new Context(new StrategyLook(command, this)).getResult();
                break;
            case "back":
                new Context(new StrategyBack(command, this)).getResult();
                break;
            case "quit":
                wantToQuit = (boolean) new Context(new StrategyQuit(command, this)).getResult();
                break;


        }
        /*
        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        * */

        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:







    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    public Parser getParser() {
        return this.parser;
    }
    public Absroom getStartRoom() {
        return this.startRoom;
    }
    public ArrayList<Absroom> getRoomList() {
        return RoomList;
    }
    public Player getPlayer() {
        return Player;
    }

    public void setPlayer(cn.edu.whut.sept.zuul.Player player) {
        Player = player;
    }
    public void setStartRoom(Absroom nextRoom) {
        this.startRoom = nextRoom;
    }
}