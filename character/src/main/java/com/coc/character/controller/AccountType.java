package com.coc.character.controller;

/**
 * @author ran_ych
 * @create 2020-04-30  11:07
 * @desc
 */
enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}
class EnumOne
{
    public static void main(String[]args)
    {
        System.out.println(AccountType.FIXED);
    }
}
