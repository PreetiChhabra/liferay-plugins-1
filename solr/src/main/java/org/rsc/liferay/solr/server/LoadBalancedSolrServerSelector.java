package org.rsc.liferay.solr.server;

import java.util.List;
import java.util.TreeSet;

public class LoadBalancedSolrServerSelector implements SolrServerSelector {

	@Override
	public SolrServerWrapper select(
		List<SolrServerWrapper> solrServerWrappers) {

		TreeSet<SolrServerWrapper> sortedSolrServerWrappers =
			new TreeSet<SolrServerWrapper>(new SolrServerWrapperComparator());

		sortedSolrServerWrappers.addAll(solrServerWrappers);

		return sortedSolrServerWrappers.first();
	}

}