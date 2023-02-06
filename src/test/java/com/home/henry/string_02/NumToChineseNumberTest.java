package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumToChineseNumberTest {

    @Test
    void testIntToChineseNumber() {
        assertEquals("零", NumToChineseNumber.intToChineseNumber(0));
        assertEquals("柒亿捌仟陆佰零肆万零伍佰叁拾贰", NumToChineseNumber.intToChineseNumber(786040532));
        assertEquals("壹拾捌亿玖仟肆佰壹拾柒万肆仟贰佰肆拾柒", NumToChineseNumber.intToChineseNumber(1894174247));
        assertEquals("肆亿伍仟玖佰伍拾壹万陆仟玖佰叁拾", NumToChineseNumber.intToChineseNumber(459516930));
        assertEquals("伍亿壹仟柒佰叁拾贰万伍仟贰佰叁拾伍", NumToChineseNumber.intToChineseNumber(517325235));
        assertEquals("壹拾陆亿肆仟肆佰肆拾贰万柒仟玖佰玖拾贰", NumToChineseNumber.intToChineseNumber(1644427992));
        assertEquals("柒佰叁拾壹万柒仟玖佰伍拾玖", NumToChineseNumber.intToChineseNumber(7317959));
        assertEquals("玖佰贰拾壹", NumToChineseNumber.intToChineseNumber(921));
        assertEquals("壹拾玖亿叁仟肆佰玖拾肆万捌仟叁佰柒拾伍", NumToChineseNumber.intToChineseNumber(1934948375));
        assertEquals("贰拾壹亿肆仟柒佰肆拾捌万叁仟陆佰肆拾陆", NumToChineseNumber.intToChineseNumber(Integer.MAX_VALUE - 1));
    }

}
