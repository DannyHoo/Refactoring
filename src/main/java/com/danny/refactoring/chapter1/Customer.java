package com.danny.refactoring.chapter1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Customer
 * @Copyright: Copyright (c) 2016
 * @Description: 顾客
 * @Company: lxjr.com
 * @Created on 2016-11-26 15:29:18
 */
public class Customer {
    private String _name;//姓名
    private Vector _rentals = new Vector();//租的电影

    public Customer(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }

    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    public String statement() {

        Enumeration rentals = _rentals.elements();//用于遍历
        String result = "Rental Record for " + get_name() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //show figure for this rental
            result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    /**
     * 用Customer类的getTotalCharge()代替statement()方法中的临时变量totalAmount
     * 提高方法的简洁渡
     * 抽出来也能达到复用的效果
     * @return
     */
    private double getTotalCharge(){
        double totalAmount=0;
        Enumeration rentals=_rentals.elements();
        while(rentals.hasMoreElements()){
            totalAmount+=((Rental)rentals.nextElement()).getCharge();
        }
        return totalAmount;
    }

    /**
     * 同样的方式处理 积分计算
     * 抽出来之后，有个问题 --> 是不是整个过程，增加了多个循环？？？？？？
     * @return
     */
    private int getTotalFrequentRenterPoints(){
        int frequentRenterPoints = 0;
        Enumeration rentals=_rentals.elements();
        while(rentals.hasMoreElements()){
            frequentRenterPoints+=((Rental)rentals.nextElement()).getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}
