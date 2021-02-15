package com.fzzfegg.bungeeemail.stored;

import java.lang.reflect.Method;

public enum Stored {

    ymal,mysql;

    Class<?> a;

    Stored(){
        try {
            String className = "com.fzzfegg.bungeeemail.stored.sql.CustomItem";
            a = Class.forName(className);
            //Method method = Clazz.getDeclaredMethod("abs");
        } catch (Exception e) {}
    }

    public void b(String method,String[] args) {
        try {
            Method b = a.getDeclaredMethod(method);
            Object c = b.invoke(a,args);
        } catch (Exception e) {}
    }


}

