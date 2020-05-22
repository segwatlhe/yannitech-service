package com.yannitech.bookstore.yannitech.model;

import java.util.ArrayList;
import java.util.List;

public class Books 
{
    private List<Book> employeeList;
    
    public List<Book> getEmployeeList() {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
 
    public void setEmployeeList(List<Book> employeeList) {
        this.employeeList = employeeList;
    }
}