package com.danny.refactoring.chapter1;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Client
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2016-11-26 16:27:48
 */
public class Client {

    public static void main(String[] args) {
        Movie movie1=new Movie("Danny教你学美语",2);
        Movie movie2=new Movie("Danny教你学计算机",2);
        Rental rental1=new Rental(movie1,10);
        Rental rental2=new Rental(movie2,20);
        Customer customer=new Customer("胡玉洋");
        customer.addRental(rental1);
        customer.addRental(rental2);
        System.out.println(customer.statement());
        
    }
}
