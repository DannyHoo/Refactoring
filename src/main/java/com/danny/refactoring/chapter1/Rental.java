package com.danny.refactoring.chapter1;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Rental
 * @Copyright: Copyright (c) 2016
 * @Description: 租赁
 * @Company: lxjr.com
 * @Created on 2016-11-26 15:29:45
 */
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {

        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public void set_movie(Movie _movie) {
        this._movie = _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    public void set_daysRented(int _daysRented) {
        this._daysRented = _daysRented;
    }

    /**
     * 计算金额
     * @return
     */
    public double getCharge(){
        double result=0;
        switch (get_movie().get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (get_daysRented() > 2)//租期大于2天
                    result += (get_daysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (get_daysRented() > 3)//租期大于3天
                    result += (get_daysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(){
        return 1;
    }
}
