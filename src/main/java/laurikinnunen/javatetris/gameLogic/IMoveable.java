/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

/**
 *
 * @author laurikin
 * @param <T>
 */
public interface IMoveable<T> {

    public T moveDown();
    public T moveLeft();
    public T moveRight();
    public T moveRelative(int x, int y);
    
}
