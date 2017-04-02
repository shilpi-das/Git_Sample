package com.gl.gsonexample.model;


/**
 * Created by shilpi.das on 14-12-2016.
 */

public abstract class Model {



        public abstract void parseJson(String jsonData);

        public abstract String toJson();

        public abstract void print();


}
