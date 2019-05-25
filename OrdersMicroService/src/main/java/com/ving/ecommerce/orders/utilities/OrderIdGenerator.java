package com.ving.ecommerce.orders.utilities;

import java.security.SecureRandom;

public class OrderIdGenerator {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static SecureRandom rnd = new SecureRandom();

    public String getRandomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public String getNewOrderId() {
        return this.getRandomString(20);
    }
}