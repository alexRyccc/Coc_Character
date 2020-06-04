package com.coc.createuser.trycatch;

/**
 * @author ran_ych
 * @create 2020-04-27  16:31
 * @desc
 */
public class MyfinallyReadLineThrow {
    public void close() throws Exception {
        throw new Exception("close");
    }

    public void readLine() throws Exception {
        throw new Exception("readLine");
    }

}
