package com.coc.createuser.trycatch;

import java.io.Closeable;

/**
 * @author ran_ych
 * @create 2020-04-27  16:34
 * @desc
 */
public class TryfinallyCustomReadLineThrow {
    public static void main(String[] args)   {

        try (MyResource resource = new MyResource();) {
            resource.out();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    static class   MyResource implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("关闭自定义资源");
            throw  new Exception("close()");
        }



        public void out() throws Exception{
            throw new Exception("out()");
        }

    }
}

