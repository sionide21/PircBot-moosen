/*
Copyright (C) 2009  Ben Olive

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, 
Boston, MA  02110-1301, USA.

 */

package org.jibble.pircbot;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


/**
 * This class is used to represent a channel on an IRC server.
 * 
 * @since 1.4.6-MOOSEN-1.0
 * @author Ben Olive
 *
 */
public class Channel<USER extends User> {
	private Hashtable<String, USER> users;
	private Hashtable<String, String> userPrefixes;
	private String name;
	private String topic;
	
	/**
	 * Creates a new empty channel with the given name.
	 * @param name The channel name.
	 */
	public Channel(String name) {
		this.users = new Hashtable<String, USER>();
		this.userPrefixes = new Hashtable<String, String>();
		this.name = name;
		this.topic = "";
	}
	
	/**
	 * Add a user to the list of users for this channel.
	 * 
	 * @param user The user to add.
	 */
	public void addUser(USER user, String prefix) {
		users.put(user.getNick().toLowerCase(), user);
		userPrefixes.put(user.getNick().toLowerCase(), prefix);
	}
	
	/**
	 * Gets a user in this channel.
	 * 
	 * @param nick The users nick.
	 */
	public USER getUser(String nick) {
		return users.get(nick.toLowerCase());
	}
	
	/**
	 * Remove a user from the list of users for this channel.
	 * 
	 * @param user The user to remove.
	 */
	public USER removeUser(USER user) {
		userPrefixes.remove(user.getNick().toLowerCase());
		return users.remove(user.getNick().toLowerCase());
	}
	
	/**
	 * Remove a user from the list of users for this channel.
	 * 
	 * @param user The user to remove.
	 */
	public USER removeUser(String user) {
		userPrefixes.remove(user.toLowerCase());
		return users.remove(user.toLowerCase());
	}
	
	/**
	 * Updates a users name from oldName to newName. If the user
	 * is not in the channel, simply ignore it.
	 * 
	 * @param oldName The name to change from
	 * @param newName The new name to use
	 */
	public void renameUser(String oldName, String newName) {
		USER user = users.remove(oldName);
		if (user != null) {
			String prefix = userPrefixes.remove(oldName);
			user.setNick(newName);
			users.put(newName, user);
			userPrefixes.put(newName, prefix);
		}
	}
	
	/**
	 * Gets a list of the users in this channel.
	 * 
	 * @return The list of users in this channel.
	 */
	public List<USER> getUsers() {
		return new ArrayList<USER>(users.values());
	}
	
	/**
     * Returns the prefix of the user.  This will reflect the user's
     * status in this channel.
     *
     * @return The prefix of the user. If there is no prefix, then an empty
     *         String is returned.
     *       
     * @param nick The users nick
     */
    public String getUserPrefix(String nick) {
    	if (userPrefixes.containsKey(nick)) {
    		return userPrefixes.get(nick);
    	} 
    	return "";
    }
	
	/**
     * Sets the prefix of the user.  This will reflect the user's
     * status in this channel.
     *
     * @param nick The users nick
     * @param prefix The users prefix
     */
    public void setUserPrefix(String nick, String prefix) {
    	if (userPrefixes.containsKey(nick)) {
    		userPrefixes.put(nick, prefix);
    	} 
    }
	
	/**
     * Sets the prefix of the user.  This will reflect the user's
     * status in this channel.
     *
     * @param user The user
     * @param prefix The users prefix
     */
    public void setUserPrefix(USER user, String prefix) {
    	setUserPrefix(user.getNick(), prefix);
    }
    
    /**
     * Returns the prefix of the user.  This will reflect the user's
     * status in this channel.
     *
     * @return The prefix of the user. If there is no prefix, then an empty
     *         String is returned.
     *       
     * @param user The user
     */
    public String getUserPrefix(USER user) {
    	return getUserPrefix(user.getNick().toLowerCase());
    }
    
    /**
     * Returns whether or not the user represented by this object is an
     * operator in this channel.
     * 
     * @return true if the user is an operator in the channel.
     * 
     * @param nick The users nick
     */
    public boolean isOp(String nick) {
        return getUserPrefix(nick).indexOf('@') >= 0;
    }
    
    /**
     * Returns whether or not the user represented by this object is an
     * operator in this channel.
     * 
     * @return true if the user is an operator in the channel.
     * 
     * @param user The user
     */
    public boolean isOp(USER user) {
        return isOp(user.getNick().toLowerCase());
    }
    
    /**
     * Returns whether or not the user represented by this object has
     * voice in this channel.
     * 
     * @return true if the user has voice in the channel.
     * 
     * @param nick The users nick
     */
    public boolean hasVoice(String nick) {
        return getUserPrefix(nick).indexOf('+') >= 0;
    }
    
    /**
     * Returns whether or not the user represented by this object has
     * voice in this channel.
     * 
     * @return true if the user has voice in the channel.
     * 
     * @param user The user
     */
    public boolean hasVoice(USER user) {
        return hasVoice(user.getNick().toLowerCase());
    }
    

	/**
	 * The name of this channel.
	 * @return The channel name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this channel.
	 * 
	 * @param name The channel name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The current topic of this channel.
	 * @return The channel topic.
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Set the channel topic.
	 * @param topic The topic.
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	

}
