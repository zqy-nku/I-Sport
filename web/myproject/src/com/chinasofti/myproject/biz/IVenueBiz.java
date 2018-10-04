package com.chinasofti.myproject.biz;

import java.util.List;

import com.chinasofti.myproject.po.Venue;
import com.chinasofti.myproject.po.Venuecomment;

public interface IVenueBiz {
    public List<Venue> selectBySportid(int sportid);
    public Venue selectById(int venueid);
    public boolean InsertVenueComment(Venuecomment vc);
}
