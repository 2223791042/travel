package guet.hj.travel.service.impl;

import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.HotelVO;
import guet.hj.travel.dao.HotelMapper;
import guet.hj.travel.dao.HotelTypeMapper;
import guet.hj.travel.dto.HotelDTO;
import guet.hj.travel.entity.Hotel;
import guet.hj.travel.entity.HotelExample;
import guet.hj.travel.entity.HotelType;
import guet.hj.travel.entity.NewsExample;
import guet.hj.travel.service.HotelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private HotelTypeMapper hotelTypeMapper;

    @Override
    public List<Hotel> getHotelList(Integer typeId) {
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        criteria.andHotelTypeIdEqualTo(typeId);
        return hotelMapper.selectByExample(example);
    }

    @Override
    public Map<String, Object> getHotelList(Long hotelId, Integer hotelTypeId, String hotelRelease, String hotelName) {
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("hotel_order asc");
        if (hotelId != null){
            criteria.andHotelIdEqualTo(hotelId);
        }
        if (hotelTypeId != null){
            criteria.andHotelTypeIdEqualTo(hotelTypeId);
        }
        if (hotelRelease != null && !hotelRelease.trim().equals("")){
            criteria.andHotelReleaseLike("%"+hotelRelease+"%");
        }
        if (hotelName != null && !hotelName.trim().equals("")){
            criteria.andHotelNameLike("%"+hotelName+"%");
        }
        List<Hotel> hotelList = hotelMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(hotelList);
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        for (Hotel hotel : hotelList){
            HotelDTO hotelDTO = new HotelDTO();
            BeanUtils.copyProperties(hotel, hotelDTO);
            HotelType hotelType = hotelTypeMapper.selectByPrimaryKey(hotel.getHotelTypeId());
            hotelDTO.setHotelType(hotelType);
            hotelDTOList.add(hotelDTO);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("hotelDTOList", hotelDTOList);
        map.put("pageInfo", pageInfo);
        return map;
    }

    @Transactional
    @Override
    public void saveHotel(Hotel hotel) {
        hotelMapper.insertSelective(hotel);
    }

    @Transactional
    @Override
    public void editHotel(Hotel hotel) {
        hotelMapper.updateByPrimaryKeySelective(hotel);
    }

    @Override
    public Hotel getHotel(Long hotelId) {
        return hotelMapper.selectByPrimaryKey(hotelId);
    }

    @Transactional
    @Override
    public void delHotel(Long hotelId) {
        hotelMapper.deleteByPrimaryKey(hotelId);
    }

    @Transactional
    @Override
    public void delBatchHotel(String id_str) {
        String[] ids = id_str.split(",");
        ArrayList<Long> idList = new ArrayList<>();
        for (String id : ids){
            idList.add(Long.parseLong(id));
        }
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        criteria.andHotelIdIn(idList);
        hotelMapper.deleteByExample(example);
    }

    @Override
    public Hotel getHotel(String hotelName) {
        HotelExample example = new HotelExample();
        HotelExample.Criteria criteria = example.createCriteria();
        criteria.andHotelNameEqualTo(hotelName);
        List<Hotel> hotelList = hotelMapper.selectByExample(example);
        if (hotelList.size()!=0){
            return hotelList.get(0);
        }
        return null;
    }

    @Override
    public List<HotelVO> getHotelVOList() {
        ArrayList<HotelVO> hotelVOList = new ArrayList<>();
        List<HotelType> hotelTypeList = hotelTypeMapper.selectByExample(null);
        for(HotelType hotelType : hotelTypeList){
            HotelExample example = new HotelExample();
            example.setOrderByClause("hotel_order asc");
            HotelExample.Criteria criteria = example.createCriteria();
            criteria.andHotelStatusEqualTo("1");
            criteria.andHotelTypeIdEqualTo(hotelType.getTypeId());
            List<Hotel> hotelList = hotelMapper.selectByExample(example);
            if (hotelList.size() != 0){
                HotelVO hotelVO = new HotelVO();
                hotelVO.setHotelType(hotelType.getTypeName());
                hotelVO.setHotelList(hotelList);
                hotelVOList.add(hotelVO);
            }
        }
        return hotelVOList;
    }

}
