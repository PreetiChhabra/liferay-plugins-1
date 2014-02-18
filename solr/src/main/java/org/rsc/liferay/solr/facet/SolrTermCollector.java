package org.rsc.liferay.solr.facet;

import com.liferay.portal.kernel.search.facet.collector.TermCollector;

/**
 * The Class SolrTermCollector.
 */
public class SolrTermCollector implements TermCollector {

    /**
     * Instantiates a new solr term collector.
     * 
     * @param term
     *            the term
     * @param frequency
     *            the frequency
     */
    public SolrTermCollector(String term, int frequency) {
        this.term = term;
        this.frequency = frequency;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.facet.collector.TermCollector#getFrequency()
     */
    @Override
    public int getFrequency() {
        return frequency;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.facet.collector.TermCollector#getTerm()
     */
    @Override
    public String getTerm() {
        return term;
    }

    /** The _frequency. */
    private final int frequency;

    /** The _term. */
    private final String term;

}
