package com.ood.state;

public class YellowState extends State {
    @Override
    public void changeState(StateManager stateManager) {
        System.out.println("现在是"+this.getColor());
//        黄灯3秒
//        黄灯变红灯
        stateManager.setState(new RedState());
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }
}

