package com.slk.wap.weixin.process;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 复合型消息响应处理
 * 比如关键字回复的有可能响应纯文本 也可以响应图文
 * @author "iacdp"
 *
 */
@Service
@Transactional
public abstract class AbstractCompositeProcessor extends AbstractProcessor {

}
