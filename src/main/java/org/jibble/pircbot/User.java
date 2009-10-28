/* 
Copyright Paul James Mutton, 2001-2007, http://www.jibble.org/

This file is part of PircBot.

This software is dual-licensed, allowing you to choose between the GNU
General Public License (GPL) and the www.jibble.org Commercial License.
Since the GPL may be too restrictive for use in a proprietary application,
a commercial license is also provided. Full license information can be
found at http://www.jibble.org/licenses/

*/

package org.jibble.pircbot;

/**
 * This class is used to represent a user on an IRC server.
 * Instances of this class are returned by the getUsers method
 * in the PircBot class.
 *  <p>
 * Note that this class no longer implements the Comparable interface
 * for Java 1.1 compatibility reasons.
 *
 * @since   1.0.0
 * @author  Paul James Mutton,
 *          <a href="http://www.jibble.org/">http://www.jibble.org/</a>
 * @version    1.4.6 (Build time: Wed Apr 11 19:20:59 2007)
 */
public class User {
    
    
    /**
     * Constructs a User object with a known prefix and nick.
     *
     * @param prefix The status of the user, for example, "@".
     * @param nick The nick of the user.
     */
    public User(String nick) {
        _nick = nick;
        _lowerNick = nick.toLowerCase();
    }
    
    /**
     * Returns the nick of the user.
     * 
     * @return The user's nick.
     */
    public String getNick() {
        return _nick;
    }
    
    /**
     * Sets the nick of the user.
     * 
     * @param nick The users new nick.
     */
    public void setNick(String nick) {
		this._nick = nick;
		this._lowerNick = nick.toLowerCase();
	}
    
    
    /**
     * Returns the nick of the user.
     * 
     * @return The user's nick.
     */
    public String toString() {
        return this.getNick();
    }
    
    
    /**
     * Returns true if the nick represented by this User object is the same
     * as the argument. A case insensitive comparison is made.
     * 
     * @return true if the nicks are identical (case insensitive).
     */
    public boolean equals(String nick) {
        return nick.toLowerCase().equals(_lowerNick);
    }
    
    /**
     * Returns true if the nick represented by this User object is the same
     * as the nick of the User object given as an argument.
     * A case insensitive comparison is made.
     * 
     * @return true if o is a User object with a matching lowercase nick.
     */
    public boolean equals(Object o) {
        if (o instanceof User) {
            User other = (User) o;
            return other._lowerNick.equals(_lowerNick);
        }
        return false;
    }
    
    
    /**
     * Returns the hash code of this User object.
     * 
     * @return the hash code of the User object.
     */
    public int hashCode() {
        return _lowerNick.hashCode();
    }
    
    
    /**
     * Returns the result of calling the compareTo method on lowercased
     * nicks. This is useful for sorting lists of User objects.
     * 
     * @return the result of calling compareTo on lowercased nicks.
     */
    public int compareTo(Object o) {
        if (o instanceof User) {
            User other = (User) o;
            return other._lowerNick.compareTo(_lowerNick);
        }
        return -1;
    }
    
    private String _nick;
    private String _lowerNick;
    
}
