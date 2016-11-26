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
    //影片类型枚举值
    public static final  int REGULAR=0;
    public static final int NEW_RELEASE=1;
    public static final  int CHILDRENS=2;

    private String _title;//电影标题
    private int _priceCode;//影片类型

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

    /**
     * 计算金额
     * 最好不要在另一个对象的属性上运用switch，如果不得不用，也最好在自己的属性上使用switch
     * 所以此方法由原来在Rental类中移到Movie类中
     * @param daysRented
     * @return
     */
    public double getCharge(int daysRented){
        double result=0;
        switch (get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented> 2)//租期大于2天
                    result += (daysRented - 2) * 1.5;//金额=2+(租期天数-2)*1.5
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;//金额=租期天数*3
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3)//租期大于3天
                    result += (daysRented - 3) * 1.5;//金额=1.5+(租期天数-3)*1.5
                break;
        }
        return result;
    }

    /**
     * 计算积分
     * @return
     */
    public int getFrequentRenterPoints(int _daysRented){
        if (get_priceCode()==Movie.NEW_RELEASE && _daysRented>1){
            return 2;
        }else {
            return 1;
        }

    }
}
