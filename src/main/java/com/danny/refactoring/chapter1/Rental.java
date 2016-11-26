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
        return _movie.getCharge(_daysRented);
    }

    /**
     * 计算积分
     * @return
     */
    public int getFrequentRenterPoints(){
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}
