package com.example;

import com.example.model.IpBTaobaoOrder;
import com.jackrain.nea.r3.mq.exception.SendMqException;
import com.jackrain.nea.r3.mq.util.R3MqSendHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProducerAll {
    @Autowired
    private R3MqSendHelper r3MqSendHelper;
    private final String base="测试测试";

    public void send(){
        List<IpBTaobaoOrder> ipBTaobaoOrders = getBaseData(1000);
        try {
            send1(ipBTaobaoOrders);
        }catch (SendMqException e){
            log.error("send error {}", ExceptionUtils.getStackTrace(e));
        }
    }

    private void send1(List<IpBTaobaoOrder> ipBTaobaoOrders) throws SendMqException {
        r3MqSendHelper.sendMessage(ipBTaobaoOrders, Consts.TOPIC1, Consts.Tag);
    }
    public List<IpBTaobaoOrder> getBaseData(int count){
        List<IpBTaobaoOrder> ipBTaobaoOrders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String finalI = String.format("%s%s",base, i);
            int finalI1 = i;
            ipBTaobaoOrders.add(new IpBTaobaoOrder(){{
                setId(finalI1);
                setAbnormalType(finalI);
                setAlipayId(finalI);
                setAlipayNo(finalI);
                setBizCode(finalI);
                setBuyerAlipayNo(finalI);

                setBuyerArea(finalI);
                setBuyerEmail(finalI);
                setBuyerMessage(finalI);
                setBuyerNick(finalI);
                setBuyerRate(finalI);


                setCloudStore(finalI);
                setCodStatus(finalI);
                setCpCShopEcode(finalI);
                setCutoffminutes(finalI);
                setDeliverycps(finalI);


                setErphold(finalI);
                setGatherlastcenter(finalI);
                setGatherstation(finalI);
                setHasYfx(finalI);
                setInvoiceName(finalI);


                setLgAgingType(finalI);
                setMarkDesc(finalI);
                setModifierename(finalI);
                setNumIid(finalI);
                setNutFeature(finalI);


                setO2oShopid(finalI);
                setO2oShopName(finalI);
                setOmnichannelParam(finalI);
                setOrdertype(finalI);
                setOwnerename(finalI);


                setOwnername(finalI);
                setPicPath(finalI);
                setPlatformFlag(finalI);
                setReceiverAddress(finalI);
                setReceiverCity(finalI);

                setReceiverDistrict(finalI);
                setReceiverAddress(finalI);
                setReceiverMobile(finalI);
                setReceiverName(finalI);
                setReceiverPhone(finalI);

                setReceiverState(finalI);
                setReceiverZip(finalI);
                setReserveVarchar01(finalI);
                setReserveVarchar02(finalI);

                setReserveVarchar03(finalI);
                setReserveVarchar04(finalI);
                setReserveVarchar05(finalI);
                setReserveVarchar06(finalI);
                setReserveVarchar07(finalI);

                setReserveVarchar08(finalI);
                setReserveVarchar09(finalI);
                setReserveVarchar10(finalI);
                setSellerCanRate(finalI);
                setSellerFlag(finalI);

                setSellerMemo(finalI);
                setSellerNick(finalI);
                setServiceTag(finalI);
                setServiceType(finalI);
                setShippingType(finalI);
            }});
        }
        return ipBTaobaoOrders;
    }
}
