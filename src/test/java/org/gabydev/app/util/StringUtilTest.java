package org.gabydev.app.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeatStringOnce() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeatStringMultipleTimes() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeatStringZeroTimes() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes() {
        StringUtil.repeat("hola", -1);
    }

    @Test
    public void strIsNoEmpty() {
        boolean result = StringUtil.isEmpty("HolaMundo");
        Assert.assertFalse(result);
    }

    @Test
    public void strIsEmptyWithNoSpaces() {
        boolean result = StringUtil.isEmpty("");
        Assert.assertTrue(result);
    }

    @Test
    public void strIsEmptyWithAnySpaces() {
        boolean result = StringUtil.isEmpty("   ");
        Assert.assertTrue(result);
    }

    @Test
    public void strNullIsEmpty() {
        boolean result = StringUtil.isEmpty(null);
        Assert.assertTrue(result);
    }
}