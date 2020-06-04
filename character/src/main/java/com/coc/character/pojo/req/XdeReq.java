package com.coc.character.pojo.req;

import java.util.Date;

/**
 * @author ran_ych
 * @create 2020-06-04  16:16
 * @desc
 */
public class XdeReq {
    String name1;
    String name2;
    Date data1;
    Date data2;
    String local;
    String jielun;
    String cgl;

    public String getJielun() {
        return jielun;
    }

    public void setJielun(String jielun) {
        this.jielun = jielun;
    }

    public String getCgl() {
        return cgl;
    }

    public void setCgl(String cgl) {
        this.cgl = cgl;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Date getData2() {
        return data2;
    }

    public void setData2(Date data2) {
        this.data2 = data2;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
