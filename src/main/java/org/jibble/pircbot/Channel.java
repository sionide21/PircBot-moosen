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
	private Hashtable<String,USER> users;
	private String name;
	private String topic;
	
	/**
	 * Creates a new empty channel with the given name.
	 * @param name The channel name.
	 */
	public Channel(String name) {
		this.users = new Hashtable<String, USER>();
		this.name = name;
		this.topic = "";
	}
	
	/**
	 * Add a user to the list of users for this channel.
	 * 
	 * @param user The user to add.
	 */
	public void addUser(USER user) {
		users.put(user.getNick().toLowerCase(), user);
	}
	
	/**
	 * Remove a user from the list of users for this channel.
	 * 
	 * @param user The user to remove.
	 */
	public USER removeUser(USER user) {
		return users.remove(user.getNick().toLowerCase());
	}
	
	/**
	 * Remove a user from the list of users for this channel.
	 * 
	 * @param user The user to remove.
	 */
	public USER removeUser(String user) {
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
			user.setNick(newName);
			users.put(newName, user);
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
