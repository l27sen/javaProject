package com.ood.state;

public class GreenState extends  State{

    @Override
    public void changeState(StateManager stateManager) {
        System.out.println("现在是"+this.getColor());
//        绿灯亮10s
//        绿灯变黄灯
        stateManager.setState(new YellowState());
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

}
