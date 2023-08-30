package lexicon.data;

import lexicon.model.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer, Integer>{

    List<Customer> findAll();
}
