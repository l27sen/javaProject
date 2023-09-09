package com.ood.state;

public class RedState extends State {
    @Override
    public void changeState(StateManager stateManager) {
        System.out.println("现在是"+this.getColor());
//       红灯亮5s
//        红灯变绿灯
        stateManager.setState(new GreenState());
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}

