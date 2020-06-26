package wac.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wac.mall.dao.AddressDao;
import wac.mall.domain.Address;
import wac.mall.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;

    @Override
    public List<Address> findbyid(Integer id) {
        return addressDao.findbyid(id);
    }

    @Override
    public void saveaddress(Address address) {
        int defaultValue = address.getDefault_value();
        if (defaultValue==1){
            addressDao.updatevalue(address.getMbr_id());
            addressDao.saveaddress(address);
        }else {
            addressDao.saveaddress(address);
        }
    }

    @Override
    public Address findbyaddressid(Integer id) {
        return addressDao.findbyaddressid(id);
    }
}
