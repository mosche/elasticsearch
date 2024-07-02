/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0 and the Server Side Public License, v 1; you may not use this file except
 * in compliance with, at your election, the Elastic License 2.0 or the Server
 * Side Public License, v 1.
 */

package org.elasticsearch.plugins.internal;

import org.elasticsearch.index.engine.Engine;

/**
 * An interface to allow performing an action when parsing and indexing has been completed
 *
 * FIXME Should this extend {@link org.elasticsearch.index.shard.IndexingOperationListener}?
 * FIXME Should this be renamed to CommitSizeObserver?
 * TODO Move to lib in stateless to simply development, no need to keep this in elasticsearch.
 */
public interface DocumentSizeReporter {
    /**
     * a default noop implementation
     */
    DocumentSizeReporter EMPTY_INSTANCE = new DocumentSizeReporter() {
    };

    /**
     * An action to be performed upon finished indexing.
     */
    default void preIndex(Engine.Index index) {}

    /**
     * An action to be performed upon finished indexing.
     */
    default void onIndex(Engine.Index index, Engine.IndexResult result) {}

    default void onDelete(Engine.Delete delete, Engine.DeleteResult result) {}

    default void beforeFlush() {}

    default void onPrepareCommit(long maxSeqNo) {}

    default void afterFlush() {}

    default CommitSizeAccumulator getCommitSizeAccumulator() {
        return CommitSizeAccumulator.EMPTY_INSTANCE;
    }
}
