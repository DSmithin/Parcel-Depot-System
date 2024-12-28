import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager {
    public static void main(String[] args) {
        ParcelMap parcelMap = new ParcelMap();
        QueueOfCustomers queueOfCustomers = new QueueOfCustomers();
        Log log = Log.getInstance();

        // Sample data
        parcelMap.addParcel(new Parcel("C101", 10, "2x5x2", 2));
        parcelMap.addParcel(new Parcel("C200", 8, "6x2x2", 5));
        queueOfCustomers.addCustomer(new Customer(1, "John Brown", "C101"));
        queueOfCustomers.addCustomer(new Customer(2, "Mary Smith", "C200"));

        // Build GUI
        JFrame frame = new JFrame("Parcel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Parcel Panel
        DefaultListModel<String> parcelListModel = new DefaultListModel<>();
        for (Parcel parcel : parcelMap.getAllParcels()) {
            parcelListModel.addElement(parcel.toString());
        }
        JList<String> parcelList = new JList<>(parcelListModel);
        JScrollPane parcelScrollPane = new JScrollPane(parcelList);
        JPanel parcelPanel = new JPanel(new BorderLayout());
        parcelPanel.add(new JLabel("Parcels"), BorderLayout.NORTH);
        parcelPanel.add(parcelScrollPane, BorderLayout.CENTER);

        // Customer Queue Panel
        DefaultListModel<String> customerListModel = new DefaultListModel<>();
        for (Customer customer : queueOfCustomers.getAllCustomers()) {
            customerListModel.addElement(customer.toString());
        }
        JList<String> customerList = new JList<>(customerListModel);
        JScrollPane customerScrollPane = new JScrollPane(customerList);
        JPanel customerPanel = new JPanel(new BorderLayout());
        customerPanel.add(new JLabel("Customer Queue"), BorderLayout.NORTH);
        customerPanel.add(customerScrollPane, BorderLayout.CENTER);

        // Buttons and Actions
        JButton processButton = new JButton("Process Next Customer");
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!queueOfCustomers.isEmpty()) {
                    Customer customer = queueOfCustomers.removeCustomer();
                    new Worker(parcelMap).processCustomer(customer);
                    customerListModel.remove(0);
                    parcelListModel.clear();
                    for (Parcel parcel : parcelMap.getAllParcels()) {
                        parcelListModel.addElement(parcel.toString());
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "No customers in the queue.");
                }
            }
        });

        // Action Panel
        JPanel actionPanel = new JPanel();
        actionPanel.add(processButton);

        // Add Panels to Frame
        frame.add(parcelPanel, BorderLayout.WEST);
        frame.add(customerPanel, BorderLayout.EAST);
        frame.add(actionPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}