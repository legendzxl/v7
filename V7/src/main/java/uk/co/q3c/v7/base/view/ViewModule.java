/*
 * Copyright (C) 2013 David Sowerby
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
package uk.co.q3c.v7.base.view;

import uk.co.q3c.v7.base.guice.uiscope.UIScoped;

import com.google.inject.AbstractModule;

/**
 * 
 * Maps standard views (Login, Logout and Error Views) to their implementations. These can all be overridden if
 * required. Note that the ViewFactory implementation binds V7View instances to UIScoped, so there is no need to
 * annotate the classes, or bind the scope within these module bindings.
 * 
 * @see V7DirectSitemapModule
 * @author David Sowerby 9 Jan 2013
 * 
 */
public class ViewModule extends AbstractModule {

	@Override
	protected void configure() {
		// the fallback in case a View is not defined
		bind(V7View.class).to(ErrorView.class);
		bindErrorView();
		bindLoginView();
		bindLogoutView();
		bindPrivateHomeView();
		bindPublicHomeView();
		bindRequestSystemAccountView();
		bindRequestSystemAccountResetView();
		bindRequestSystemAccountEnableView();
		bindRequestSystemAccountUnlockView();
		bindRequestSystemAccountRefreshView();
		bindSystemAccountView();
		bindViewFactory();

	}

	protected void bindViewFactory() {
		bind(ViewFactory.class).to(DefaultViewFactory.class);
	}

	/**
	 * Override this to provide your own {@link V7View} for the parent page of system account related pages.
	 */
	private void bindSystemAccountView() {
		bind(SystemAccountView.class).to(DefaultSystemAccountView.class);

	}

	/**
	 * Override this to provide your own {@link V7View} for a user to request that their system account is refreshed
	 */
	private void bindRequestSystemAccountRefreshView() {
		bind(RequestSystemAccountRefreshView.class).to(DefaultRequestSystemAccountRefreshView.class);
	}

	/**
	 * Override this to provide your own {@link V7View} for a user to request that their system account is unlocked
	 */
	private void bindRequestSystemAccountUnlockView() {
		bind(RequestSystemAccountUnlockView.class).to(DefaultRequestSystemAccountUnlockView.class);
	}

	/**
	 * Override this to provide your own {@link V7View} for a user to request that their system account is enabled
	 */
	private void bindRequestSystemAccountEnableView() {
		bind(RequestSystemAccountEnableView.class).to(DefaultRequestSystemAccountEnableView.class);
	}

	/**
	 * Override this to provide your own {@link V7View} for a user to request that their system account is reset
	 */
	private void bindRequestSystemAccountResetView() {
		bind(RequestSystemAccountResetView.class).to(DefaultRequestSystemAccountResetView.class);
	}

	/**
	 * Override this to provide your own {@link V7View} for a user to request a system account
	 */
	private void bindRequestSystemAccountView() {
		bind(RequestSystemAccountCreateView.class).to(DefaultRequestSystemAccountCreateView.class);
	}

	/**
	 * Override this to provide your own private home {@link V7View}
	 */
	protected void bindPrivateHomeView() {
		bind(PrivateHomeView.class).to(DefaultPrivateHomeView.class);

	}

	/**
	 * Override this to provide your own public home {@link V7View}
	 */
	protected void bindPublicHomeView() {
		bind(PublicHomeView.class).to(DefaultPublicHomeView.class).in(UIScoped.class);

	}

	/**
	 * Override this to provide your own login {@link V7View}
	 */
	protected void bindLoginView() {
		bind(LoginView.class).to(DefaultLoginView.class);
	}

	/**
	 * Override this to provide your own logout {@link V7View}
	 */
	protected void bindLogoutView() {
		bind(LogoutView.class).to(DefaultLogoutView.class);
	}

	/**
	 * Override to provide your ErrorView
	 */
	protected void bindErrorView() {
		bind(ErrorView.class).to(DefaultErrorView.class);
	}

}
