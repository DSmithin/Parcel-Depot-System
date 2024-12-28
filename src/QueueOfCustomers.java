import java.util.*;
class QueueOfCustomers {
    private Queue<Customer> customerQueue;

    public QueueOfCustomers() {
        customerQueue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
    }

    public Customer removeCustomer() {
        return customerQueue.poll();
    }

    public Customer peekNextCustomer() {
        return customerQueue.peek();
    }

    public boolean isEmpty() {
        return customerQueue.isEmpty();
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerQueue);
    }

    @Override
    public String toString() {
        return "Queue: " + customerQueue;
    }
}
