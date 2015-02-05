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

    public EventQueue () {
        deque = new ArrayDeque();
    }

    public void queue(IAction action) {
        deque.add(action);
    }

    public IAction deque() {
        return deque.poll();
    }
    
}
