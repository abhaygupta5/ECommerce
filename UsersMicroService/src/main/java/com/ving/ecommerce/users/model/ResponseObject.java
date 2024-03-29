package com.ving.ecommerce.users.model;

public class ResponseObject {
    private Object data;
    private boolean ok;

    public ResponseObject(Object data, boolean ok) {
        this.data = data;
        this.ok = ok;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean getOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "data=" + data +
                ", ok=" + ok +
                '}';
    }
}


