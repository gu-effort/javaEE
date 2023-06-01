package cdu.gu.trtc.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;


public interface MeetingService {
    public ArrayList<HashMap> searchOnlineMeetingMembers(HashMap param);
}
