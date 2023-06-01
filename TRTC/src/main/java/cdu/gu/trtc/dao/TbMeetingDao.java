package cdu.gu.trtc.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface TbMeetingDao {
    public ArrayList<HashMap> searchOnlineMeetingMembers(HashMap param);
}
