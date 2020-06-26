package wac.mall.service;

import wac.mall.domain.Address;

import java.util.List;

public interface AddressService {
    public List<Address> findbyid(Integer id);

    public void saveaddress(Address address);

    public Address findbyaddressid(Integer id);

}
