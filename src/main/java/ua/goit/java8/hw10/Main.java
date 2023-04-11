package ua.goit.java8.hw10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, 1);
        transaction.commit();
        System.out.println(ticket);

        TicketCrudService ticketCrudService = new TicketCrudService(sessionFactory);
        List<Ticket> allTickets = ticketCrudService.getAllTickets();
        allTickets.forEach(System.out::println);

        sessionFactory.close();
    }
}