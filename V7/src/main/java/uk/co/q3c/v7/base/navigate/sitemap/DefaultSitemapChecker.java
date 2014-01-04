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

import uk.co.q3c.v7.base.view.V7View;
import uk.co.q3c.v7.i18n.I18NKey;

import com.google.inject.Inject;

/**
 * Checks the Sitemap for inconsistencies after it has been loaded. The following are considered:
 * <ol>
 * <li>Missing views
 * <li>Missing enums
 * <li>public page "inside" a private page
 * </ol>
 * 
 * @author David Sowerby
 * 
 */
public class DefaultSitemapChecker implements SitemapChecker {

	private Sitemap sitemap;

	@Inject
	protected DefaultSitemapChecker(Sitemap sitemap) {
		super();
		this.sitemap = sitemap;
	}

	public Sitemap getSitemap() {
		return sitemap;
	}

	public void setSitemap(Sitemap sitemap) {
		this.sitemap = sitemap;
	}

	@Override
	public void check() {
	}

	@Override
	public SitemapChecker replaceMissingViewWith(Class<? extends V7View> defaultView) {

		return null;
	}

	@Override
	public SitemapChecker replaceMissingKeyWith(I18NKey<?> defaultKey) {

		return null;
	}

}
