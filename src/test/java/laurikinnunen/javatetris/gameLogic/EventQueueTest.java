/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author laurikin
 */
public class EventQueueTest {

    private IAction action;
    private EventQueue q;

    @Before
    public void setUp() {
        action = new EmptyAction();
        q = new EventQueue();
    }

    @Test
    public void queueWillAddAnActionToQueue() {
        q.queue(action);
        assertSame(action, q.deque());
    }

    @Test
    public void implementsFiFoPolicy() {
        IAction action2 = new EmptyAction();
        q.queue(action);
        q.queue(action2);
        assertSame(action, q.deque());
    }

    @Test
    public void dequeueOnEmptyQueueReturnsNull() {
        assertEquals(null, q.deque());
    }
}

class EmptyAction implements IAction {

    @Override
    public GameState run(GameState gs) {
        return gs;
    }

}
