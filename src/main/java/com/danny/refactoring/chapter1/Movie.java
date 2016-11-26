package com.danny.refactoring.chapter1;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Movie
 * @Copyright: Copyright (c) 2016
 * @Description: 影片
 * @Company: lxjr.com
 * @Created on 2016-11-26 15:25:51
 */
public class Movie {
    //
    public static final  int CHILDRENS=2;
    public static final  int REGULAR=0;
    public static final int NEW_RELEASE=1;

    private String _title;//电影标题
    private int _priceCode;//价格等级

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }
}
