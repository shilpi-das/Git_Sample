package com.gl.gsonexample.enums;

/**
 * ModelEnum defining different model constants
 */

public enum ModelEnum {
    LoginModel(1),
    ItemModel(2),
    HistoryModel(3),
    PlaceOrderModel(4),
    FeedbackModel(5);

    private int numVal;

    ModelEnum(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

}
