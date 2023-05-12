package com.example.lab5.service;

import com.example.lab5.dao.CustomerDao;
import com.example.lab5.model.Customer;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.FacesContext;

import java.util.List;


@ManagedBean(name = "customerBean")
public class CustomerBean {

    private Long id;
    private String fullName;
    private String country;
    private String state;
    private String city;
    private String zip;

    private String editCustomerId;

    public String createNewCustomer(CustomerBean customer) {
        Customer toBeSaved = new Customer(null, customer.fullName, customer.country,
                customer.state, customer.city, customer.zip);
        CustomerDao customerDao = new CustomerDao();
        customerDao.save(toBeSaved);
        return "customers.xhtml?faces-redirect=true";
    }

    public List<Customer> getCustomers() {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.getAll();
    }

    public String updateCustomer(CustomerBean customer) {
        Customer inEdit = new Customer(Long.valueOf(customer.editCustomerId), customer.fullName, customer.country,
                customer.state, customer.city, customer.zip);
        System.out.println("UPDATING WITH DATA: " + inEdit);
        CustomerDao customerDao = new CustomerDao();
        customerDao.update(inEdit);
        return "customers.xhtml?faces-redirect=true";
    }

    public String editCustomer() {
        editCustomerId = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("selectedCustomerId");
        System.out.println("CUSTOMER: " + editCustomerId);
        return "customerEdit.xhtml";
    }

    public String deleteCustomer(long customerId) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.delete(customerId);
        return "customers.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEditCustomerId() {
        return editCustomerId;
    }

    public void setEditCustomerId(String editCustomerId) {
        this.editCustomerId = editCustomerId;
    }
}
