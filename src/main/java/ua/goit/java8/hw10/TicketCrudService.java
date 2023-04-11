package ua.goit.java8.hw10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {

    private SessionFactory sessionFactory;

    public TicketCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ticket createTicket(Ticket ticket) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to create ticket: " + e.getMessage(), e);
        }
    }

    public Ticket getTicketById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get ticket by ID: " + e.getMessage(), e);
        }
    }

    public List<Ticket> getAllTickets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Ticket", Ticket.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all tickets: " + e.getMessage(), e);
        }
    }

    public void updateTicket(Ticket ticket) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to update ticket: " + e.getMessage(), e);
        }
    }

    public void updateTicket(Ticket ticket, Integer id) {
        ticket.setId(id);
        updateTicket(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to delete ticket: " + e.getMessage(), e);
        }
    }
    public void deleteTicketById(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to delete ticket: " + e.getMessage(), e);
        }
    }
}

