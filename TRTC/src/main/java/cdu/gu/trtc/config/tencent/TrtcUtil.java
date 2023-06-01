package cdu.gu.trtc.config.tencent;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrtcUtil {

    @Value("${tencent.trtc.appId}")
    private int appId;
    @Value("${tencent.trtc.expire}")
    private int expire;
    @Value("${tencent.trtc.secretKey}")
    private String secretKey;

    public String genUserSig(String userId){
        return GenTLSSignature(appId,userId,expire,null,secretKey);
    }

    private String GenTLSSignature(long sdkappid,String userId,long expire,byte[] userbuf,String secretKey) {
        if (StrUtil.isEmpty(prikeyContent)){
            return "";
        }
        long currTime=System.currentTimeMillis()/1000;
        JSONObject sigDoc=new JSONObject();
        sigDoc.set("TLS.ver","2.0");
        sigDoc.set("TLS.identifier",userId);
        sigDoc.set("TLS.sdkappid",sdkappid);
        sigDoc.set("TLS.expire",expire);
        sigDoc.set("TLS.time",currTime);
        return
    }
}
