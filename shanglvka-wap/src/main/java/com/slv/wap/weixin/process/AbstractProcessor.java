package com.slv.wap.weixin.process;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slv.wap.controller.weixin.WeixinRequest;

@Service
@Transactional
public abstract class AbstractProcessor implements Processor<WeixinRequest> {

}
