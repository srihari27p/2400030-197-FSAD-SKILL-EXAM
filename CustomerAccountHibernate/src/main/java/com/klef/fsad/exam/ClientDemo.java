package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // I. Insert Record
        CustomerAccount c = new CustomerAccount();
        c.setName("Srihari");
        c.setDescription("Savings Account");
        c.setDate(new Date());
        c.setStatus("Active");

        session.save(c);

        tx.commit();
        System.out.println("Record Inserted Successfully");

        // II. Update Record
        Transaction tx2 = session.beginTransaction();

        CustomerAccount ca = session.get(CustomerAccount.class,1);

        if(ca!=null)
        {
            ca.setName("Srihari P");
            ca.setStatus("Updated");

            session.update(ca);
            System.out.println("Record Updated Successfully");
        }

        tx2.commit();

        session.close();
        sf.close();
    }
}