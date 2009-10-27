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

/**
 * This is the default pircbot implementation. It uses {@link Channel} for
 * the channel type and {@link User} for the user type.
 * 
 * @author Ben Olive
 */
public class PircBot extends AbstractPircBot<User, Channel<User>> {
	
	@Override
	protected Channel<User> createChannel(String name) {
		return new Channel<User>(name);
	}
	
	@Override
	protected User createUser(String flags, String name) {
		return new User(flags, name);
	}
}
