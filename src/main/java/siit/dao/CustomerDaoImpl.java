package siit.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import siit.model.Customer;
import siit.model.Order;

import java.sql.*;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void update(Customer customer) {
        jdbcTemplate.update(
                "update customers set name=?, phone=? where id=?",
                customer.getName(), customer.getPhone(), customer.getId());
    }

    @Override
    public Customer getCustomerById(int id){
        Customer customer = jdbcTemplate.queryForObject(
                "select * from customers where id=?", CUSTOMER_MAPPER, id);
        List<Order> orders = jdbcTemplate.query("select * from orders where customer_id=?",
                                ORDER_MAPPER, id);
        customer.setOrders(orders);

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("select * from customers", CUSTOMER_MAPPER);
    }

    private static RowMapper<Customer> CUSTOMER_MAPPER = new RowMapper<Customer>() {

        @Override
        public Customer mapRow(ResultSet rs, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setPhone(rs.getString("phone"));
            return customer;
        }
    };

    private static RowMapper<Order> ORDER_MAPPER = new RowMapper<Order>() {
        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            return order;
        }
    };
}
