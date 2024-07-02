/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0 and the Server Side Public License, v 1; you may not use this file except
 * in compliance with, at your election, the Elastic License 2.0 or the Server
 * Side Public License, v 1.
 */

package org.elasticsearch.plugins.internal;

import org.apache.lucene.index.SegmentInfos;

import java.util.Collections;
import java.util.Map;
import java.util.function.LongSupplier;

/**
 * An accumulator that returns the summed size deltas of a commit.
 */
public interface CommitSizeAccumulator extends LongSupplier {
    CommitSizeAccumulator EMPTY_INSTANCE = () -> 0;

    // TODO Once clusters are upgraded to write RA-S to the compound commit header, remove this.
    @Deprecated
    default Map<String, String> getAsCommitUserData(SegmentInfos segmentInfos) {
        return Collections.emptyMap();
    }
}
