/*
 * Copyright (C) 2014 David Sowerby
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package uk.co.q3c.v7.base.user.status;

import java.util.LinkedList;
import java.util.List;

import uk.co.q3c.v7.base.guice.vsscope.VaadinSessionScoped;
import uk.co.q3c.v7.base.navigate.V7Navigator;

import com.google.inject.Inject;

@VaadinSessionScoped
public class DefaultUserStatus implements UserStatus {

	private final List<UserStatusListener> listeners;
	private final V7Navigator navigator;

	@Inject
	protected DefaultUserStatus(V7Navigator navigator) {
		super();
		this.navigator = navigator;
		listeners = new LinkedList<>();
	}

	@Override
	public void addListener(UserStatusListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeListener(UserStatusListener listener) {
		listeners.remove(listener);
	}

	protected void fireListeners() {
		for (UserStatusListener listener : listeners) {
			listener.userStatusChanged();
		}
	}

	@Override
	public void statusChanged() {
		fireListeners();
		navigator.userStatusChanged();
	}
}
