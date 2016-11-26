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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();//用于遍历
        String result = "Rental Record for " + get_name() + "\n";
        while (rentals.hasMoreElements()) {
            /*double thisAmount = 0;*/
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints+=each.getFrequentRenterPoints();

            /*thisAmount=each.getCharge();*/
            /*thisAmount=amountFor(each);*/
            //determine amounts for each line
            /*switch (each.get_movie().get_priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.get_daysRented() > 2)//租期大于2天
                        thisAmount += (each.get_daysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.get_daysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.get_daysRented() > 3)//租期大于3天
                        thisAmount += (each.get_daysRented() - 3) * 1.5;
                    break;
            }*/

            //add frequent renter points
            /*frequentRenterPoints++;*/

            //add bonus for a two day new release rental
            if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE) && each.get_daysRented() > 1)
                frequentRenterPoints++;

            //show figure for this rental
            result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    /*public double amountFor(Rental aRental){
        double result=0;
        switch (aRental.get_movie().get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (aRental.get_daysRented() > 2)//租期大于2天
                    result += (aRental.get_daysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += aRental.get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (aRental.get_daysRented() > 3)//租期大于3天
                    result += (aRental.get_daysRented() - 3) * 1.5;
                break;
        }
        return result;
    }*/
}
