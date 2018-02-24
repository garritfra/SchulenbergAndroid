package com.garritfra.schulenberg_android.model;

/**
 * Created by garritfra on 24.02.18.
 */

public abstract class BaseModel {
    private int id;

    public BaseModel() {
        this.id = generateId();
    }

    protected int generateId() {
        return this.hashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
