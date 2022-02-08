package com.st.sp.impl;

import com.st.sp.api.Caculater;

public class MyCaculater implements Caculater {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int min(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int multi(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
