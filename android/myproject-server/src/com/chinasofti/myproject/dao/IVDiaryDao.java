package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.VDiary;

public interface IVDiaryDao {
       public abstract List<VDiary> select(int userid);
}
