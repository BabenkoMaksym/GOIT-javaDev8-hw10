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
                .buildSessionFactory();

        ClientCrudService clientCrudService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetCrudService = new PlanetCrudService(sessionFactory);

        Client client = new Client("Oleg Oleg");

        clientCrudService.addClient(client);
        List<Client> allClients = clientCrudService.getAllClients();
        allClients.forEach(System.out::println);

        Client clientById = clientCrudService.getClientById(12);
        System.out.println(clientById);

        client.setName("Oleg Oleg Oleg");

        clientCrudService.updateClient(client, 12);

        allClients = clientCrudService.getAllClients();
        allClients.forEach(System.out::println);


        clientCrudService.deleteClientById(12);
        allClients = clientCrudService.getAllClients();
        allClients.forEach(System.out::println);

    }
}