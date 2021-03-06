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
package uk.co.q3c.v7.base.navigate.sitemap;

import uk.co.q3c.v7.base.shiro.PageAccessControl;
import uk.co.q3c.v7.base.view.V7View;
import uk.co.q3c.v7.i18n.I18NKey;

/**
 * A simple data class to hold an entry for the Sitemap for use with a {@link DirectSitemapModule}. Note that if
 * {@link #pageAccessControl} is {@link PageAccessControl#ROLES}, then roles must be set to a non-empty value, but there
 * is no check for this until the SitemapChecker is invoked. This allows a of Sitemap errors to be captured at once
 * rather than one at a time.
 * 
 * @author David Sowerby
 * 
 */
public class DirectSitemapEntry {
	private PageAccessControl pageAccessControl;
	private Class<? extends V7View> viewClass;
	private I18NKey<?> labelKey;
	private String roles;

	/**
	 * @param viewClass
	 * @param labelKey
	 * @param pageAccessControl
	 */
	public DirectSitemapEntry(Class<? extends V7View> viewClass, I18NKey<?> labelKey,
			PageAccessControl pageAccessControl) {
		super();
		this.pageAccessControl = pageAccessControl;
		this.viewClass = viewClass;
		this.labelKey = labelKey;
	}

	/**
	 * Roles are only used if {@link #pageAccessControl} is {@link PageAccessControl#ROLES}, so if you don't need them
	 * you can use the other constructor.
	 * 
	 * @throws PageAccessControlException
	 *             is {@link #pageAccessControl} is {@link PageAccessControl#ROLES} and roles is null or empty
	 * @param viewClass
	 * @param labelKey
	 * @param pageAccessControl
	 * @param roles
	 *            a comma separated list of roles
	 */
	public DirectSitemapEntry(Class<? extends V7View> viewClass, I18NKey<?> labelKey,
			PageAccessControl pageAccessControl, String roles) {
		super();
		this.pageAccessControl = pageAccessControl;
		this.viewClass = viewClass;
		this.labelKey = labelKey;
		this.roles = roles;
	}

	public Class<? extends V7View> getViewClass() {
		return viewClass;
	}

	public void setViewClass(Class<? extends V7View> viewClass) {
		this.viewClass = viewClass;
	}

	public I18NKey<?> getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(I18NKey<?> labelKey) {
		this.labelKey = labelKey;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public PageAccessControl getPageAccessControl() {
		return pageAccessControl;
	}

	public void setPageAccessControl(PageAccessControl pageAccessControl) {
		this.pageAccessControl = pageAccessControl;
	}

}
