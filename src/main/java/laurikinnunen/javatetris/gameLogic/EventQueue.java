/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import java.util.ArrayDeque;

/**
 *
 * @author laurikin
 */
public class EventQueue {

    private final ArrayDeque<IAction> deque;

    /**
     * Create new Queue to hold the various game actions
     */
    public EventQueue () {
        deque = new ArrayDeque();
    }

    /**
     * Adds the given action to the end of the queue
     * @param action
     */
    public void queue(IAction action) {
        deque.add(action);
    }

    /**
     * Removes and returns the head of the queue.
     * Returns null if the queue is empty.
     * @return IAction head of the queue
     */
    public IAction deque() {
        return deque.poll();
    }
    
}
