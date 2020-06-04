package com.coc.character.serviceimpl;

import com.coc.character.pojo.SysLogBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ran_ych
 * @create 2020-04-22  15:05
 * @desc
 */
@Slf4j
@Service
public class SysLogServiceImpl {
    public boolean save(SysLogBO sysLogBO){
        // 这里就不做具体实现了
        log.info(sysLogBO.getParams());
        return true;
    }
}
