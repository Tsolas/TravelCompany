package com.travelcompany.eshop.dto;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.OrderedTicketRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reports {

    /**
     * Calculates the total number of Tickets fo all customers
     *
     * @param tickets
     * @return
     */
    public int calculateNumberOfTickets(List<OrderedTicket> tickets) {
        return tickets.size();
    }

    /**
     * Calculates the total cost of the tickets of all customers
     *
     * @param tickets
     * @return
     */
    public double calculateCostOfTickets(List<OrderedTicket> tickets) {
        double total = 0;
        for (OrderedTicket obj : tickets) {
            total = +obj.getPaymentAmount();
        }
        return total;
    }

    /**
     * Finds total offered itineraries per destination airport. It uses the
     * HashMaps ability to overwrite duplicate keys
     *
     * @param itineraries
     * @return
     */
    public Map<String, Integer> getItinerariesPerDestination(List<Itinerary> itineraries) {
        Map<String, Integer> temp = new HashMap<>();
        for (Itinerary obj : itineraries) {
            int counter = 0;
            for (Itinerary itinerary : itineraries) {
                if (obj.getDestinationAirportCode().equals(itinerary.getDestinationAirportCode())) {
                    counter++;
                }
            }
            temp.put(obj.getDestinationAirportCode(), counter);
        }
        return temp;
    }

    /**
     * Finds total offered itineraries per departure airport. It uses the
     * HashMaps ability to overwrite duplicate keys
     *
     * @param itineraries
     * @return
     */
    public Map<String, Integer> getItinerariesPerDeparture(List<Itinerary> itineraries) {
        Map<String, Integer> temp = new HashMap<>();
        for (Itinerary obj : itineraries) {
            int counter = 0;
            for (Itinerary itinerary : itineraries) {
                if (obj.getDepartureAirportCode().equals(itinerary.getDepartureAirportCode())) {
                    counter++;
                }
            }
            temp.put(obj.getDepartureAirportCode(), counter);
        }
        return temp;
    }

    /**
     * Returns the customers with the most tickets
     *
     * @param ticketRepository
     * @param customers
     * @return
     */
    public List<Customer> getMostTickets(OrderedTicketRepository ticketRepository, CustomerRepository customers) {
        Map<Integer, Integer> temp = new HashMap<>();
        List<OrderedTicket> tickets = ticketRepository.readAll();
        for (OrderedTicket obj : tickets) {
            int counter = 0;
            for (OrderedTicket ticks : tickets) {
                if (obj.getPassengerId() == ticks.getPassengerId()) {
                    counter++;
                }
            }
            temp.put(obj.getPassengerId(), counter);
        }
        List<Integer> maxCustomer = new ArrayList<>();
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            if (entry.getValue() >= max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            if (entry.getValue() == max) {
                maxCustomer.add(entry.getKey());
            }
        }
        List<Customer> cust = new ArrayList<>();
        for (Integer id : maxCustomer) {
            cust.add(customers.read(id));
        }
        return cust;
    }

    /**
     * Returns the customers with the largest cost of purchases
     *
     * @param ticketRepository
     * @param customers
     * @return
     */
    public List<Customer> getlargestCost(OrderedTicketRepository ticketRepository, CustomerRepository customers) {
        Map<Integer, Double> temp = new HashMap<>();
        List<OrderedTicket> tickets = ticketRepository.readAll();
        double sum = 0;
        for (OrderedTicket obj : tickets) {
            for (OrderedTicket ticks : tickets) {
                if (obj.getPassengerId() == ticks.getPassengerId()) {
                    sum = +ticks.getPaymentAmount();
                }
            }
            temp.put(obj.getPassengerId(), sum);
        }
        List<Integer> maxCustomer = new ArrayList<>();
        double max = -1;
        for (Map.Entry<Integer, Double> entry : temp.entrySet()) {
            if (entry.getValue() >= max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Double> entry : temp.entrySet()) {
            if (entry.getValue() == max) {
                maxCustomer.add(entry.getKey());
            }
        }
        List<Customer> cust = new ArrayList<>();
        for (Integer id : maxCustomer) {
            cust.add(customers.read(id));
        }
        return cust;
    }

    /**
     * Finds customers that have not made any purchases
     *
     * @param ticketRepository
     * @param customerRepository
     * @return
     */
    public List<Customer> getNoTickets(OrderedTicketRepository ticketRepository, CustomerRepository customerRepository) {
        List<Customer> noPurchases = new ArrayList<>();
        List<Customer> customers = customerRepository.readAll();
        List<OrderedTicket> tickets = ticketRepository.readAll();

        for (Customer cust : customers) {
            boolean exists = false;
            for (OrderedTicket tick : tickets) {
                if (cust.getId() == tick.getPassengerId()) {
                    exists = true;
                }
            }
            if (!exists) {
                noPurchases.add(cust);
            }
        }
        return noPurchases;
    }

}
