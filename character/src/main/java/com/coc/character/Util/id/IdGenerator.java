package com.coc.character.Util.id;

/**
 * @author ran_ych
 * @create 2020-05-28  15:47
 * @desc 唯一顺序号生成器接口
 */
public interface IdGenerator {
    /**
     *
     * 生成ID
     * idName 对应的ID在application 范围内要唯一
     * 如果不需要多个应用共用ID生成器，建议使用此方法生成ID
     *
     * @param idName ID name
     * @return ID
     */
    String generateId(String idName);

    /**
     * 在全局范围内唯一ID
     * @param idName ID name
     * @return ID
     */
    String generateGlobalId(String idName);
}

