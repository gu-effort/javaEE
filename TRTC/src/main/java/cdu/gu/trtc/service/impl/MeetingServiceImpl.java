package cdu.gu.trtc.service.impl;

import cdu.gu.trtc.dao.TbMeetingDao;
import cdu.gu.trtc.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private TbMeetingDao tbMeetingDao;
    @Override
    public ArrayList<HashMap> searchOnlineMeetingMembers(HashMap param) {
        ArrayList<HashMap> list= tbMeetingDao.searchOnlineMeetingMembers(param);
        return list;
    }
}
