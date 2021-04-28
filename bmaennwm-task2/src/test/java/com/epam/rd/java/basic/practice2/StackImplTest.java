package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StackImplTest {
    StackImpl stack;

    @Test
    public void size_Expect_StackSize_Is_Zero_IfDont_AddElements() {
        stack = new StackImpl();
        int result = stack.size();
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void push_Expect_StackSize_Is_One_If_AddOne_Element() {
        stack = new StackImpl();
        stack.push("A");
        int result = stack.size();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void clear_Recive_StackSize_IsZero_After_Clear() {
        stack = new StackImpl();
        stack.push("A");
        stack.clear();
        int result = stack.size();
        int expected = 0;
        assertEquals(expected, result);
    }
}