package guet.hj.travel.service.impl;

import guet.hj.travel.dao.HotelTypeMapper;
import guet.hj.travel.entity.HotelType;
import guet.hj.travel.entity.HotelTypeExample;
import guet.hj.travel.service.HotelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelTypeServiceImpl implements HotelTypeService {
    @Autowired
    private HotelTypeMapper hotelTypeMapper;

    @Override
    public List<HotelType> getHotelTypeList() {
        return hotelTypeMapper.selectByExample(null);
    }

    @Override
    public HotelType getHotelType(Integer typeId) {
        return hotelTypeMapper.selectByPrimaryKey(typeId);
    }

    @Transactional
    @Override
    public void delHotelType(Integer typeId) {
        hotelTypeMapper.deleteByPrimaryKey(typeId);
    }

    @Override
    public HotelType getHotelType(String typeName) {
        HotelTypeExample example = new HotelTypeExample();
        HotelTypeExample.Criteria criteria = example.createCriteria();
        criteria.andTypeNameEqualTo(typeName);
        List<HotelType> hotelTypeList = hotelTypeMapper.selectByExample(example);
        if (hotelTypeList.size() != 0){
            return hotelTypeList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public void saveHotelType(HotelType hotelType) {
        hotelTypeMapper.insertSelective(hotelType);
    }
}
