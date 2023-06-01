package cdu.gu.trtc.controller;

import cdu.gu.trtc.common.util.R;
import cdu.gu.trtc.controller.form.SearchOnlineMeetingMembersForm;
import cdu.gu.trtc.service.MeetingService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @PostMapping("/searchMeetingMembers")
    @Operation(summary = "查询会议成员")
    @SaCheckLogin
    public R searchOnlineMeetingMembers(@Valid @RequestBody SearchOnlineMeetingMembersForm form){
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        param.put("userId", StpUtil.getLoginIdAsInt());
        ArrayList<HashMap> list=meetingService.searchOnlineMeetingMembers(param);
        return R.ok().put("list",list);
    }
}
