package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class QueueImplTest {
    QueueImpl queue;

    @Test
    public void size_Expect_queueSize_Is_Zero_IfDont_AddElements() {
        queue = new QueueImpl();
        int result = queue.size();
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void enqueue_Expect_SizeOfQueue_Is_One_If_AddOne_Element() {
        queue = new QueueImpl();
        queue.enqueue("A");
        int result = queue.size();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void clear_Recive_Queue_SizeIsZero_IfUseClear() {
        queue = new QueueImpl();
        queue.enqueue("A");
        queue.clear();
        int result = queue.size();
        int expected = 0;
        assertEquals(expected, result);
    }
}