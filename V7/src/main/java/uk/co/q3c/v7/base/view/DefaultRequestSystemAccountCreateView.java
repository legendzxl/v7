package uk.co.q3c.v7.base.view;

import java.util.List;

import com.google.inject.Inject;

public class DefaultRequestSystemAccountCreateView extends StandardPageViewBase implements
		RequestSystemAccountCreateView {

	@Inject
	protected DefaultRequestSystemAccountCreateView() {
		super();
	}

	@Override
	protected void processParams(List<String> params) {
	}

}
